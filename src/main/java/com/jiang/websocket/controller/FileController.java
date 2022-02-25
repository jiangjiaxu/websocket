package com.jiang.websocket.controller;

import com.jiang.websocket.entity.bo.Result;
import com.jiang.websocket.entity.bo.User;
import com.jiang.websocket.util.Word2PdfUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author:jiangjiaxu
 * @date 2022/02/17  15:28
 * @version:V1.0
 * @description:
 */
@RestController
public class FileController {

	@PostMapping("/file")
	public String login(HttpServletResponse response,MultipartFile file) throws Exception {
		String filename = file.getOriginalFilename();
		String name = filename.substring(0, filename.lastIndexOf("."));
		String os = System.getProperty("os.name");
		String pdfPath="";
		//Windows操作系统
		if (os != null && os.toLowerCase().startsWith("windows")) {
			System.out.println(String.format("当前系统版本是:%s", os));
			pdfPath="D:\\download\\"+name+".pdf";
		} else if (os != null && os.toLowerCase().startsWith("linux")) {//Linux操作系统
			System.out.println(String.format("当前系统版本是:%s", os));
			pdfPath="\"/home/pdf/\"+name+\".pdf\"";
		} else { //其它操作系统
			System.out.println(String.format("当前系统版本是:%s", os));
		}

		Word2PdfUtil.doc2pdf(file.getInputStream(),pdfPath);

		Word2PdfUtil.downloadPdf(response,new File(pdfPath));
		System.out.println("转换成功");
		return "转换成功";
	}

//	public static void main(String[] args) {
//		int a=1>2?3:4;
//		System.out.println(a);
//		System.out.println(1>2?3:4);
//	}
}
