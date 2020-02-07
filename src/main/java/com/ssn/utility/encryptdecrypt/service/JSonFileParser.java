package com.ssn.utility.encryptdecrypt.service;


import java.io.FileNotFoundException;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssn.utility.encryptdecrypt.beans.User;

@Component
public class JSonFileParser{
	  private static final Logger logger = LoggerFactory.getLogger(JSonFileParser.class);

	public User readJsonFile(String jSonData)  throws FileNotFoundException,IOException{
	

		ObjectMapper mapper = new ObjectMapper();
		logger.info("jSonData is " + jSonData);
		User user = mapper.readValue(jSonData,User.class);
		logger.info(user.getEmail());
		return user;
}
}
