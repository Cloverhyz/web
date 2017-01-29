package com.book.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.book.model.BookListMd;
import com.book.model.PaperBookMd;
import com.book.service.BookSaleService;
import com.book.service.PaperBooKService;

@Controller
@RequestMapping("buy360")
public class BookSaleController {
/*
	@Autowired
	private BookSaleService bookSaleService;
	@Autowired
	private PaperBooKService paperBooKService;

	@RequestMapping("addToCart")
	@ResponseBody
	public void addToCart(HttpServletRequest request,HttpServletResponse response, BookListMd bookListMd) throws Exception {
		String result = "";
		try{
			String accountId = request.getSession().getAttribute("AccountId").toString();
			if (accountId!=null) {
				bookListMd.setAccountId(Long.valueOf(accountId));
				//bookSaleService.addToCart(bookListMd);
				result = "已成功添加";
			}
		}catch (Exception e) {
			result = "登录时间过长，为了您的账号安全，请重新登录！";
		}
		 response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html");
			response.getWriter().print(result);
			response.getWriter().flush();
	}

	@RequestMapping("bookSale")
	public String bookSale(HttpServletRequest request) throws Exception {
		List<PaperBookMd> bookMds = paperBooKService.queryAllBook();
		request.setAttribute("bookMds", bookMds);
		return "buy360/bookSale";
	}*/

}
