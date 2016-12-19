package com.rest.crawler.controller;

import java.util.ArrayList;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
	@POST
	@Path("/default")
	@Produces(MediaType.TEXT_PLAIN)
	public Response CrowlerDefault(@FormParam("url") String url, @FormParam("requiredtype") String requesttype)
	{
		CrawlerBO bo = new CrawlerBO();
		// calling BO class method which will parse the document and give list of links
		ArrayList<String> linklist = bo.CrowlerText(url);
		String links = "";
		for(String link : linklist){
			links = links +link+ System.lineSeparator();
		}
		return Response.ok(links).build();
	}
	
	/*
	 * this method will produce text based output*/
	@GET
	@Path("/gettext/{url}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response CrowlerText(@PathParam("url") String url){
		System.out.println("CrowlerText");
		
		return Response.ok("CrowlerText").build();
	}
	
	/*
	 * this method will produce xml based output*/
	@Path("/getxml/{url}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response CrowlerXML(@PathParam("url") String url){
		System.out.println("Cowler XML: "+url);
		return Response.ok("<root> CrowlerXML <root>").build();
	}
	
	/*
	 * this method will produce json based output*/
	@Path("/getjson/{url}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response CrowlerJSON(@PathParam("url") String url){
		System.out.println("Cowler JSON: "+url);
		return Response.ok("{name:jay,company:wipro}").build();
	}
}
