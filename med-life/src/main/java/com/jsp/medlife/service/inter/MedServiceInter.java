package com.jsp.medlife.service.inter;

import com.jsp.medlife.Model.Entities.User;

public interface MedServiceInter 
{
	public Object saveMed(User u); 
	public Object findByLogin(String email,String pass);
	public Object findByForgetPass(String email,String password,String confirmpass);
	
	


}
