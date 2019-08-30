package com.spring.transaction.entity;

//图书价目
public class BookPriceList {

	//主键
	private Integer id;
	//图书编号
	private String bookSerialNo;
	//图书价格
	private Integer bookPrice;
	
	
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
	public Integer getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(Integer bookPrice) {
		this.bookPrice = bookPrice;
	}
	
}
