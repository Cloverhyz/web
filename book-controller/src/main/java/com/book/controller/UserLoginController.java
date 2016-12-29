package com.book.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.book.model.AccountInfoMd;
import com.book.service.LoginService;

/**
 * Hello world!
 *
 */
@Controller
public class UserLoginController 
{
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "/Hello")
    public String toLogin (HttpServletResponse response) throws IOException
    {
		System.out.println("hello world");
		return "index";
    }
	@RequestMapping(value = "/login")
	public String userLogin (AccountInfoMd accountInfoMd) throws Exception
	{
		boolean result = false;
		result = loginService.queryAccountByName(accountInfoMd.getAccountName(),accountInfoMd.getAccountPassword());
		if(result){
			return "success";
		}
		return "index";
	}
	@RequestMapping(value = "/register")
	public String userRegister (AccountInfoMd accountInfoMd) throws Exception
	{
		boolean result = false;
		loginService.insertAccount(accountInfoMd);
		if(result){
			return "success";
		}
		return "index";
	}
}
