package com.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.dao.PaperBookDao;
import com.book.model.PaperBookMd;
import com.book.service.PaperBooKService;

@Service("paperBooKService")
public class PaperBookServiceImpl implements PaperBooKService {

	@Autowired
	PaperBookDao paperBookDao;

	@Override
	public List<PaperBookMd> queryAllBook(Long accountId) throws Exception {
		return paperBookDao.queryAllBook(accountId);
	}

	@Override
	public void insertBook(PaperBookMd paperBookMd) throws Exception {
		paperBookDao.insertBook(paperBookMd);
	}

	@Override
	public PaperBookMd queryBookById(Long paperBookId) throws Exception {
		return paperBookDao.queryBookById(paperBookId);
	}

	@Override
	public List<PaperBookMd> queryAllBook() throws Exception {
		return paperBookDao.queryAllBook();
	}

}
