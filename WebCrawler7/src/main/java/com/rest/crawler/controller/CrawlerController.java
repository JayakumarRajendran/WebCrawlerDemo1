package com.rest.crawler.controller;



import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriBuilder;

/* this is the class to handle all type of request from the index page
 * this class is acting as a controller Using Jersey, restful webservices 
 * 
 * */
@Path("crawler")
public class CrawlerController {
	
	/*
	 * control will reach to this method by default from here based on request type redirection is gonna happen
	 * it will accept @POST type request with the link as
	 * http://localhost:8080/WebCrowler5/rest/crawl/default?url=http://wipro.com&requiredtype=xml  
      
	 * */
	@POST
	@Path("/default")
	public Response CrowlerDefault(@FormParam("url") String url, @FormParam("requiredtype") String requesttype)
	{
		String redirectpath = "/WebCrowler5/rest/crawler/get"+requesttype+"/"+url;
		System.out.println("CowlerDefault: "+redirectpath);
		ResponseBuilder builder =  Response.seeOther(UriBuilder.fromPath(redirectpath).build());
		return builder.build();
	}
	
	
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
