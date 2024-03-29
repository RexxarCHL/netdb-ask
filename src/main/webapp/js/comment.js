var getComments = function(){
	var commentTo = document.getElementById('askinput').value;
	if (commentTo == '') {
		return;
	}
	
	var commentArea = document.getElementById('comment-area');
	removeClass(commentArea, 'comment-loaded');
	
	ajaxRequest('GET', encodeURI('comments/' + document.getElementById('askinput').value), {
		'Accept': 'application/json'
	}, null, function(status, headers, body){ //onsucess: show comment(s)
		addClass(commentArea, 'comments-loaded');
		var commentList = document.getElementById('comment-list');
		var comments = eval('(' + body + ')');
		
		if(comments.length == 0){
			commentList.innerHTML = '<div class="list-no-comment">No comments -- leave one now!</div>'
			return;
		}
		
		var htmlFrag = '';
		for(var i = 0; i < comments.length; i++){
			htmlFrag +='<div class="list-comment">'
				+ '<div class="list-comment-id">' + escapeHtml(unescape(comments[i].id)) + '</div>'
				+ '<div class="list-comment-text">' + escapeHtml(unescape(comments[i].text)) + '</div>'
				+ '<div class="list-comment-stamp">' + new Date(comments[i].stamp).toString().split(/(GMT|UTC)/i)[0] + '</div>' 
				+ '<img src="image/cross.gif" alt="Remove" title="Remove this comment" />' 
				+ '</div>';
		}
		commentList.innerHTML = htmlFrag;
		
		//add handlers
		var aComment = commentList.firstChild;
		var j = 0;
		while(aComment){
			var removeComment = aComment.getElementsByTagName('img')[0];
			removeComment.onclick = (function(el) {
				return function() { // closure
					ajaxRequest('DELETE', encodeURI('comments/' + el.firstChild.innerHTML), null, null, 
					function(status, headers, body) { // success callback
						getComments();
					}, function(status, headers, body) {  // error callback
						alert('error:[deleting comment '+ aComment.getElementById(comment-id).innerHTML +']' + status);
					}, null); // run callbacks in global scope
					return false;
				}
			})(aComment);
			aComment = aComment.nextSibling;
		}
		removeClass(commentList, 'content-hidden');
	}, function(status, headers, body){ //onerror: show error code
		alert('error:[fetching comments]' + status);
	}, null);
}

var initCommentBtn = function(){
	var commentForm = document.getElementById('comment-form');

	commentForm.onsubmit = function(){
		commentTo = document.getElementById('askinput').value;
		ajaxRequest('PUT', encodeURI('comments/' + commentTo), {
			'Content-Type': 'application/json;charset=UTF-8'
		}, '{' +
		   '"title": "' + escape(commentTo) + '",' +
		   '"text": "' + escape(commentForm.elements['comment-input'].value) + '"' +
		'}', function(status, headers, body) { //onsuccess
			getComments();
		}, function(status, headers, body){ //onerror
			alert('error:[sending the comment]' + method + status);
		}, null);
		return false;
	}
}