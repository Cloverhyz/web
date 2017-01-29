package com.book.controller;

import java.io.File;
import java.util.List;

import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.book.model.PaperBookMd;
import com.book.service.PaperBooKService;

@Controller
@RequestMapping("bookInfo")
public class BookInfoController {
	
	@Autowired
	private PaperBooKService paperBooKService;
	
	@RequestMapping("paperBookUpload")
	public String paperBookUpload(HttpServletRequest request){
		HttpSession session = request.getSession();
		request.setAttribute("accountId", session.getAttribute("AccountId"));
		System.out.println(session.getAttribute("AccountId"));
		return "bookInfo/paperBookUpload";
	}
	
	@RequestMapping("uploadpaperbook")
	public String uploadPaperBook(MultipartHttpServletRequest request, PaperBookMd paperBookMd,@RequestParam MultipartFile file) throws Exception{
		paperBookMd.setBookName(new String(paperBookMd.getBookName().getBytes("iso-8859-1"),"UTF-8"));
		paperBookMd.setDescription(new String(paperBookMd.getDescription().getBytes("iso-8859-1"),"UTF-8"));
		String fileName = new String(file.getOriginalFilename().getBytes("iso-8859-1"),"UTF-8"); 
		String path = "D:\\book_share\\" + paperBookMd.getAccountId().toString() + "\\";
		File pic = new File(path);
		if (!pic.exists()) {
			pic.mkdirs();
		}
		File f = new File(pic, fileName);
		FileImageOutputStream fileImageOutputStream = new FileImageOutputStream(f);
		fileImageOutputStream.write(file.getBytes());
		fileImageOutputStream.flush();
		fileImageOutputStream.close();
		paperBookMd.setBookPicPath(path + fileName);
		System.out.println(paperBookMd.getAccountId().toString());
		paperBooKService.insertBook(paperBookMd);
		List<PaperBookMd> paperBookMds = paperBooKService.queryAllBook(paperBookMd.getAccountId());
		request.setAttribute("paperBookMds", paperBookMds);
		return "redirect:/bookInfo/bookInfo";
	}
	
	@RequestMapping("bookInfo")
	public String getbookInfo(HttpServletRequest request) throws Exception{
		Long accountId = (Long) request.getSession().getAttribute("AccountId");
		System.out.println(accountId);
		List<PaperBookMd> paperBookMds = paperBooKService.queryAllBook(accountId);
		request.setAttribute("paperBookMds", paperBookMds);
		return "bookInfo/bookInfo";
	}
}
