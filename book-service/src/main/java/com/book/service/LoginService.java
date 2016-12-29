package com.book.service;

import com.book.model.AccountInfoMd;

public interface LoginService {
	
	public boolean queryAccountByName(String accountName,String accountPassword) throws Exception;
	public boolean insertAccount(AccountInfoMd accountInfoMd) throws Exception;

}
