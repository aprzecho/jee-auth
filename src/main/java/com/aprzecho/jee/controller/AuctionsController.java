package com.aprzecho.jee.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.aprzecho.jee.model.Auction;
import com.aprzecho.jee.service.AuctionService;

@ViewScoped
@Named
public class AuctionsController implements Serializable {

	private static final Logger LOGGER = Logger.getLogger(AuctionsController.class.getName());	
	
	private static final long serialVersionUID = 1L;

	@Inject
	private AuctionService auctionService;
	
	private List<Auction> auctions;
	private List<Auction> auctionsFiltered;
	
	@PostConstruct
	private void init() {
		auctions = new ArrayList<Auction>();
		auctions.addAll(auctionService.getAuctions());
		
		auctionsFiltered = new ArrayList<Auction>();
		
		LOGGER.info("Controller initiated, size: " + auctions.size());
	}

	public List<Auction> getAuctions() {
		return auctions;
	}

	public List<Auction> getAuctionsFiltered() {
		return auctionsFiltered;
	}

	public void setAuctions(List<Auction> auctions) {
		this.auctions = auctions;
	}

	public void setAuctionsFiltered(List<Auction> auctionsFiltered) {
		this.auctionsFiltered = auctionsFiltered;
	}
	
}
