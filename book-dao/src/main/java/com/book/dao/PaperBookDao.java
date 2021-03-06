package com.book.dao;

import java.util.List;

import com.book.model.PaperBookMd;

public interface PaperBookDao {

	public List<PaperBookMd> queryAllBook(Long accountId) throws Exception;

	public void insertBook(PaperBookMd paperBookMd) throws Exception;

	public PaperBookMd queryBookById(Long paperBookId) throws Exception;

	public List<PaperBookMd> queryAllBook() throws Exception;
	
}
