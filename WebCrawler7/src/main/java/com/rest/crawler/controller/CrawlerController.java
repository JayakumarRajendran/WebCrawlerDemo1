package com.rest.crawler.controller;

import java.util.ArrayList;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriBuilder;

import com.rest.crawler.bo.CrawlerBO;

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
	
	String url_value= "";
	@POST
	@Path("/default")
	public Response CrowlerDefault(@FormParam("url") String url, @FormParam("requiredtype") String requesttype)
	{
		url_value = url;
		String redirectpath = "/WebCrawler7/rest/crawler/get"+requesttype;
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
		String url = url_value;
		System.out.println("CrowlerText");
		
		CrawlerBO bo = new CrawlerBO();
		// calling BO class method which will parse the document and give list of links
		ArrayList<String> linklist = bo.CrowlerText(url);
		return Response.ok(linklist).build();
	}
	
	/*
	 * this method will produce xml based output*/
	@Path("/getxml")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response CrowlerXML(){
		String url = url_value;
		System.out.println("Cowler XML: "+url);
		return Response.ok("<root> CrowlerXML <root>").build();
	}
	
	/*
	 * this method will produce json based output*/
	@Path("/getjson")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response CrowlerJSON(){
		String url = url_value;
		System.out.println("Cowler JSON: "+url);
		return Response.ok("{name:jay,company:wipro}").build();
	}
}
