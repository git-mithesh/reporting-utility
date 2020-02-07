package com.ssn.utility.encryptdecrypt.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.mail.MessagingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Repository;

import com.ssn.utility.encryptdecrypt.beans.User;

@Repository
public class ExecuteSqlQuery extends JdbcDaoSupport{
	
	@Autowired
	DataSource dataSource;
	@Autowired
	 private EmailService emailService;
	public ExecuteSqlQuery(JdbcTemplate jdbcTemplate) {
		setJdbcTemplate(jdbcTemplate);
	}
	public String runQuery(String sql, User user) throws FileNotFoundException, MailException, MessagingException {
		
		 FileOutputStream os=new FileOutputStream("/Users/mitheshjain/Documents/"+user.getName());
		getJdbcTemplate().query(sql,new StreamingCsvResultSetExtractor(os));
		emailService.sendEmailWithAttachment(user);
		return "success"; 
}
}