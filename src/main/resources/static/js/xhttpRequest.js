var server = ".";

function getRequest(data, url, callback) {
	xhttpRequest(data, url, callback, "GET");
}
function postRequest(data, restUrl, callback) {
	xhttpRequest(data, url, callback, "POST");
}
function deleteRequest(data, url, callback) {
	xhttpRequest(data, url, callback, "DELETE");
}
function xhttpRequest(data, url, callback, type) {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			callback(this.responseText);
		}
	};
	xhttp.open(type, server + url);
	xhttp.setRequestHeader("Content-type", "application/json");
	if (data == null) {// geen idee of dit ook anders kan (null opsturen?)
		xhttp.send();
	} else {
		xhttp.send(data);
	}
}