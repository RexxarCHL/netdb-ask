var getDescription = function(){
	var descriptionTo = document.getElementById('askinput').value;
	if (descriptionTo == '') {
		return;
	}
	
	var descriptionArea = document.getElementById('custom-answer');
	addClass(descriptionArea, 'content-hidden');
	
	var img = document.getElementById('custom-loading');
	removeClass(img, 'content-hidden');
	
	ajaxRequest('GET', encodeURI('description/' + descriptionTo), {
		'Accept': 'application/json'
	}, null, function(status, headers, body){ //onsucess: show description
		var description = eval('(' + body + ')');
		
		descriptionArea.innerHTML = '<h2>Custom Definition</h2>'
								 +  '<div class = "custom-text">' + escapeHtml(unescape(description.text)) + '</div>'
						         +  '<div class = "custom-stamp">'+ new Date(description.stamp).toString().split(/(GMT|UTC)/i)[0] +'</div>'
						         + '<img src="image/cross.gif" alt="Remove" title="Remove this comment" />';
		//add delete handler
		var delImg = descriptionArea.getElementsByTagName('img')[0];
		delImg.onclick = (function(){
			var ans = confirm("Are you sure you want to delete the description?")
			if(ans == true){
				ajaxRequest('DELETE', encodeURI('description/' + descriptionTo), null, null, 
				function(status, headers, body) { // success callback
					descriptionArea.innerHTML = '<h2>Custom Definition</h2><div class = "custom-del">Definition deleted.</div>';
					Cufon.refresh('h2');
				}, function(status, headers, body) {  // error callback
					alert('error:[deleting description]' + status);
				}, null);// run callbacks in global scope
			}
		}); 
		
		//show content
		Cufon.refresh('h2');
		removeClass(descriptionArea, 'content-hidden');
		addClass(img, 'content-hidden');
	}, function(status, headers, body){ //onerror: show error code
		switch(status){
			case 404:
				descriptionArea.innerHTML = '<h2>Custom Definition</h2><div id = "custom-no-answer">No custom definition yet -- create one now!</div>';
				Cufon.refresh('h2');
				removeClass(descriptionArea, 'content-hidden');
				addClass(img, 'content-hidden');
				break;
				
			default:
				alert('error:[fetching custom answer]' + status);
				addClass(img, 'content-hidden');
		}
	}, null);
}

var initDescriptionBtn = function(){
	var descriptionForm = document.getElementById('def-form');

	descriptionForm.onsubmit = function(){
		var method;
		
		if(document.getElementsByClassName('custom-text')[0] != null){
			method = 'POST' //update definition
		}
		else{
			method = 'PUT' //create definition
		}
		
		ajaxRequest(method, encodeURI('description/' + document.getElementById('askinput').value), {
			'Content-Type': 'application/json;charset=UTF-8'
		}, '{' +
		   '"title": "' + escape(document.getElementById('askinput').value) + '",' +
		   '"text": "' + escape(descriptionForm.elements['custom-input'].value) + '"' +
		'}', function(status, headers, body) {
			getDescription();
		}, function(status, headers, body){
			alert('error:[sending description]' + method + status);
		}, null);
		return false;
	}
}