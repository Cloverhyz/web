package com.book.dao;

import java.util.List;

import com.book.model.AccountInfoMd;

public interface AccountInfoDao {
	public AccountInfoMd queryByName(String accountName) throws Exception;
	public void insertAccount(AccountInfoMd accountInfoMd) throws Exception;
	public List<AccountInfoMd> queryAllAccount() throws Exception;
	public void deleteAccount(AccountInfoMd accountInfoMd) throws Exception;
	public AccountInfoMd queryById(Long accountId) throws Exception;
	public void updateAccount(AccountInfoMd accountInfoMd) throws Exception;
}
