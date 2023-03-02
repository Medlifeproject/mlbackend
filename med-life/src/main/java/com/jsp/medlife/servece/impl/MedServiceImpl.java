package com.jsp.medlife.servece.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.medlife.Model.Entities.User;
import com.jsp.medlife.exception.ResourceNotFoundFoure;
import com.jsp.medlife.exception.ResourceNotFountException;
import com.jsp.medlife.exception.ResourceNotFountExcepyionTwo;
import com.jsp.medlife.exception.ResourceNotfoundExceptionthree;
import com.jsp.medlife.repository.MedRepo;
import com.jsp.medlife.service.inter.MedServiceInter;

@Service
public class MedServiceImpl implements MedServiceInter {
	
	
	@Autowired
	private MedRepo medrepo;

//----------------->>>> SIGNUP	<<<-----------------
//-----------------<<<<         >>>-----------------
	@Override
	public Object saveMed(User u) {
		String em = medrepo.findByEmail(u.getEmail());
		String us = medrepo.findByUserName(u.getUsername());

		if (em == null ) 
		{
            if (us == null)
            {
				User li = medrepo.save(u);
				return li;
			 }

			else 
			{
				try {
					throw new ResourceNotFountException("User", "u",u);
				} catch (ResourceNotFountException e) {
					System.out.println(e);
					return e.getMessage();
				}
			}
		} 
		else 
		{
			try 
			{
				throw new ResourceNotFountException("User", "u", u);
			} 
			catch (ResourceNotFountException e) {
				System.out.println(e);
				return e.getMessage();
			}
		}
	}
	
	
//----------------->>>> LOGIN	<<<-----------------
//-----------------<<<<         >>>-----------------
	@Override
	public Object findByLogin(String email, String password) {
		  User ema = medrepo.findByPassword(password, email);
		  System.out.println(ema);
		//  System.out.println(((User) ema).getPassword()+" "+((User) ema).getUsername());
		   if(ema!=null )
		   {
			   if( ema.getPassword().equals(password))
			   {
				   return ema;
			   }
			   else
			   {
				   try
				   {
					   throw new ResourceNotFountExcepyionTwo("User","ema",password,email);
				   }
				   catch(ResourceNotFountExcepyionTwo re)
				   {
					   System.out.println(re);
					   return re.getMessage();
				   }
			   }
		   }
		   else
		   {
			   try
			   {
				   throw new ResourceNotFountExcepyionTwo("User", "u", email,password);
			   }
			   catch(ResourceNotFountExcepyionTwo tyu)
			   {
				   System.out.println(tyu);
				   return tyu.getMessage();
			   }
		   }
		
	}

//----------------->>>> Forget Password	<<<-----------------
//-----------------<<<<                  >>>-----------------
	@Override
	public Object findByForgetPass(String email, String password, String confirmpass) 
	{
		User ggg = medrepo.findByEmailfp(email);
		
		if(ggg!=null)
		{
			if(ggg.getPassword()!=password && password.equals(confirmpass))
			{
				 ggg.setPassword(password);
				 
				return medrepo.save(ggg);
			}
			else
			{
				try
				{
					throw new ResourceNotfoundExceptionthree("user", "password", password);
				}
				catch(ResourceNotfoundExceptionthree e)
				{
					System.out.println(e);
					return e.getMessage();
				}
			}
		}
		else
		{
			try 
			{
				throw new ResourceNotFoundFoure("user", "email", email);
			}
			catch(ResourceNotFoundFoure r)
			{
				System.out.println(r);
				return r.getMessage();
			}
		}
		
	}

}	


		

	
		
	
