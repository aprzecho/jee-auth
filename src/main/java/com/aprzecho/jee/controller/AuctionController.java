package com.aprzecho.jee.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.Push;
import org.omnifaces.cdi.PushContext;

import com.aprzecho.jee.events.BidEvent;
import com.aprzecho.jee.events.BidListener;
import com.aprzecho.jee.events.BroadcasterService;
import com.aprzecho.jee.model.Auction;
import com.aprzecho.jee.service.AuctionService;

@ViewScoped
@Named
public class AuctionController implements Serializable, BidListener {

	private static final Logger LOGGER = Logger.getLogger(AuctionController.class.getName());

	private static final long serialVersionUID = 1L;

	@Inject
	private AuctionService auctionService;
	
	@Inject
	private BroadcasterService bsService;

	private Auction auction;

	private Integer paramAuctionId;
	
	private Integer nextBid;
	
	@Inject @Push(channel="auctionChannel")
	private PushContext auctionChannel;	

	@PostConstruct
	private void init() {

		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		paramAuctionId = Integer.parseInt(params.get("paramAuctionId"));

		auction = auctionService.findOne(paramAuctionId);
		
		bsService.register(this);
		
		LOGGER.info("AuctionController initiated for auctionId=" + auction.getId());
	}
	
	@PreDestroy
	public void destroy() {
		bsService.unregister(this);
	}

	@Override
	public void refreshBid(BidEvent be) {
		
		Map<String, Object> payload = new HashMap<>();
		payload.put("auctionId", be.getAuctionId());
		payload.put("nextBid", be.getBidValue());
		
		if(be.getAuctionId().equals(auction.getId())) {
			System.out.println("Client processes bid, sending WS message: " + payload.keySet() + ", " + payload.values());		
			auctionChannel.send(payload);
		} else {
			System.out.println("Client got bid, got auctionId= " + be.getAuctionId() + ", looking for: " + auction.getId());
		}
	}	
	
	public void changeBid(ActionEvent actionEvent) {			
		auctionService.bid(auction, nextBid);
	}

	public Auction getAuction() {
		return auction;
	}

	public void setAuction(Auction auction) {
		this.auction = auction;
	}

	public Integer getNextBid() {
		return nextBid;
	}

	public void setNextBid(Integer nextBid) {
		this.nextBid = nextBid;
	}
	
}
