package com.book.controller;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStreamImpl;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.book.model.AccountInfoMd;
import com.book.model.PaperBookMd;
import com.book.service.AccountInfoService;
import com.book.service.PaperBooKService;

@Controller
@RequestMapping("picture")
public class PictureTest {

	@Autowired
	AccountInfoService accountInfoService;
	@Autowired
	PaperBooKService paperBooKService;

	@RequestMapping("headPic")
	public void getHead(Long accountId, HttpServletResponse response) throws Exception {
		AccountInfoMd accountInfoMd = accountInfoService.queryAccountById(accountId);
		String path = accountInfoMd.getPicPath();
		FileInputStream fileInputStream = new FileInputStream(new File(path));
		int i = fileInputStream.available();
		byte[] data = new byte[i];
		fileInputStream.read(data);
		response.setContentType("image/*");
		OutputStream outStream = response.getOutputStream(); // 得到向客户端输出二进制数据的对象
		outStream.write(data);
		outStream.flush();
		outStream.close();
		fileInputStream.close();
	}
	
	@RequestMapping("bookPic")
	public void getBookPic(Long paperBookId,HttpServletResponse response) throws Exception{
		PaperBookMd paperBookMd = paperBooKService.queryBookById(paperBookId);
		String path = paperBookMd.getBookPicPath();
		FileInputStream fileInputStream = new FileInputStream(new File(path));
		int i = fileInputStream.available();
		byte[] data = new byte[i];
		fileInputStream.read(data);
		response.setContentType("image/*");
		OutputStream outputStream = response.getOutputStream();
		outputStream.write(data);
		outputStream.flush();
		outputStream.close();
		fileInputStream.close();
	}

}
