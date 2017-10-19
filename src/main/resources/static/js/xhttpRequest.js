var server = ".";

function getRequest(data, url, callback) {
	xhttpRequest(data, url, callback, "GET");
}
function postRequest(data, url, callback) {
	xhttpRequest(data, url, callback, "POST");
}

function putRequest(data, url, callback) {
	xhttpRequest(data, url, callback, "PUT");
}

function deleteRequest(data, url, callback) {
	xhttpRequest(data, url, callback, "DELETE");
}
function xhttpRequest(data, url, callback, type) {
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			if(callback != null) {
				callback(this.responseText);
			}
		}
	};
	xhttp.open(type, server + url);
	xhttp.setRequestHeader("Content-type", "application/json");
	if( typeof _csrf === 'defined' && _csrf !== null && _csrf.name != "") {
		xhttp.setRequestHeader('X-CSRF-TOKEN', _csrf.token);
	}
	if (data == null) {// geen idee of dit ook anders kan (null opsturen?)
		xhttp.send();
	} else {
		xhttp.send(data);
	}
}