package com.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.dao.AccountInfoDao;
import com.book.model.AccountInfoMd;
import com.book.service.AccountInfoService;

@Service("loginService")
public class AccountInfoServiceImpl implements AccountInfoService {

	@Autowired
	AccountInfoDao accountInfoDao;

	@Override
	public AccountInfoMd queryAccountByName(String accountName, String accountPassword) throws Exception {
		AccountInfoMd accountInfoMd = accountInfoDao.queryByName(accountName);
		if (accountInfoMd != null) {
			if (accountInfoMd.getAccountPassword().equals(accountPassword))
				return accountInfoMd;
		}
		return null;
	}

	@Override
	public AccountInfoMd insertAccount(AccountInfoMd accountInfoMd) throws Exception {
		accountInfoDao.insertAccount(accountInfoMd);
		return accountInfoDao.queryByName(accountInfoMd.getAccountName());
	}

	@Override
	public List<AccountInfoMd> queryAllAccount() throws Exception {
		return accountInfoDao.queryAllAccount();
	}

	@Override
	public void deleteAccountById(Long accountId) throws Exception {
		AccountInfoMd accountInfoMd = accountInfoDao.queryById(accountId);
		accountInfoDao.deleteAccount(accountInfoMd);
	}

	@Override
	public AccountInfoMd queryAccountById(Long accountId) throws Exception {
		return accountInfoDao.queryById(accountId);
	}

	@Override
	public void updateAccount(AccountInfoMd accountInfoMd) throws Exception {
		accountInfoDao.updateAccount(accountInfoMd);
	}
}
