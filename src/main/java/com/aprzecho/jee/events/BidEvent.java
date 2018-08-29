package com.aprzecho.jee.events;

public class BidEvent {
	
	private Integer bidValue;
	private Integer auctionId;
	
	public Integer getAuctionId() {
		return auctionId;
	}

	public void setAuctionId(Integer auctionId) {
		this.auctionId = auctionId;
	}

	public Integer getBidValue() {
		return bidValue;
	}

	public void setBidValue(Integer bidValue) {
		this.bidValue = bidValue;
	}		
}
