package com.spring.transaction.xml.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.transaction.entity.BookPriceList;
import com.spring.transaction.exception.SufficientExcepiton;
import com.spring.transaction.exception.UnderstockException;
import com.spring.transaction.xml.dao.BookShopDao;

public class BookShopDaoImpl implements BookShopDao {

	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int findBookPriceByBookSerialNo(String bookSerialNo) {
		String sql = "SELECT * FROM SPRING_TX_BOOKPRICELIST WHERE BOOKSERIALNO = ?";
		RowMapper<BookPriceList> rowMapper = new BeanPropertyRowMapper<BookPriceList>(BookPriceList.class);
		BookPriceList bookPriceList = jdbcTemplate.queryForObject(sql, rowMapper, bookSerialNo);
		return bookPriceList.getBookPrice();
	}

	@Override
	public void updateBookRepertory(String bookSerialNo, int gross) {
		//检查书的库存是否充足
		String sql = "SELECT BOOKREPERTORY FROM SPRING_TX_BOOKWAREHOUSE WHERE BOOKSERIALNO = ?";
		int bookRepertory = jdbcTemplate.queryForObject(sql, int.class, bookSerialNo);
		if(bookRepertory <= gross) {
			throw new UnderstockException("understock error, repertory : [ " + bookRepertory + " ], gross : [ " + gross + " ]");
		}
		//更新库存量
		sql = "UPDATE SPRING_TX_BOOKWAREHOUSE SET BOOKREPERTORY = BOOKREPERTORY - ? WHERE BOOKSERIALNO = ?";
		jdbcTemplate.update(sql, gross, bookSerialNo);
	}

	@Override
	public void updateUserBalance(String userId, int bookPrice, int gross) {
		//检查用户余额是否充足
		String sql = "SELECT USERBALANCE FROM SPRING_TX_USER WHERE USERNAME = ?";
		int userBalance = jdbcTemplate.queryForObject(sql, int.class, userId);
		if(userBalance <= 0 || userBalance < bookPrice * gross) {
			throw new SufficientExcepiton("sufficient error, userBalance : [ " + userBalance + " ], "
											+ "total prices : [ " +  bookPrice * gross + " ]");
		}
		//更新用户余额
		sql = "UPDATE SPRING_TX_USER SET USERBALANCE = USERBALANCE - ? WHERE USERNAME = ?";
		jdbcTemplate.update(sql, bookPrice * gross, userId);
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
}
