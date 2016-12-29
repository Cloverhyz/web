package com.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.dao.AccountInfoDao;
import com.book.model.AccountInfoMd;
import com.book.service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	AccountInfoDao accountInfoDao;

	@Override
	public boolean queryAccountByName(String accountName,String accountPassword) throws Exception {
		AccountInfoMd accountInfoMd = accountInfoDao.queryByName(accountName);
		if(accountPassword.equals(accountInfoMd.getAccountPassword())){
			return true;
		}
		return false;
	}

	@Override
	public boolean insertAccount(AccountInfoMd accountInfoMd) throws Exception {
		accountInfoDao.insertAccount(accountInfoMd);
		return false;
	}

}
