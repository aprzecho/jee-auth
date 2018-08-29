package com.aprzecho.jee.events;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BroadcasterService {

	private Set<BidListener> listeners;
	
	@PostConstruct
	public void init() {
		listeners = new HashSet<BidListener>();
	}
	
	public void register(BidListener listener) {
		listeners.add(listener);
		System.out.println("Listener registered");
	}
	
	public void unregister(BidListener listener) {
		listeners.remove(listener);
		System.out.println("Listener UNREGISTERED");		
	}
	
	public void broadcastBids(BidEvent bid) {
		System.out.println("Propagating bid...");
		for(BidListener listener: listeners) {
			listener.refreshBid(bid);
			System.out.println("Bid propagated to client");
		}
	}
}
