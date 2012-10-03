<%-- 
    Document   : editor
    Created on : 02/10/2012, 21:44:50
    Author     : discover
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Full featured example</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<!-- TinyMCE -->
<script language="JavaScript" type="text/javascript" src="tinymce/examples/jQuery Examples from SKFox.com.htm/jquery.min.js"></script>
<script language="JavaScript" type="text/javascript" src="tinymce/examples/jQuery Examples from SKFox.com_files/jquery-ui.min.js"></script>
<script type="text/javascript" src="tinymce/jscripts/tiny_mce/tiny_mce.js"></script>
<script language="JavaScript" type="text/javascript">
        $(document).ready( function() 
        {
            $('#ClickWordList li').click(function() { 
                $("#txtMessage").insertAtCaret($(this).text());
                return false
            });
            $("#DragWordList li").draggable({helper: 'clone'});
            $(".txtDropTarget").droppable({
                accept: "#DragWordList li",
                drop: function(ev, ui) {
                    $(this).insertAtCaret(ui.draggable.text());
					jQuery('#txtMessage').next('.mceEditor').find('.mceIframeContainer').droppable();
                }
            });
        });

        $.fn.insertAtCaret = function (myValue) {
            return this.each(function(){
                //IE support
                if (document.selection) {
                    this.focus();
                    sel = document.selection.createRange();
                    sel.text = myValue;
                    this.focus();
                }
                //MOZILLA / NETSCAPE support
                else if (this.selectionStart || this.selectionStart == '0') {
                    var startPos = this.selectionStart;
                    var endPos = this.selectionEnd;
                    var scrollTop = this.scrollTop;
                    this.value = this.value.substring(0, startPos)+ myValue+ this.value.substring(endPos,this.value.length);
                    this.focus();
                    this.selectionStart = startPos + myValue.length;
                    this.selectionEnd = startPos + myValue.length;
                    this.scrollTop = scrollTop;
                } else {
                    this.value += myValue;
                    this.focus();
                }
            });
        };
		
    </script>
