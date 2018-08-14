package com.aprzecho.jee.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Auction {

	@Id
	@GeneratedValue(generator = "GEN_SEQ_AUCTION", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "GEN_SEQ_AUCTION", sequenceName = "SEQ_AUCTION", allocationSize = 1)
	private Integer id;

	@Column
	private String title;

	@OneToOne(mappedBy = "auction")
	@JoinColumn(name = "CURRENT_BID_ID")
	private AuctionBid currentBid;

	@OneToMany(mappedBy = "auction")
	private List<AuctionBid> bids;

	public Auction() {
		bids = new ArrayList<AuctionBid>();
	}

	public AuctionBid addBid(Integer bid, String username) {
		AuctionBid newBid = new AuctionBid();
		newBid.setBidValue(bid);
		newBid.setAuction(this);
		newBid.setUsername(username);
		bids.add(newBid);

		return newBid;
	}

	public Integer getCurrentBidValue() {
		if (currentBid != null) {
			return currentBid.getBidValue();
		} else {
			return 0;
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<AuctionBid> getBids() {
		return bids;
	}

	public void setBids(List<AuctionBid> bids) {
		this.bids = bids;
	}

	public AuctionBid getCurrentBid() {
		return currentBid;
	}

	public void setCurrentBid(AuctionBid currentBid) {
		this.currentBid = currentBid;
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
		Auction other = (Auction) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
