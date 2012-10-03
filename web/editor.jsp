<%-- 
    Document   : editor
    Created on : 02/10/2012, 21:44:50
    Author     : discover
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<div class="editor">
    <form method="post" action="http://tinymce.moxiecode.com/dump.php?example=true" style="height: 100%">
        <!-- Gets replaced with TinyMCE, remember HTML in a textarea should be encoded -->
        <div style="height: 100%">
                <textarea id="elm1" name="elm1" style="height: 100%; width: 75%;">
                </textarea>
            <input type="submit" name="Enviar" value="Enviar" />
            <input type="reset" name="Apagar" value="Apagar" />
        </div>
        <!-- Exemplos chamada de função Tinymce -->
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
    </form>
</div>
<%@include file="footer.jsp" %>