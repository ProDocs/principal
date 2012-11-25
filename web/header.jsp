<%-- 
    Document   : header
    Created on : 02/10/2012, 20:57:01
    Author     : discover
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<%@taglib  prefix="sj" uri="/struts2-jquery-tags" %>
<!DOCTYPE html>
<html>
<head>
<sj:head compressed="false"/>
<sj:head jqueryui="false"/>
<title>::ProDocs::</title>
    
<%--Biblioteca Editor--%>
<script type="text/javascript" src="tinymce/jscripts/tiny_mce/tiny_mce.js"></script>

<script type="text/javascript">
    
	tinyMCE.init({
		// General options
		mode : "textareas",
		theme : "advanced",
                skin : "o2k7",
		plugins : "autolink,lists,pagebreak,style,layer,table,save,advhr,advimage,advlink,emotions,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template,wordcount,advlist,autosave,visualblocks",
                height : "530px",
                
                

		// Theme options
		theme_advanced_buttons1 : "save,newdocument,|,bold,italic,underline,strikethrough,|,justifyleft,justifycenter,justifyright,justifyfull,styleselect,formatselect,fontselect,fontsizeselect",
		theme_advanced_buttons2 : "cut,copy,paste,pastetext,pasteword,|,search,replace,|,bullist,numlist,|,outdent,indent,blockquote,|,undo,redo,|,link,unlink,anchor,image,cleanup,help,code,|,insertdate,inserttime,preview,|,forecolor,backcolor",
		theme_advanced_buttons3 : "tablecontrols,|,hr,removeformat,visualaid,|,sub,sup,|,charmap,emotions,iespell,media,advhr,|,print,|,ltr,rtl,|,fullscreen",
		theme_advanced_buttons4 : "insertlayer,moveforward,movebackward,absolute,|,styleprops,|,cite,abbr,acronym,del,ins,attribs,|,visualchars,nonbreaking,template,pagebreak,restoredraft,visualblocks",
		theme_advanced_toolbar_location : "top",
		theme_advanced_toolbar_align : "left",
		theme_advanced_statusbar_location : "bottom",
		theme_advanced_resizing : false,
                nonbreaking_force_tab : true,
                

		// Example content CSS (should be your site CSS)
		content_css : "tinymce/examples/css/content.css",

		// Drop lists for link/image/media/template dialogs
		template_external_list_url : "tinymce/examples/lists/template_list.js",
		external_link_list_url : "tinymce/examples/lists/link_list.js",
		external_image_list_url : "tinymce/examples/lists/image_list.js",
		media_external_list_url : "tinymce/examples/lists/media_list.js",

		// Style formats
		style_formats : [
			{title : 'Bold text', inline : 'b'},
			{title : 'Red text', inline : 'span', styles : {color : '#ff0000'}},
			{title : 'Red header', block : 'h1', styles : {color : '#ff0000'}},
			{title : 'Example 1', inline : 'span', classes : 'example1'},
			{title : 'Example 2', inline : 'span', classes : 'example2'},
			{title : 'Table styles'},
			{title : 'Table row 1', selector : 'tr', classes : 'tablerow1'}
		],

		// Replace values for the template plugin
		template_replace_values : {
			username : "Some User",
			staffid : "991234"
		}
	});
        
</script>
<script type="text/javascript" >

            $.subscribe('remoteDivLoaded', function(event,element) {
               tinyMCE.execCommand('mceRemoveControl', true, "elm1");
               tinyMCE.execCommand('mceAddControl', false, "elm1");
            });

</script>
<%--Biblioteca Editor--%>

<link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="script/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="script/jquery-ui-1.8.22.custom.min.js"></script>
<script type="text/javascript" src="script/jquery.mCustomScrollbar.min.js"></script>
<script type="text/javascript" src="script/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="script/jquery.mousewheel.min.js"></script>
<script type="text/javascript" src="script/jquery.fancybox-1.3.4.js"></script>
<script type="text/javascript" src="script/functions.js"></script>


<script>
    function index(){
           $("#pagina").val("index"); 
    }
    function painel(){
           $("#pagina").val("painel"); 
    }
    function busca(){
           $("#pagina").val("busca"); 
    }
    function modelo(){
           $("#pagina").val("modelo");
    }
    function trecho(){
           $("#pagina").val("trecho"); 
    }
    function documento(){
           $("#pagina").val("documento"); 
    }
</script>

<!-- HEADER -->
<body>
<form name="groupForm" action="grupo">   
    
    <div class="header">
    <div class="box-logo-top">
        <sj:a href="javascript:;" title="Home" onclick="index();" onClickTopics="displayPage">Prodocs</sj:a>
    </div>
        <div class="info">
        <h2>Seja bem-vindo, ${userLogado.nome}</h2>
        <div class="category">
            <label>Grupo: </label>
            <sj:div id="comboGrupos" reloadTopics="displayGroups" src="grupos"/>
        </div>
            <a class="user" href="#" title="Perfil">User</a>
            <sj:a cssClass="home" href="javascript:;" title="Home" onclick="index();" onClickTopics="displayPage" >Home</sj:a>
            <a class="logout" href="userLogout" onclick="logout();" title="Sair">Logout</a>
        </div>
    </div>
</form>




