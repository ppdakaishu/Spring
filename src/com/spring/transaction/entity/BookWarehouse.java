package com.spring.transaction.entity;

//图书仓库
public class BookWarehouse {

	//主键
	private Integer id;
	//图书编号
	private String bookSerialNo;
	//图书库存
	private Integer bookRepertory;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBookSerialNo() {
		return bookSerialNo;
	}
	public void setBookSerialNo(String bookSerialNo) {
		this.bookSerialNo = bookSerialNo;
	}
	public Integer getBookRepertory() {
		return bookRepertory;
	}
	public void setBookRepertory(Integer bookRepertory) {
		this.bookRepertory = bookRepertory;
	}

	
}
