package com.book.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.book.model.AccountInfoMd;
import com.book.service.AccountInfoService;

/**
 * Hello world!
 *
 */
@Controller
@RequestMapping("accountInfo")
public class AccountInfoController {
	@Autowired
	AccountInfoService accountInfoService;

	@RequestMapping(value = "Hello")
	public String toLogin(HttpServletResponse response) throws IOException {
		/*
		 * jedisCluster.set("foo", "bar"); String value =
		 * jedisCluster.get("foo"); System.out.println(value);
		 * jedisCluster.close();
		 */
		return "accountInfo/login";
	}

	@RequestMapping(value = "login")
	public String userLogin(HttpServletRequest request, AccountInfoMd accountInfoMd) throws Exception {
		AccountInfoMd result;
		result = accountInfoService.queryAccountByName(accountInfoMd.getAccountName(),
				accountInfoMd.getAccountPassword());
		if (result != null) {
			HttpSession session = request.getSession();
			session.setAttribute("AccountId", result.getAccountId());
			//jedisCluster.set(SerializeUtils.serialize(result.getAccountId(), Long.class),SerializeUtils.serialize(session, HttpSession.class));
			return "redirect:/bookInfo/paperBookUpload";
		}
		return "accountInfo/login";
	}

	@RequestMapping(value = "mlogin")
	@ResponseBody
	public String userMLogin(HttpServletRequest request)  {
		AccountInfoMd result = null;
		try {
			result = accountInfoService.queryAccountByName(request.getParameter("accountName"),request.getParameter("accountPassword"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result =null;
		}
		if (result != null) {
			request.getSession();
			//jedisCluster.set(SerializeUtils.serialize(result.getAccountId(), Long.class),SerializeUtils.serialize(session, HttpSession.class));
			return result.getAccountId().toString();
		}
		return "error";
	}

	@RequestMapping(value = "register")
	@ResponseBody
	public String userRegister(AccountInfoMd accountInfoMd) throws Exception {
		AccountInfoMd result = null;
		result = accountInfoService.insertAccount(accountInfoMd);
		if (result!=null) {
			return "success";
		}
		return "error";
	}

	@RequestMapping(value = "delete")
	@ResponseBody
	public String userdelete(Long accountId) throws Exception {
		// String accountId = request.getParameter("accountId");
		if (accountId != null)
			accountInfoService.deleteAccountById(Long.valueOf(accountId));
		return "delete success";
	}

	@RequestMapping(value = "toUpdate")
	public ModelAndView userToUpdate(HttpServletRequest request, Long accountId) throws Exception {
		// String accountId = request.getParameter("accountId");
		if (accountId != null) {
			AccountInfoMd accountInfoMd;
			accountInfoMd = accountInfoService.queryAccountById(accountId);
			request.setAttribute("accountInfo", accountInfoMd);
		}
		return new ModelAndView("accountInfo/accountEdit");
	}

	@RequestMapping(value = "update")
	public ModelAndView userUpdate(AccountInfoMd accountInfoMd) throws Exception {
		accountInfoService.updateAccount(accountInfoMd);
		return new ModelAndView("redirect:/accountInfo/accountInfo");
	}
	@RequestMapping(value = "mUpdate")
	@ResponseBody
	public String mUserUpdate(AccountInfoMd accountInfoMd) throws Exception {
		accountInfoService.updateAccount(accountInfoMd);
		return "success";
	}

	@RequestMapping(value = "uploadPic")
	@ResponseBody
	public String uploadPic(MultipartHttpServletRequest request, String accountId, @RequestParam MultipartFile file)
			throws Exception {
		String fileName = file.getOriginalFilename();
		String path = "D:\\book_share\\" + accountId + "\\";
		File pic = new File(path);
		if (!pic.exists()) {
			pic.mkdirs();
		}
		File f = new File(pic, fileName);
		FileImageOutputStream fileImageOutputStream = new FileImageOutputStream(f);
		fileImageOutputStream.write(file.getBytes());
		fileImageOutputStream.flush();
		fileImageOutputStream.close();
		AccountInfoMd accountInfoMd = accountInfoService.queryAccountById(Long.valueOf(accountId));
		accountInfoMd.setPicPath(path + fileName);
		accountInfoService.updateAccount(accountInfoMd);
		return path + fileName;
	}

	@RequestMapping(value = "accountInfo")
	public String getAccountInfo(HttpServletRequest request) throws Exception {
		List<AccountInfoMd> accountInfoMds = accountInfoService.queryAllAccount();
		request.setAttribute("accountInfo", accountInfoMds);
		return "accountInfo/accountInfo";
	}
}
