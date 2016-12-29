package com.book.dao;

import com.book.model.AccountInfoMd;

public interface AccountInfoDao {
	public AccountInfoMd queryByName(String accountName) throws Exception;
	public void insertAccount(AccountInfoMd accountInfoMd) throws Exception;
}
