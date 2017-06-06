package com.mongodb.init;

import static spark.Spark.*;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.http.matching.Halt;

public class HelloWorldSparkFreemarkeStyle 
{
	public static void main(String[] args) 
	{
		
		final Configuration configuration = new Configuration(Configuration.VERSION_2_3_26);

		configuration.setClassForTemplateLoading(
				HelloWorldFreemarkerStyle.class, "/");		
		
		get("/", (res, req) -> {

			StringWriter writer = new StringWriter();
			
			try 
			{
				Template helloTemplate = configuration.getTemplate("hello.ftl");
				
				Map<String, Object> helloMap = new HashMap<String, Object>();
				helloMap.put("name", "Freemarker");
				
				helloTemplate.process(helloMap, writer);
				
				System.out.println(writer);

			} catch (Exception e) 
			{
				halt(500);
				e.printStackTrace();
			}
			
			return writer;
		});
	}
}
