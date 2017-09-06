package com.phillips.oitservice;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.json.JSONObject;

import com.phillips.oit.bean.OITBean;
import com.phillips.oit.utils.OITResourseUtil;

@Path("/getres") 
@Produces(MediaType.APPLICATION_JSON)
public class OITResource {
@GET
public String getMessage(){
		System.out.println("In oit resource");
	OITBean oitBean=new OITBean();
	
	return new JSONObject(new OITBean()).toString();
}
public static void main(String[] args) {
	OITResource o=new OITResource();
	System.out.println(o.getMessage());
}
@POST
@Path("/upload/xls")
@Consumes(MediaType.MULTIPART_FORM_DATA)
public Response uploadExcelFile(@FormDataParam ("uploadFile") InputStream fileInputStream,@FormDataParam("uploadFile") FormDataContentDisposition fileForm)
{
String fileName=null;
String uploadFilePath = null ;
try {
	 fileName = fileForm.getFileName();
     uploadFilePath = OITResourseUtil.readExcelFile(fileName, fileInputStream);
} catch (Exception e) {e.printStackTrace();}
return Response.ok("File uploaded successfully").build();

}
}
