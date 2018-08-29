package com.aprzecho.jee.api;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AuctionModel {

	private Integer auctionId;
	private Integer bidValue;
	
	public AuctionModel() {}
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auctionId == null) ? 0 : auctionId.hashCode());
		result = prime * result + ((bidValue == null) ? 0 : bidValue.hashCode());
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
		AuctionModel other = (AuctionModel) obj;
		if (auctionId == null) {
			if (other.auctionId != null)
				return false;
		} else if (!auctionId.equals(other.auctionId))
			return false;
		if (bidValue == null) {
			if (other.bidValue != null)
				return false;
		} else if (!bidValue.equals(other.bidValue))
			return false;
		return true;
	}
	
}
