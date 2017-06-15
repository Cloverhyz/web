package com.tujia.config.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

public class ResponseUtil {

	public static void responseAsString(HttpServletResponse response,String resText) throws IOException{
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().print(resText);
		response.getWriter().flush();
	}
	
}
