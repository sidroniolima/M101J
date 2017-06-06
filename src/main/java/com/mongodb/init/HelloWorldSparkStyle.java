package com.mongodb.init;

import static spark.Spark.*;

public class HelloWorldSparkStyle 
{
	public static void main(String[] args) 
	{
		get("/", (res, req) -> "Hello world" );
	}
}
