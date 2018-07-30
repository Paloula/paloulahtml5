paloula.shift = ( function(shiftModule) {	
		
		var updateArticles = function(updateHTML) {
				var $replaceElement = $("LI[data-part='2']");
				$replaceElement.replaceWith( $.parseHTML(updateHTML));
				paloula.shift.init();
				paloula.multipart.initBack();	
				paloula.multipart.requestDisplayXml();
		};
		
		shiftModule.init = function() {
				$("BUTTON.app-example-icon-up").each( function() {
						var $button = $(this);
						var articleId = $button.attr("data-article-id");
						
						$button.click( function() {
								ajaxShift("shiftUp", articleId, updateArticles);
						});
				});
				
				$("BUTTON.app-example-icon-down").each( function() {
						var $button = $(this);
						var articleId = $button.attr("data-article-id");
						
						$button.click( function() {
								ajaxShift("shiftDown", articleId, updateArticles);
						});
				});			
			
				$("BUTTON.app-example-icon-delete").each( function() {
						var $button = $(this);
						var articleId = $button.attr("data-article-id");
						
						$button.click( function() {
								ajaxShift("delete", articleId, updateArticles);
						});
				});	
				
				$("BUTTON.app-example-icon-new-up").each( function() {
						var $button = $(this);
						var articleId = $button.attr("data-article-id");
						
						$button.click( function() {
								ajaxShift("insertBefore", articleId, updateArticles);
						});
				});					

				$("BUTTON.app-example-icon-new-down").each( function() {
						var $button = $(this);
						var articleId = $button.attr("data-article-id");
						
						$button.click( function() {
								ajaxShift("insertAfter", articleId, updateArticles);
						});
				});		

				$("BUTTON.app-example-icon-new-down-empty").each( function() {
						var $button = $(this);
						
						$button.click( function() {
								ajaxShift("insertNewEmpty", "", updateArticles);
						});
				});				
		};			
		
		var ajaxShift = function(shiftCommand, articleId, callBack) {
				
				$.ajax({
						type: "POST",
						dataType: "html",
						cache: false,
						url: "shift.shift", 
						data: jQuery.param({shiftCommand:shiftCommand, articleId:articleId}),
						success: function(response) {  							
										
								try {
										var redirectJSON = JSON.parse(response)
										var redirectUrl = redirectJSON.url;
										window.location.href = redirectUrl;
								} catch(e) {
										callBack(response);	
								};																		
						},								
						error: function(error) {
								console.log("[Paloula] ajaxPagePartAlc error:" + error.responseText);
						},								
						complete: function(dataResponse) {
								
						}
				});
				
		};		
		
		return shiftModule; 
} (paloula.shift || {}));

paloula.multipart = ( function(multipartModule) {	
	
		multipartModule.init = function() {
				$(".app-example-multipart-article-next").click( function() {
						nextMultipart($(this));
				});	
				
				paloula.multipart.initBack();	
		};
		
		multipartModule.initBack = function() {
				$("BUTTON.app-example-icon-back").each( function() {
						$(this).click( function() {
								hideDisplayXml();
						});
				});				
		};

		var nextMultipart = function($multipartButton) {
				var $currentArticlePart = $multipartButton.closest(".app-example-multipart-article");
				var multipartNumber = parseInt($currentArticlePart.attr("data-part"));
				var $articlePartParent = $currentArticlePart.parent();
					
				$articlePartParent.animate(
						{"left": (-multipartNumber  * 100) + "%"}, 
						{
								queue: false, 
								duration : 1000
						}
				);
		};

		var displayXml = function(responseXML) {
				$displayXml = $("PRE#displayXml");
				$displayXml.empty();
				$displayXml.text(responseXML);
				
				$displayXml.parent().delay(800).animate(
						{"left": "0"}, 
						{
								queue: true, 
								duration : 1000
						}
				);		
		};
		
		var hideDisplayXml = function() {
				$displayXml = $("PRE#displayXml");
					
				$displayXml.parent().animate(
						{"left": "100%"}, 
						{
								queue: true, 
								duration : 1000
						}
				);		
		};		
		
		multipartModule.requestDisplayXml = function() {
				ajaxGetServerXml(displayXml);
		};		
		
		var ajaxGetServerXml = function(callBack) {
				
				$.ajax({
						type: "POST",
						dataType: "html",
						cache: false,
						url: "shiftout.shiftout", 
						success: function(response) {  							
								callBack(response);											
						},								
						error: function(error) {
								console.log("[Paloula] ajaxPagePartAlc error:" + error.responseText);
						},								
						complete: function(dataResponse) {
								
						}
				});
				
		};		
		
		return multipartModule; 
} (paloula.multipart || {}));
// ==================================================================
// DOM Ready
// ==================================================================
$(document).ready( function() { 
		paloula.multipart.init();	
		paloula.shift.init();
});	