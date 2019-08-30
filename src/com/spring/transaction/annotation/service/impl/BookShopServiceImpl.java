package com.spring.transaction.annotation.service.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.transaction.annotation.dao.BookShopDao;
import com.spring.transaction.annotation.service.BookShopService;

@Service("BookShopService")
public class BookShopServiceImpl implements BookShopService {

	@Autowired
	private BookShopDao bookShopDao;

	//添加事务注解 [ 声明式事务 ]
	//[ 壹 ] 使用 propagation 指定事务传播性, 即当前的事务方法被另外一个事务方法调用时如何使用事务. 
	//          REQUIRED [ 默认取值 ]  :  即使用调用方法的事务.  [ 此处指 BookShopController 中 buyBooks() ]
	//          REQUIRES_NEW : 使用自己的事务, 调用的事务方法的事务被挂起. 
	//[ 贰 ] 使用 isolation 指定事务的隔离级别.  最常用的取值为 READ_COMMITTED
	//[ 叁 ] 默认情况下声明式事务会对所有的运行时异常进行回滚. 也可通过对应的属性进行设置
	//          根据类型指定是否回滚 :  rollbackFor, noRollbackFor
	//          根据类名指定是否回滚 : rollbackForClassName, noRollbackForClassName
	//[ 肆 ] 使用 readOnly 指定事务是否只读.  
	//          表示这个事务只读取数据但不更新数据, 可以帮助数据库引擎优化事务. 
	// [ 伍 ] 使用 timeout 指定强制回滚之前事务可占用时间.  单位 : 秒
	@Transactional(propagation = Propagation.REQUIRES_NEW,
					isolation = Isolation.READ_COMMITTED,
					rollbackFor = {SQLException.class, NullPointerException.class},
					//noRollbackForClassName = {"BookShopServiceImpl"},
					//readOnly = true
					timeout = 3)
	@Override
	public void buyBook(String bookSerialNo, String userName, int gross) {
		//查询书的单价
		int unitPrice = bookShopDao.findBookPriceByBookSerialNo(bookSerialNo);
		//更新图书库存
		bookShopDao.updateBookRepertory(bookSerialNo, gross);
		//更新用户余额
		bookShopDao.updateUserBalance(userName, unitPrice, gross);
	}
	
}
