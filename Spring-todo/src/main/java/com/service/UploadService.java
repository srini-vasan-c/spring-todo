package com.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

public class UploadService {

	public String uploadFile(MultipartFile file, HttpSession session) {
		String path = session.getServletContext().getRealPath("/");
		String filename = file.getOriginalFilename();
		String fullPath = path + "/WEB-INF/assert/UploadFiles/" + filename;
		System.out.println(fullPath);
		String uploadMsg = "";
		try {
			byte barr[] = file.getBytes();

			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(fullPath));
			bout.write(barr);
			bout.flush();
			bout.close();
			uploadMsg = "File Uploaded Successfully";

		} catch (Exception e) {
			uploadMsg = e.getMessage();
		}
		return uploadMsg;
	}
}
