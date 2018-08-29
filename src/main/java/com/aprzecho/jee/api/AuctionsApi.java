package com.aprzecho.jee.api;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.aprzecho.jee.service.AuctionService;

@Path(value = "/auctions")
public class AuctionsApi {
	
	@Inject
	AuctionService auctionService;
	
	@POST
	@Path("/bid")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public String bidAuction(AuctionModel msg) {
		auctionService.bid(msg.getAuctionId(), msg.getBidValue());
		return "success";
	}		
}
