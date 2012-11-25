/* 	
	General functions ProDocs
	Author: Eli Santana
	Project: 'Software de auxílio à geração de documentos'
	Date: september 2
*/

/*$(document).ready(function(){
	
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
	$("#accordion, #accordion_2").accordion({autoHeight: false, collapsible: true, active: false});
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

/* fancybox - show excerpts */
$(document).ready(function() {
	$(".active_details, .showdetails").fancybox({
		'titleShow'			: false,
		'titlePosition'		: 'inside',
		'transitionIn'		: 'none',
		'transitionOut'		: 'none',
		'overlayColor'		: '#000',
		'overlayOpacity'	: '0.6',
		'transitionIn'		: 'elastic'
	});
});

/* fancybox - save button */
$(document).ready(function() {
	$(".option-save").fancybox({
		'titleShow'			: false,
		'transitionIn'		: 'none',
		'transitionOut'		: 'none',
		'overlayColor'		: '#000',
		'overlayOpacity'	: '0.6',
		'transitionIn'		: 'elastic'
	});
});

/* fancybox - show perfil */
$(document).ready(function() {
	$("#show-perfil").fancybox({
		'titleShow'			: false,
		'transitionIn'		: 'none',
		'transitionOut'		: 'none',
		'overlayColor'		: '#000',
		'overlayOpacity'	: '0.6',
		'type'				: 'iframe',
		'height'			: 400
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
$(function(){
    $('.notif-container').css({'height': (($(window).height())-216)+'px'});
   	$(window).resize(function(){
        $('.notif-container').css({'height': (($(window).height())-216)+'px'});
	});
});

/* scroll */
(function($){
	$(window).load(function(){
		$(".resultsearch, .notif-container").mCustomScrollbar({scrollInertia:0, mouseWheel:20, advanced:{updateOnContentResize:true, updateOnBrowserResize:true}}, "update");
	});
})(jQuery);

/* toggle advanced search fields */
$(function(){
	$('.adv-option > a').click(function(){
		$('.adv-search').slideToggle('fast');
	});
});

/* show the input tag */
function showInputTag(){
	if($('#select-trecho').val() == 'Trecho'){
		$('#tag-trecho').show();
	} else {
		$('#tag-trecho').hide();
	}
}

/* show the register form in home */
function showRegister(obj){
	if(obj == 'reg'){
		$('.form-login').hide();
		$('.form-register').toggle("slide", { direction: "right" }, 500);
	} else if(obj == 'login'){
		$('.form-register').hide();
		$('.form-login').toggle("slide", { direction: "right" }, 500);
	}
}

/* Placeholder html5 */
// This adds 'placeholder' to the items listed in the jQuery .support object. 
jQuery(function() {
	jQuery.support.placeholder = false;
	test = document.createElement('input');
	if('placeholder' in test) jQuery.support.placeholder = true;
});
// This adds placeholder support to browsers that wouldn't otherwise support it. 
$(function() {
	if(!$.support.placeholder) { 
		var active = document.activeElement;
		$(':text').focus(function () {
			if ($(this).attr('placeholder') != '' && $(this).val() == $(this).attr('placeholder')) {
				$(this).val('').removeClass('hasPlaceholder');
			}
		}).blur(function () {
			if ($(this).attr('placeholder') != '' && ($(this).val() == '' || $(this).val() == $(this).attr('placeholder'))) {
				$(this).val($(this).attr('placeholder')).addClass('hasPlaceholder');
			}
		});
		$(':text').blur();
		$(active).focus();
		$('form:eq(0)').submit(function () {
			$(':text.hasPlaceholder').val('');
		});
	}
});


/* allow edition */
function allowEditionManager(){
	$('.user-container').find('input:text').removeAttr('disabled');
}

function sendRejectionReason(){
	$('#rejection').toggle();
}

/* Validation */
function validateForm(){
	var x=document.forms["myForm"]["fname"].value;
	if (x==null || x==""){
	  alert("First name must be filled out");
	  return false;
	}
}