package com.book.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PaperBook")
public class PaperBookMd implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 789456123L;
	private Long paperBookId;
	private Long accountId;
	private String bookName;
	private Integer bookPrice;
	private String bookPicPath;
	private String description;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PaperBookId")
	public Long getPaperBookId() {
		return paperBookId;
	}

	public void setPaperBookId(Long paperBookId) {
		this.paperBookId = paperBookId;
	}
	@Column(name = "AccountId")
	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	@Column(name = "BookName")
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	@Column(name = "BookPrice")
	public Integer getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(Integer bookPrice) {
		this.bookPrice = bookPrice;
	}
	@Column(name="BookPicPath")
	public String getBookPicPath() {
		return bookPicPath;
	}

	public void setBookPicPath(String bookPicPath) {
		this.bookPicPath = bookPicPath;
	}
	@Column(name="Description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
