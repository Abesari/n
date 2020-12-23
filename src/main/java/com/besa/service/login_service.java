package com.besa.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.besa.pojo.login_pojo;

public class login_service {

	private HibernateTemplate hibernateTemplate;
	private static Logger log = Logger.getLogger(login_service.class);
	
	private login_service() {}
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@SuppressWarnings( {"unchecked", "deprecation" } )
	public boolean findUser(String uname, String upwd ) {
		log.info("checking user in db");
		boolean isValidUser = false;
	String sqlQuery = "from User u where u.name=? and u.password=?";
	try {
		List<login_pojo> userObj = (List<login_pojo>) hibernateTemplate.find(sqlQuery, uname, upwd);
		if(userObj != null && userObj.size() > 0) {
			log.info("Id= " + userObj.get(0).getId() + ", Name= " + userObj.get(0).getName() + ", Password= " + userObj.get(0).getPassword());
			isValidUser = true;
		}
	} catch(Exception e) {
		isValidUser = false;
		log.error("An error occurred while fetching the user details from the database", e);
	}
		return isValidUser;	
	}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	