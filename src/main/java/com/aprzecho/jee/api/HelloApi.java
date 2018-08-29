package com.aprzecho.jee.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path(value = "/hello")
public class HelloApi {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		return "Hello Plain";
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayXMLHello() {
		return "<?xml version=\"1.0\"?>" + "<hello> Hello XML" + "</hello>";
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello() {
		return "<html> " + "<title>" + "Hello HTML" + "</title>" + "<body><h1>" + "Hello HTML" + "</body></h1>"
				+ "</html> ";
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public HelloMessage sayJsonAppHello() {
		return new HelloMessage("Hello from JSON/XML!", 1);
	}
	
	@POST
	@Path("/inc")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public HelloMessage incrementPostMessage(HelloMessage msg) {
		int id = msg.getMessageId();
		msg.setMessageId(++id);
		msg.setMessage("Message incremented");
		return msg;
	}	
	
	@GET
	@Path("/inc")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public HelloMessage incrementGetMessage(@QueryParam("msg") HelloMessage msg) {
		int id = msg.getMessageId();
		msg.setMessageId(++id);
		msg.setMessage("Message incremented");
		return msg;
	}		

}
