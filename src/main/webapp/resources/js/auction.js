function bid() {

	var auctionId = document.getElementById('form-auction:hidden-auction-id').value;
	var bidValue = document.getElementById('form-auction:input-next-bid').value;

	var xhr = new XMLHttpRequest();
	var url = "http://192.168.56.1:7001/jee-auth/webapi/auctions/bid";
	xhr.open("POST", url, true);
	xhr.setRequestHeader("Content-Type", "application/json");
	xhr.onreadystatechange = function () {
	    if (xhr.readyState === 4 && xhr.status === 200) {
	        console.log(xhr.responseText);
	    } else {
	    	console.log("fuckup");
	    }
	};
	var data = JSON.stringify({"auctionId": auctionId, "bidValue": bidValue});
	xhr.send(data);
}

function refreshBid(message, channel, event) {
	console.log("refreshing bid...");
	var auctionId = document
			.getElementById('form-auction:hidden-auction-id').value
	if (message.auctionId == auctionId) {
		var nextBid = message.nextBid;
		document.getElementById('form-auction:input-current-bid').innerHTML = nextBid;
		
		PF('growlWdg').renderMessage({"summary":"Przebito ofertę!",
            						  "detail": nextBid,
            						  "severity":"info"});
	}
}