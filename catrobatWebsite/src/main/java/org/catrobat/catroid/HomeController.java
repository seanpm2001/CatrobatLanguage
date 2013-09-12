package org.catrobat.catroid;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {

		return "home";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String Upload(
			@RequestParam(value = "file", required = true) MultipartFile file)
			throws IOException {
		// TODO: check type .catrobat

		
		String fileName = file.getOriginalFilename();
		String projectName = new StringBuffer(fileName).substring(0,
				fileName.length() - 9);
		System.out.println(projectName);
		
		// String tempFolder = System.getProperty("java.io.tmpdir");
		String tempFolder = "D:/Users/TDiva/Desktop/temp/" + projectName;
		File projectDir = new File(tempFolder);
		if (projectDir.exists())
			projectDir.delete();
		if (!projectDir.mkdir()) 
			System.out.println("Cannot create project directory.");

		String filePath = tempFolder + "/" + file.getOriginalFilename();
		FileOutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(new File(filePath));
			outputStream.write(file.getBytes());
			outputStream.close();
		} catch (Exception e) {
			// TODO: create error page
			System.out.println("Error while saving file");
			return "error";
		}

		ZipFile zip;
		try {
			zip = new ZipFile(filePath);
			zip.extractAll(tempFolder);
		} catch (ZipException e) {
			e.printStackTrace();
		}

		return "home";
	}

}