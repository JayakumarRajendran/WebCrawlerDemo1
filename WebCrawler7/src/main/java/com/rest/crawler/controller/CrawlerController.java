package com.rest.crawler.controller;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

/* this is the class to handle all type of request from the index page
 * this class is acting as a controller Using Jersey, restful webservices 
 * 
 * */
@Path("crawler")
public class CrawlerController {
	
	/*
	 * this method will produce text based output*/
	@GET
	@Path("/gettext")
	@Produces(MediaType.TEXT_PLAIN)
	public Response CrowlerText(){
		System.out.println("CrowlerText");
		
		return Response.ok("CrowlerText").build();
	}
	
	/*
	 * this method will produce xml based output*/
	@Path("/getxml")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response CrowlerXML(){
		System.out.println("CrowlerXML");
		return Response.ok("<root> CrowlerXML <root>").build();
	}
	
	/*
	 * this method will produce json based output*/
	@Path("/getjson")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response CrowlerJSON(){
		System.out.println("Crowler JSON");
		return Response.ok("{name:jay,company:wipro}").build();
	}
}
