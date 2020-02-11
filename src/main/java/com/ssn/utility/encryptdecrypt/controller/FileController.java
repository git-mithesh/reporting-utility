package com.ssn.utility.encryptdecrypt.controller;

import java.io.IOException;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssn.utility.encryptdecrypt.beans.User;
import com.ssn.utility.encryptdecrypt.service.EmailService;
import com.ssn.utility.encryptdecrypt.service.ExecuteSqlQuery;
import com.ssn.utility.encryptdecrypt.service.JSonFileParser;
@RestController
@RequestMapping("/reporting")
public class FileController {
	 @Autowired
	  private ExecuteSqlQuery executeSqlquery;
	 @Autowired
	 private JSonFileParser jsonFileParser;
	 
	  private static final Logger logger = LoggerFactory.getLogger(FileController.class);

	  @PostMapping("/uploadFile")
	   public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("jsonFile") MultipartFile jsonFile) throws IOException, MailException, MessagingException {
		   String queryFile=file.getOriginalFilename();
		   
		   byte[] bytes = file.getBytes();
          String sqlQuery = new String(bytes);
          
          logger.info(sqlQuery);
          String jSonFileName=jsonFile.getOriginalFilename();
          byte[] jSonByte = jsonFile.getBytes();
          String jSonData = new String(jSonByte);
          User user=jsonFileParser.readJsonFile(jSonData);
          logger.info(executeSqlquery.runQuery(sqlQuery,user));
          
		
		   return "You will receive the results to the email id : " + user.getEmail(); 
	   }
}
