package com.phillips.oitservice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import javax.ws.rs.core.MediaType;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.phillips.oit.utils.OITResourseUtil;

public class FCMCall {
	private static final String SERVER_ID="AAAADphX9H0:APA91bFgTLvl-5_6SsN0bNhmSKVEyStSIfZz2XdriICaDJluRtNhzW3PxymwzC_1ZsXj6Ocezu2EDZYcLdfxqDcEcKp7eWTHpFi578CKmySfyR4Ei8KLCVXYzjWVrlUn6qex6J_WwM_O"; 
	public static void main(String[] args) {
	//URL url;
	try {
		System.out.println("Start........"); 
		String url = new String("https://fcm.googleapis.com/fcm/send");
		//HttpURLConnection con=(HttpURLConnection) url.openConnection();
//		con.setDoOutput(true);
//		con.setRequestMethod("POST");
//		 con.setRequestProperty("Content-Type", "application/json");
//		   con.setRequestProperty("Authorization", "key="+SERVER_ID);
	        JSONObject json=new JSONObject();
	        JSONObject json1=new JSONObject();
	        json1.put("message","huraayyy");
	        json1.put("title", "notification title");
	        json1.put("body", "message body");
	        json.put("notification", json1);
	        json.put("data", json1); 
	        File file = OITResourseUtil.getRegFilePath();
	        ArrayList<String> list=new ArrayList<String>();
	        try(BufferedReader buff=new BufferedReader(new FileReader(file))){
	        	String line;
	        	while ((line=buff.readLine())!=null){
	        		list.add(line);
	        	}
	        }
	       
	        if(!list.isEmpty()){
	        JSONArray jarr=new JSONArray(list);
	        System.out.println(jarr);
	        json.put("registration_ids", jarr); 
	        }
	       
	        URL url1 = new URL(url);
	        HttpURLConnection conn = (HttpURLConnection) url1.openConnection();

	        conn.setUseCaches(false);
	        conn.setDoInput(true);
	        conn.setDoOutput(true);

	        conn.setRequestMethod("POST");
	        conn.setRequestProperty("Authorization", "key=" + SERVER_ID);
	        conn.setRequestProperty("Content-Type", "application/json");
	        StringEntity params = new StringEntity(json.toString());        
//	        request.setEntity(params);      
//	         
//	        // get response from server
//	          HttpResponse response = httpClient.execute(request);   
//	          System.out.println("Response "+response);
//	         String mresult = EntityUtils.toString(response.getEntity());        
//	         
//	        System.out.println("result........" +mresult);
	        
	        System.out.println(json.toString());
	        OutputStreamWriter wr = new OutputStreamWriter(
	                conn.getOutputStream());
	        
	        wr.write(json.toString());
	        wr.flush();

	        BufferedReader br = new BufferedReader(new InputStreamReader(
	                (conn.getInputStream())));

	        String output;
	        System.out.println("Output from Server .... \n");
	        while ((output = br.readLine()) != null) {
	            System.out.println(output);
	        } 
	        }
	catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
