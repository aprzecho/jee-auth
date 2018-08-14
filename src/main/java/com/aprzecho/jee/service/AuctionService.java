package com.aprzecho.jee.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.aprzecho.jee.dao.AuctionDAO;
import com.aprzecho.jee.model.Auction;
import com.aprzecho.jee.model.AuctionBid;
import com.aprzecho.jee.session.SessionRepository;

@ApplicationScoped
public class AuctionService {
	
	@Inject
	AuctionDAO auctionDAO;
	
	@Inject
	SessionRepository sessionRepository;

	public List<Auction> getAuctions() {
		return auctionDAO.getAllAuctions();
	}
	
	public Auction findOne(Integer auctionId) {
		return auctionDAO.findOne(auctionId);
	}
	
	@Transactional
	public void bid(Auction auction, Integer nextBidValue) {
		AuctionBid newBid = auction.addBid(nextBidValue, sessionRepository.getCurrentUsername());
		auction.setCurrentBid(newBid);
		auctionDAO.update(auction);
	}
	
}
