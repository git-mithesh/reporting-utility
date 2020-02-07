package com.ssn.utility.encryptdecrypt.service;

import org.springframework.stereotype.Component;

import com.ssn.utility.encryptdecrypt.beans.SsnBean;

@Component
public class EncryptDecryptService {

	
	/*
	 * public EncryptDecryptService(){
	 * 
	 * }
	 */
	public String getEncryptedSsn(String ssn) {
		// TODO Auto-generated method stub
		return "9E234fdf35636";
	}

	public String getDecryptedSsn(String ssn) {
		// TODO Auto-generated method stub
		return "12334566";
	}

	public SsnBean generateEncryptedSsn(SsnBean ssns) {
		// TODO Auto-generated method stub
		return new SsnBean(1,"sadfh3434234");
	}
}
