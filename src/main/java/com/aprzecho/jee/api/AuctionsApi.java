package com.aprzecho.jee.api;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.aprzecho.jee.events.BidEvent;
import com.aprzecho.jee.events.BroadcasterService;
import com.aprzecho.jee.service.AuctionService;

@Path(value = "/auctions")
public class AuctionsApi {
	
	@Inject
	private AuctionService auctionService;
	
	@Inject
	private BroadcasterService bsService;
	
	@POST
	@Path("/bid")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public String bidAuction(AuctionModel msg) {
		auctionService.bid(msg.getAuctionId(), msg.getBidValue());
		
		BidEvent be = new BidEvent();
		be.setBidValue(msg.getBidValue());
		be.setAuctionId(msg.getAuctionId());
		
		bsService.broadcastBids(be);
		return "success";
	}		
}
