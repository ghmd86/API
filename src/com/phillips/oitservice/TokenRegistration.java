package com.phillips.oitservice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;

import com.phillips.oit.utils.OITResourseUtil;
@Path("/registrationId")
public class TokenRegistration {
@POST
@Consumes(MediaType.APPLICATION_JSON)
public void saveRegistrationId(String rid){
	
	
	
	try{
		JSONObject jobj=new JSONObject(rid);
		System.out.println("RID"+rid);
		File file = OITResourseUtil.getRegFilePath();
		try(FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
				BufferedWriter bw=new BufferedWriter(fw);){
		bw.newLine();
		bw.write(jobj.getString("rid"));
		System.out.println("successfully saved the registration");
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		
	}
	
	}
public static void main(String[] args) {
	String id="{'rid':'314e1'}";
	JSONObject obj = null;
	try {
		obj = new JSONObject(id);
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//new TokenRegistration().saveRegistrationId(id);
}
}
