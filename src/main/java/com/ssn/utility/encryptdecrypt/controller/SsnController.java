package com.ssn.utility.encryptdecrypt.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssn.utility.encryptdecrypt.beans.SsnBean;
import com.ssn.utility.encryptdecrypt.service.EncryptDecryptService;
import com.ssn.utility.encryptdecrypt.service.ExecuteSqlQuery;


@RestController
@RequestMapping("/ssn")
public class SsnController {

	
	  @Autowired 
	  private EncryptDecryptService encryptDecrypt;
	  private static final Logger logger = LoggerFactory.getLogger(SsnController.class);

	   @GetMapping("/encrypt/{ssn}")
	   public String callSsnEncrypt(@PathVariable String ssn){
		   logger.info("Getting the encrypted SSN value for : " + ssn);
		   String encryptedSsn=encryptDecrypt.getEncryptedSsn(ssn);
		   logger.info("Encrypted SSN value for :" + ssn +" is : " + encryptedSsn);
		return "Encrypted SSN is : " + encryptedSsn;
	   }
	   @GetMapping("/decrypt/{ssn}")
	   public String callSsnDecrypt(@PathVariable String ssn){
		   logger.info("Getting the decrypted SSN value for : " + ssn);
		   String decryptedSsn=encryptDecrypt.getDecryptedSsn(ssn);
		   logger.info("Decrypted SSN value for :" + ssn +" is : " + decryptedSsn);

		return "Decrypted SSN is : " + decryptedSsn;
	   }
	   
	   @GetMapping("/encryptUtil")
	   public String encryptSsns(@RequestBody SsnBean ssns){
		   logger.info("Getting the encrypted SSN value for : " + ssns);
		   SsnBean encryptedSsns=encryptDecrypt.generateEncryptedSsn(ssns);
		   logger.info("Encrypted SSN value for :" + encryptedSsns.getId() +" is : " + encryptedSsns.getSsn());
		return "Encrypted SSN is : " + encryptedSsns;
	   }
	   
	 
}
	
