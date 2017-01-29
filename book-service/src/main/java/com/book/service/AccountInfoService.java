package com.book.service;

import java.util.List;

import com.book.model.AccountInfoMd;

public interface AccountInfoService {
	
	public AccountInfoMd queryAccountByName(String accountName,String accountPassword) throws Exception;
	public boolean insertAccount(AccountInfoMd accountInfoMd) throws Exception;
	public List<AccountInfoMd> queryAllAccount() throws Exception;
	public void deleteAccountById(Long accountId) throws Exception;
	public AccountInfoMd queryAccountById(Long accountId) throws Exception;
	public void updateAccount(AccountInfoMd accountInfoMd) throws Exception;

}
