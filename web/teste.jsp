<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="de" lang="de">


    <%@include file="header.jsp" %>
    <link rel="shortcut icon" href="favicon.ico"/>
    <link rel="StyleSheet" href="tagging/css/ui-lightness/jquery-ui-1.8.6.custom.css" type="text/css" media="all"/>
    <link rel="StyleSheet" href="tagging/css/jquery.tagedit.css" type="text/css" media="all"/>
    <script type="text/javascript" src="tagging/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="tagging/js/jquery-ui-1.8.6.custom.min.js"></script>
    <script type="text/javascript" src="tagging/js/jquery.autoGrowInput.js"></script>
    <script type="text/javascript" src="tagging/js/jquery.tagedit.js"></script>
    
    <script type="text/javascript">
	$(function() {	
		
		
		// Custom Break Characters
		$('#custom-break input.tag').tagedit({
			//autocompleteURL: 'server/autocomplete.php',
			// return, comma, space, period, semicolon
			breakKeyCodes: [ 13, 44, 32, 46, 59 ],
                        allowEdit: false
		});

		
	});
    </script>
    


    <h1>jQuery Plugin Tagedit - Playground</h1>
	<p>
		Some more example of different use cases.
	</p>

	<h2>Use custom break characters</h2>(-d|-a)
        
        <table>
             <tr>
                <td>
                    <sj:a href="javascript:;" onClickTopics="testeAjax">Atualizar</sj:a>
               </td>
            </tr>
            <tr>
                <td>
                    <sj:div reloadTopics="testeAjax" formIds="custom-break"  src="incluir"/>
               </td>
            </tr>
        </table>
    <form action="server/formtarget.php" method="post" id="custom-break">
		<p>
			<input type="text" name="tag[]" value="" class="tag"/>
			<input type="submit" name="save" value="Save"/>
		</p>
    </form>
	

	

	
	<p class="footer">
		<a rel="license" href="http://creativecommons.org/licenses/by/3.0/"><img alt="Creative Commons License" style="border-width:0" src="http://i.creativecommons.org/l/by/3.0/88x31.png" /></a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by/3.0/">Creative Commons Attribution 3.0 Unported License</a>.<br/>
		&copy; 2010 Oliver Albrecht - <a href="http://webwork-albrecht.de">webwork-albrecht.de</a>
	</p>
</body>
</html>
