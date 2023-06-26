package resource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	public static RequestSpecification req;
	
	public RequestSpecification requestSpecification() throws IOException
	{
		
		
		if(req==null) {
		PrintStream log=new PrintStream(new FileOutputStream("loging.txt"));
		 req=new RequestSpecBuilder().setBaseUri(property("BaseUri"))
				.setContentType(ContentType.JSON).addQueryParam("key","qaclick123").addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.build();
		
		return req;
	}
		
	return req;
	}
	
	public static String property(String key) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\pravi\\eclipse-workspace\\APIFramework2\\src\\test\\java\\resource\\global.properties");
		prop.load(fis);
				
			return prop.getProperty(key);
				
	}
	
	public String getjson(Response res,String Key)
	{
		  String r=res.asString();
		    JsonPath js= new JsonPath(r);
		   return js.get(Key).toString();
	}
}
