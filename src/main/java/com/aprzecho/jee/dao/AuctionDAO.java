package com.aprzecho.jee.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.aprzecho.jee.model.Auction;

@ApplicationScoped
public class AuctionDAO {

	@PersistenceContext(unitName="simplePU")
	private EntityManager em;

	public List<Auction> getAllAuctions() {
		return em.createQuery("SELECT a FROM Auction a", Auction.class).getResultList();
	}

	public Auction findOne(int auctionId) {
		return em.find(Auction.class, auctionId);
	}
	
	@Transactional
	public void update(Auction auction) {
		em.merge(auction);
	}

}
