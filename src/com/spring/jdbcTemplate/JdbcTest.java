package com.spring.jdbcTemplate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

class JdbcTest {

	private ApplicationContext ctx;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Test
	void testDataSource() throws SQLException {
		ctx = new FileSystemXmlApplicationContext("src/com/spring/jdbc/applicationContext-jdbcTemplate.xml");
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		System.out.println(dataSource.getConnection());
		jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
	}
	
	private void createDataSource() {
		try {
			ctx = new FileSystemXmlApplicationContext("src/com/spring/jdbc/applicationContext-jdbcTemplate.xml");
			DataSource dataSource = (DataSource) ctx.getBean("dataSource");
			System.out.println(dataSource.getConnection());
			jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
			namedParameterJdbcTemplate = ctx.getBean(NamedParameterJdbcTemplate.class);
		} catch (SQLException e) {
			System.out.println("dataSource.getConnection error" + e);
		}
	}
	
	/** 测试单条数据的 [ 新增 \ 更新 \ 删除 ] 操作 */
	@Test
	void testEinzelband() {
		createDataSource(); //创建数据连接, 声明jdbcTemplate
		String sql = "UPDATE SPRING_JDBC SET EMAIL = ? WHERE ID = ?";
		jdbcTemplate.update(sql, "70129527@qq.com", "5");
	}
	
	/** 测试批量数据的 [ 新增 \ 更新 \ 删除 ] 操作 */
	@Test
	void testBatch() {
		createDataSource(); //创建数据连接, 声明jdbcTemplate
		String sql = "INSERT INTO SPRING_JDBC (ID, NAME, AGE, EMAIL) VALUES (?, ? , ?, ?)";
		List<Object[]> batchArgs = new ArrayList<Object[]>();
		batchArgs.add(new Object[] {"6", "F", "25", "70129526@qq.com"});
		batchArgs.add(new Object[] {"7", "I", "25", "70129526@qq.com"});
		batchArgs.add(new Object[] {"8", "J", "25", "70129526@qq.com"});
		batchArgs.add(new Object[] {"9", "K", "25", "70129526@qq.com"});
		//batchArgs : Object 数组的集合
		jdbcTemplate.batchUpdate(sql, batchArgs); 
	}
	
	/** 测试单条数据的 [ 查询 ] 操作 */
	@Test
	void testEinzelbandQuery() {
		createDataSource(); //创建数据连接, 声明jdbcTemplate
		//需要调用 queryForObject(String sql, RowMapper<Dto> rowMapper, @Nullable Object... args) 方法
		// 1. 其中的 rowMapper 指定如何去映射结果集的行.  常用的实现类为 BeanPropertyRowMapper
		// 2. 使用 SQL 中列的别名完成列名和类中属性名的映射.  例如 : SELECT LAST_NAME AS LASTNAME FROM ..
		// 3. 不支持级联属性查询.  JdbcTemplate 是 JDBC 的小工具.  不是 ORM 框架
		String sql = "SELECT * FROM SPRING_JDBC WHERE ID = ?";
		RowMapper<Dto> rowMapper = new BeanPropertyRowMapper<Dto>(Dto.class);
		Dto dto = jdbcTemplate.queryForObject(sql, rowMapper, "1");
		System.out.println(dto);
	}
	
	/** 测试批量数据的 [ 查询 ] 操作 */
	@Test
	void testBatchQuery() {
		createDataSource(); //创建数据连接, 声明jdbcTemplate
		String sql = "SELECT * FROM SPRING_JDBC WHERE ID > ?";
		RowMapper<Dto> rowMapper = new BeanPropertyRowMapper<Dto>(Dto.class);
		List<Dto> dtos = jdbcTemplate.query(sql, rowMapper, "2");
		System.out.println(dtos);
	}
	
	/** 获取单个列的值, 或做查询统计 */
	@Test
	void testQuerySingleFiled() {
		createDataSource(); //创建数据连接, 声明jdbcTemplate
		String sql = "SELECT COUNT(*) FROM SPRING_JDBC";
		
		long countNumber = jdbcTemplate.queryForObject(sql, long.class);
		System.out.println(countNumber);
		
		sql = "SELECT NAME FROM SPRING_JDBC WHERE ID = ?";
		String name = jdbcTemplate.queryForObject(sql, String.class, "1");
		System.out.println(name);
	}
	
	/** NamedParameterJdbcTemplate 使用具名参数 */
	@Test
	void testNamedParameterJdbcTemplate() {
		createDataSource(); //创建数据连接, 声明NamedParameterJdbcTemplate
		String sql = "INSERT INTO SPRING_JDBC ( ID, NAME, AGE, EMAIL ) VALUES ( :ID, :NAME, :AGE, :EMAIL )";
		
		//参数为 String sql, Map<String, Object> paramMap
		//好处 : 若有多个参数, 不用再去对相应位置, 直接对应参数名. 便于维护
		//缺点 : 较为麻烦
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("ID", "99");
		paramMap.put("NAME", "CHENBOWEN");
		paramMap.put("AGE", "25");
		paramMap.put("EMAIL", "1027616230@qq.com");
		namedParameterJdbcTemplate.update(sql, paramMap);
		
		//1. SQL 语句中的参数名和类的属性名要保持一致
		//2.  使用 SqlParameterSource 的 BeanPropertySqlParameterSource 实现类作为作为参数
		sql = "INSERT INTO SPRING_JDBC ( ID, NAME, AGE, EMAIL ) VALUES ( :id, :name, :age, :email )";
		Dto dto = new Dto("1025", "CHENBOWEN", "25", "70129526@QQ.COM");
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(dto);
		namedParameterJdbcTemplate.update(sql, paramSource);
	}
	
}