<script type="text/javascript">
	tinyMCE.init({
		// General options
		mode : "textareas",
		theme : "advanced",
		plugins : "autolink,lists,pagebreak,style,layer,table,save,advhr,advimage,advlink,emotions,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template,wordcount,advlist,autosave,visualblocks",

		// Theme options
		theme_advanced_buttons1 : "save,newdocument,|,bold,italic,underline,strikethrough,|,justifyleft,justifycenter,justifyright,justifyfull,styleselect,formatselect,fontselect,fontsizeselect",
		theme_advanced_buttons2 : "cut,copy,paste,pastetext,pasteword,|,search,replace,|,bullist,numlist,|,outdent,indent,blockquote,|,undo,redo,|,link,unlink,anchor,image,cleanup,help,code,|,insertdate,inserttime,preview,|,forecolor,backcolor",
		theme_advanced_buttons3 : "tablecontrols,|,hr,removeformat,visualaid,|,sub,sup,|,charmap,emotions,iespell,media,advhr,|,print,|,ltr,rtl,|,fullscreen",
		theme_advanced_buttons4 : "insertlayer,moveforward,movebackward,absolute,|,styleprops,|,cite,abbr,acronym,del,ins,attribs,|,visualchars,nonbreaking,template,pagebreak,restoredraft,visualblocks",
		theme_advanced_toolbar_location : "top",
		theme_advanced_toolbar_align : "left",
		theme_advanced_statusbar_location : "bottom",
		theme_advanced_resizing : true,

		// Example content CSS (should be your site CSS)
		content_css : "css/content.css",

		// Drop lists for link/image/media/template dialogs
		template_external_list_url : "lists/template_list.js",
		external_link_list_url : "lists/link_list.js",
		external_image_list_url : "lists/image_list.js",
		media_external_list_url : "lists/media_list.js",

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
<!-- /TinyMCE -->

</head>
<body role="application">

<form method="post" action="http://tinymce.moxiecode.com/dump.php?example=true">
	<div>
		<h3>Full featured example</h3>

		<p>
			This page shows all available buttons and plugins that are included in the TinyMCE core package.
			There are more examples on how to use TinyMCE in the <a href="http://tinymce.moxiecode.com/examples/">Wiki</a>.
		</p>

		<!-- Gets replaced with TinyMCE, remember HTML in a textarea should be encoded -->
		<div>
			<textarea id="elm1" name="elm1" rows="15" cols="80" style="width: 80%">
				&lt;p&gt;
					This is some example text that you can edit inside the &lt;strong&gt;TinyMCE editor&lt;/strong&gt;.
				&lt;/p&gt;
				&lt;p&gt;
				Nam nisi elit, cursus in rhoncus sit amet, pulvinar laoreet leo. Nam sed lectus quam, ut sagittis tellus. Quisque dignissim mauris a augue rutrum tempor. Donec vitae purus nec massa vestibulum ornare sit amet id tellus. Nunc quam mauris, fermentum nec lacinia eget, sollicitudin nec ante. Aliquam molestie volutpat dapibus. Nunc interdum viverra sodales. Morbi laoreet pulvinar gravida. Quisque ut turpis sagittis nunc accumsan vehicula. Duis elementum congue ultrices. Cras faucibus feugiat arcu quis lacinia. In hac habitasse platea dictumst. Pellentesque fermentum magna sit amet tellus varius ullamcorper. Vestibulum at urna augue, eget varius neque. Fusce facilisis venenatis dapibus. Integer non sem at arcu euismod tempor nec sed nisl. Morbi ultricies, mauris ut ultricies adipiscing, felis odio condimentum massa, et luctus est nunc nec eros.
				&lt;/p&gt;
			</textarea>
		</div>

		<!-- Some integration calls -->
		<a href="javascript:;" onclick="tinyMCE.get('elm1').show();return false;">[Show]</a>
		<a href="javascript:;" onclick="tinyMCE.get('elm1').hide();return false;">[Hide]</a>
		<a href="javascript:;" onclick="tinyMCE.get('elm1').execCommand('Bold');return false;">[Bold]</a>
		<a href="javascript:;" onclick="alert(tinyMCE.get('elm1').getContent());return false;">[Get contents]</a>
		<a href="javascript:;" onclick="alert(tinyMCE.get('elm1').selection.getContent());return false;">[Get selected HTML]</a>
		<a href="javascript:;" onclick="alert(tinyMCE.get('elm1').selection.getContent({format : 'text'}));return false;">[Get selected text]</a>
		<a href="javascript:;" onclick="alert(tinyMCE.get('elm1').selection.getNode().nodeName);return false;">[Get selected element]</a>
		<a href="javascript:;" onclick="tinyMCE.execCommand('mceInsertContent',false,'<b>Hello world!!</b>');return false;">[Insert HTML]</a>
		<a href="javascript:;" onclick="tinyMCE.execCommand('mceReplaceContent',false,'<b>{$selection}</b>');return false;">[Replace selection]</a>

		<br />
		<input type="submit" name="save" value="Submit" />
		<input type="reset" name="reset" value="Reset" />
		
		<textarea name="txtMessage" id="txtMessage" class="txtDropTarget ui-droppable" cols="80" rows="15"></textarea>
			
		<p>
			<input type="submit" value="Submit" />
		</p>
	</form>
	</td>
	<td style="align:top">
	<div id="teste"></div>
	<div id="leftcolumn">
    <fieldset>
    <legend>Click to insert:</legend>
    <ul id="ClickWordList">
      <li>Hello world!</li>
      <li>All your base</li>
      <li>Lorem ipsum dolor sit amet...</li>
    </ul>
    </fieldset>
    <fieldset>
    <legend>Drag to insert:</legend>
    <ul id="DragWordList">
      <li class="ui-draggable">Hello world!</li>
      <li class="ui-draggable">All your base</li>
      <li class="ui-draggable"><div>Lorem ipsum dolor sit amet...</br>adsfasdfadsfasdfaf	</div></li>
    </ul>
    </fieldset>
  </div>
  </td>
  </tr>
  </table>
  <button type="button" onclick="displayDate()">Display Date</button>
	<div id="footer">
		<hr />
		<p id="copy">
			Copyright &copy; 2003-2012, <a class="samples" href="http://cksource.com/">CKSource</a> - Frederico
			Knabben. All rights reserved.
		</p>
	</div>
		
	</div>
</form>

<script type="text/javascript">
if (document.location.protocol == 'file:') {
	alert("The examples might not work properly on the local file system due to security settings in your browser. Please use a real webserver.");
}
</script>
</body>
</html>
