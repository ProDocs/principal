/* 	
	General functions ProDocs
	Author: Eli Santana
	Project: 'Software de auxílio à geração de documentos'
	Date: september 2
*/

$(document).ready(function(){
	
	// Close the preview div
	$('.close-preview').click(function() {
		$('#preview').hide("drop",{ direction: "right" }, 500);
		
		// reset items style
		$('.result-list li').removeClass("bordering shadows");
		$('.approve-list li').removeClass("bordering shadows");
		$('.action-buttons a').removeClass('btn-gray');
		
		// reset template style
		$('.showcase a').parent().removeClass('selected');
		$('.box-main-showcase').css('width','1090');
		$('.scroll').css('width','100%');
		$('.scroll').mCustomScrollbar("update");
	});
	
	
	// SEARCH LIST: Change the item style and call the function to show preview div
	$('.showpreview').click(function(){
		if(!$(this).hasClass('btn-gray')){
			$('.action-buttons a').removeClass('btn-gray');
			$(this).addClass('btn-gray');
			$(this).parent().parent().siblings().removeClass("bordering shadows");
			$(this).parent().parent().addClass("bordering shadows");
			toggleSidebarPreviewer();
		}
	});
	
	// TEMPLATE: Change the item style and call the function to show preview div
	$('.showcase a').click(function(){
		if(!$(this).hasClass('new')){
			$(this).parent().siblings().removeClass('selected')
			$(this).parent().addClass('selected');
			toggleSidebarPreviewer();
			$('.box-main-showcase').css('width','750');
			$('.scroll').mCustomScrollbar("update");
			$('.scroll').css('width','63%').mCustomScrollbar("scrollTo",".selected");
		}
	});
});

// Show previewer div
function toggleSidebarPreviewer(){
	var prev = $('#preview').css('display');
	if(prev == 'none'){
		$('#preview').toggle("drop",{ direction: "right" }, 500);	
	}else{
		$('#preview').hide("drop",{ direction: "right" }, 300);
		$('#preview').show("drop",{ direction: "right" }, 500);
	}
}

//
/* draggable list */
/*$(function(){
	$( "#sortable > li" ).draggable({revert: true, helper: "clone"});
});*/

function logout(){
	alert('Deseja realmente sair?');
}

/* accordion */
$(function() {
	$("#accordion").accordion({autoHeight: false, collapsible: true});
});

/* dialog */
/*$(function() {
	$(".modal").click(function() {
		$("#confirm").dialog('open',{autoOpen: false, modal: true});
	});
});*/
$(document).ready(function() {
	var $dialog = $('<div></div>');
	$dialog.html('Tem certeza que deseja executar tal ação...?')
		.dialog({
			autoOpen: false,
			title: 'Confirmação',
			modal: true,
			buttons: {
				Sim: function() {
					$( this ).dialog( "close" );
				}
			}
		});

	$('.modal').click(function() {
		$dialog.dialog('open');
		// prevent the default action, e.g., following a link
		return false;
	});
});
$(document).ready(function() {
	$(".active_details").fancybox({
		'titlePosition'		: 'inside',
		'transitionIn'		: 'none',
		'transitionOut'		: 'none',
		'overlayColor'		: '#000',
		'overlayOpacity'	: '0.6',
		'transitionIn'		: 'elastic'
	});
});

$(document).ready(function() {
	$( ".resizable" ).resizable();
});


/* set height propertie to div by resizing browser */
$(function(){
    $('.resultsearch').css({'height': (($(window).height())-266)+'px'});
   	$(window).resize(function(){
        $('.resultsearch').css({'height': (($(window).height())-266)+'px'});
	});
});

/* scroll */
(function($){
	$(window).load(function(){
		$(".resultsearch").mCustomScrollbar({scrollInertia:0, mouseWheel:20, advanced:{updateOnContentResize:true, updateOnBrowserResize:true}}, "update");
	});
})(jQuery);