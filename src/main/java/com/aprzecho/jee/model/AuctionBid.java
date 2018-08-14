package com.aprzecho.jee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="AUCTION_BID")
public class AuctionBid {

	@Id
	@GeneratedValue(generator = "GEN_SEQ_AUCTION_BID", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "GEN_SEQ_AUCTION_BID", sequenceName = "SEQ_AUCTION_BID", allocationSize = 1)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "auction_id")
	private Auction auction;
	
	@Column(name="BID_VALUE")
	private Integer bidValue;
	
	@Column(name="USERNAME")
	private String username;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Auction getAuction() {
		return auction;
	}
	
	public void setAuction(Auction auction) {
		this.auction = auction;
	}
	
	public Integer getBidValue() {
		return bidValue;
	}
	
	public void setBidValue(Integer bidValue) {
		this.bidValue = bidValue;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuctionBid other = (AuctionBid) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
