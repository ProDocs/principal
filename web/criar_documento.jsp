<%-- 
    Document   : criar_trecho
    Created on : 04/10/2012, 01:54:03
    Author     : discover
--%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<%@taglib  prefix="sj" uri="/struts2-jquery-tags" %>

    <link rel="shortcut icon" href="favicon.ico"/>
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


<div class="wrapper">

	<!--<div class="scroll">-->
        <div class="box-main-doc">
        		<!-- Iteração -->
         		<div class="editor-container shadows">
                           <sj:div id="editDoc" name="editDoc" reloadTopics="loadEditor" src="editor" onSuccessTopics="remoteDivLoaded"/>
			</div>

        </div>
    <!--</div>-->
    <div class="sidebar shadows">
        
            <div class="doc-manager">
                <a title="Salvar" href="javascript:;" class="btn-blue option-save">Salvar</a>
           

            <%--Modal salvar documento--%>
                <div style="display: none;">
                    <div id="save" class="highlight-fancy opt-save">
                        <h4>Salvando...</h4>
                        <div class="highlight-fancy-content">
                                <br/>
                                <p>Insira o nome deste documento:</p>
                                <br/>
                                <input type="text"/>
                        </div>
                        <div class="highlight-btn">
                            <a class="btn-blue" href="#">Salvar</a>
                            <a class="btn-blue" href="#">Cancelar</a>
                        </div>
                    </div>
                </div>
            <%--Modal salvar documento--%>

            </div>
                 <p>
                     
                     
                     
                     
                     Digite o nome do documento &nbsp; <input type="text" style="width: 200px"/>
                </p>
                
                <%--busca por trecho--%>
                <div class="sidebar shadows">
        <div class="formsearch">
        	<form>
            	<input type="text" class="txtsearch"/>
                <input type="image" value="" class="button-seach" src="images/1343703624_24.png"/>
            </form>
        </div>
        	<div class="resultsearch">
                <ul id="sortable" class="result-list">
                    <li>
                        <h4>Item Loren Ipsum</h4>
                        <p>lorem ipsum habhua  dasgf hdjah d</p>
                        <!-- gerar o id de forma dinamica no iterator -->
                        <a class="btn-blue active_details" href="#details_1">Ver detalhes</a>
                        <div style="display: none;">
                            <div id="details_1" class="highlight-fancy trecho-details">
                                <h4>Item Loren Ipsum</h4>
                                <div class="highlight-fancy-content">
                                    <br/>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam quis mi eu elit tempor facilisis id et neque. Nulla sit amet sem sapien. Vestibulum imperdiet porta ante ac ornare. Nulla et lorem eu nibh adipiscing ultricies nec at lacus. Cras laoreet ultricies sem, at blandit mi eleifend aliquam. Nunc enim ipsum, vehicula non pretium varius, cursus ac tortor. Vivamus fringilla congue laoreet. Quisque ultrices sodales orci, quis rhoncus justo auctor in. Phasellus dui eros, bibendum eu feugiat ornare, faucibus eu mi. Nunc aliquet tempus sem, id aliquam diam varius ac. Maecenas nisl nunc, molestie vitae eleifend vel, iaculis sed magna. Aenean tempus lacus vitae orci posuere porttitor eget non felis. Donec lectus elit, aliquam nec eleifend sit amet, vestibulum sed nunc.</p>
                                </div>
                                <div class="highlight-btn">
                                    <a class="btn-blue" href="#">Copiar trecho</a>
                                    <a class="btn-blue" href="#">Copiar selecao</a>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li>
                        <h4>Item Loren Ipsum</h4>
                        <p>lorem ipsum habhua  dasgf hdjah d</p>
                        <a class="btn-blue active_details" href="#details_2">Ver detalhes</a>
                        <div style="display: none;">
                            <div id="details_2" class="highlight-fancy trecho-details">
                                <h4>2 Item Loren Ipsum</h4>
                                <div class="highlight-fancy-content">
                                    <br/>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam quis mi eu elit tempor facilisis id et neque. Nulla sit amet sem sapien. Vestibulum imperdiet porta ante ac ornare. Nulla et lorem eu nibh adipiscing ultricies nec at lacus. Cras laoreet ultricies sem, at blandit mi eleifend aliquam. Nunc enim ipsum, vehicula non pretium varius, cursus ac tortor. Vivamus fringilla congue laoreet. Quisque ultrices sodales orci, quis rhoncus justo auctor in. Phasellus dui eros, bibendum eu feugiat ornare, faucibus eu mi. Nunc aliquet tempus sem, id aliquam diam varius ac. Maecenas nisl nunc, molestie vitae eleifend vel, iaculis sed magna. Aenean tempus lacus vitae orci posuere porttitor eget non felis. Donec lectus elit, aliquam nec eleifend sit amet, vestibulum sed nunc.</p>
                                </div>
                                <div class="highlight-btn">
                                    <a class="btn-blue" href="#">Copiar trecho</a>
                                    <a class="btn-blue" href="#">Copiar selecao</a>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li>
                        <h4>Item Loren Ipsum</h4>
                        <p>lorem ipsum habhua  dasgf hdjah d</p>
                        <a class="btn-blue active_details" href="#details_2">Ver detalhes</a>
                        <div style="display: none;">
                            <div id="details_2" class="highlight-fancy trecho-details">
                                <h4>Item Loren Ipsum</h4>
                                <div class="highlight-fancy-content">
                                    <br/>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam quis mi eu elit tempor facilisis id et neque. Nulla sit amet sem sapien. Vestibulum imperdiet porta ante ac ornare. Nulla et lorem eu nibh adipiscing ultricies nec at lacus. Cras laoreet ultricies sem, at blandit mi eleifend aliquam. Nunc enim ipsum, vehicula non pretium varius, cursus ac tortor. Vivamus fringilla congue laoreet. Quisque ultrices sodales orci, quis rhoncus justo auctor in. Phasellus dui eros, bibendum eu feugiat ornare, faucibus eu mi. Nunc aliquet tempus sem, id aliquam diam varius ac. Maecenas nisl nunc, molestie vitae eleifend vel, iaculis sed magna. Aenean tempus lacus vitae orci posuere porttitor eget non felis. Donec lectus elit, aliquam nec eleifend sit amet, vestibulum sed nunc.</p>
                                </div>
                                <div class="highlight-btn">
                                    <a class="btn-blue" href="#">Copiar trecho</a>
                                    <a class="btn-blue" href="#">Copiar selecao</a>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li>
                        <h4>Item Loren Ipsum</h4>
                        <p>lorem ipsum habhua  dasgf hdjah d</p>
                        <a class="btn-blue active_details" href="#details_3">Ver detalhes</a>
                        <div style="display: none;">
                            <div id="details_3" class="highlight-fancy trecho-details">
                                <h4>Item Loren Ipsum</h4>
                                <div class="highlight-fancy-content">
                                    <br/>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam quis mi eu elit tempor facilisis id et neque. Nulla sit amet sem sapien. Vestibulum imperdiet porta ante ac ornare. Nulla et lorem eu nibh adipiscing ultricies nec at lacus. Cras laoreet ultricies sem, at blandit mi eleifend aliquam. Nunc enim ipsum, vehicula non pretium varius, cursus ac tortor. Vivamus fringilla congue laoreet. Quisque ultrices sodales orci, quis rhoncus justo auctor in. Phasellus dui eros, bibendum eu feugiat ornare, faucibus eu mi. Nunc aliquet tempus sem, id aliquam diam varius ac. Maecenas nisl nunc, molestie vitae eleifend vel, iaculis sed magna. Aenean tempus lacus vitae orci posuere porttitor eget non felis. Donec lectus elit, aliquam nec eleifend sit amet, vestibulum sed nunc.</p>
                                </div>
                                <div class="highlight-btn">
                                    <a class="btn-blue" href="#">Copiar trecho</a>
                                    <a class="btn-blue" href="#">Copiar selecao</a>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li>
                        <h4>Item Loren Ipsum</h4>
                        <p>lorem ipsum habhua  dasgf hdjah d</p>
                        <a class="btn-blue active_details" href="#details_4">Ver detalhes</a>
                        <div style="display: none;">
                            <div id="details_4" class="highlight-fancy trecho-details">
                                <h4>Item Loren Ipsum</h4>
                                <div class="highlight-fancy-content">
                                    <br/>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam quis mi eu elit tempor facilisis id et neque. Nulla sit amet sem sapien. Vestibulum imperdiet porta ante ac ornare. Nulla et lorem eu nibh adipiscing ultricies nec at lacus. Cras laoreet ultricies sem, at blandit mi eleifend aliquam. Nunc enim ipsum, vehicula non pretium varius, cursus ac tortor. Vivamus fringilla congue laoreet. Quisque ultrices sodales orci, quis rhoncus justo auctor in. Phasellus dui eros, bibendum eu feugiat ornare, faucibus eu mi. Nunc aliquet tempus sem, id aliquam diam varius ac. Maecenas nisl nunc, molestie vitae eleifend vel, iaculis sed magna. Aenean tempus lacus vitae orci posuere porttitor eget non felis. Donec lectus elit, aliquam nec eleifend sit amet, vestibulum sed nunc.</p>
                                </div>
                                <div class="highlight-btn">
                                    <a class="btn-blue" href="#">Copiar trecho</a>
                                    <a class="btn-blue" href="#">Copiar selecao</a>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li>
                        <h4>Item Loren Ipsum</h4>
                        <p>lorem ipsum habhua  dasgf hdjah d</p>
                        <a class="btn-blue active_details" href="#details_5">Ver detalhes</a>
                        <div style="display: none;">
                            <div id="details_5" class="highlight-fancy trecho-details">
                                <h4>Item Loren Ipsum</h4>
                                <div class="highlight-fancy-content">
                                    <br/>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam quis mi eu elit tempor facilisis id et neque. Nulla sit amet sem sapien. Vestibulum imperdiet porta ante ac ornare. Nulla et lorem eu nibh adipiscing ultricies nec at lacus. Cras laoreet ultricies sem, at blandit mi eleifend aliquam. Nunc enim ipsum, vehicula non pretium varius, cursus ac tortor. Vivamus fringilla congue laoreet. Quisque ultrices sodales orci, quis rhoncus justo auctor in. Phasellus dui eros, bibendum eu feugiat ornare, faucibus eu mi. Nunc aliquet tempus sem, id aliquam diam varius ac. Maecenas nisl nunc, molestie vitae eleifend vel, iaculis sed magna. Aenean tempus lacus vitae orci posuere porttitor eget non felis. Donec lectus elit, aliquam nec eleifend sit amet, vestibulum sed nunc.</p>
                                </div>
                                <div class="highlight-btn">
                                    <a class="btn-blue" href="#">Copiar trecho</a>
                                    <a class="btn-blue" href="#">Copiar selecao</a>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li>
                        <h4>Item Loren Ipsum</h4>
                        <p>lorem ipsum habhua  dasgf hdjah d</p>
                        <a class="btn-blue active_details" href="#details_6">Ver detalhes</a>
                        <div style="display: none;">
                            <div id="details_6" class="highlight-fancy trecho-details">
                                <h4>Item Loren Ipsum</h4>
                                <div class="highlight-fancy-content">
                                    <br/>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam quis mi eu elit tempor facilisis id et neque. Nulla sit amet sem sapien. Vestibulum imperdiet porta ante ac ornare. Nulla et lorem eu nibh adipiscing ultricies nec at lacus. Cras laoreet ultricies sem, at blandit mi eleifend aliquam. Nunc enim ipsum, vehicula non pretium varius, cursus ac tortor. Vivamus fringilla congue laoreet. Quisque ultrices sodales orci, quis rhoncus justo auctor in. Phasellus dui eros, bibendum eu feugiat ornare, faucibus eu mi. Nunc aliquet tempus sem, id aliquam diam varius ac. Maecenas nisl nunc, molestie vitae eleifend vel, iaculis sed magna. Aenean tempus lacus vitae orci posuere porttitor eget non felis. Donec lectus elit, aliquam nec eleifend sit amet, vestibulum sed nunc.</p>
                                </div>
                                <div class="highlight-btn">
                                    <a class="btn-blue" href="#">Copiar trecho</a>
                                    <a class="btn-blue" href="#">Copiar selecao</a>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li>
                        <h4>Item Loren Ipsum</h4>
                        <p>lorem ipsum habhua  dasgf hdjah d</p>
                    </li>
                    <li>
                        <h4>Item Loren Ipsum</h4>
                        <p>lorem ipsum habhua  dasgf hdjah d</p>
                    </li>
                    <li>
                        <h4>Item Loren Ipsum</h4>
                        <p>lorem ipsum habhua  dasgf hdjah d</p>
                    </li>
                    <li>
                        <h4>Item Loren Ipsum</h4>
                        <p>lorem ipsum habhua  dasgf hdjah d</p>
                    </li>
                    <li>
                        <h4>Item Loren Ipsum</h4>
                        <p>lorem ipsum habhua  dasgf hdjah d</p>
                    </li>
                    <li>
                        <h4>Item Loren Ipsum</h4>
                        <p>lorem ipsum habhua  dasgf hdjah d</p>
                    </li>
                    <li>
                        <h4>Item Loren Ipsum</h4>
                        <p>lorem ipsum habhua  dasgf hdjah d</p>
                    </li>
                    <li>
                        <h4>Item Loren Ipsum</h4>
                        <p>lorem ipsum habhua  dasgf hdjah d</p>
                    </li>
                    <li>
                        <h4>Item Loren Ipsum</h4>
                        <p>lorem ipsum habhua  dasgf hdjah d</p>
                    </li>
                    <li>
                        <h4>Item Loren Ipsum</h4>
                        <p>lorem ipsum habhua  dasgf hdjah d</p>
                    </li>
                    <li>
                        <h4>Item Loren Ipsum</h4>
                        <p>lorem ipsum habhua  dasgf hdjah d</p>
                    </li>
                    <li>
                        <h4>Item Loren Ipsum</h4>
                        <p>lorem ipsum habhua  dasgf hdjah d</p>
                    </li>
                    <li>
                        <h4>Item Loren Ipsum</h4>
                        <p>lorem ipsum habhua  dasgf hdjah d</p>
                    </li>
                    <li>
                        <h4>Item Loren Ipsum</h4>
                        <p>lorem ipsum habhua  dasgf hdjah d</p>
                    </li>
                    <li>
                        <h4>Item Loren Ipsum</h4>
                        <p>lorem ipsum habhua  dasgf hdjah d</p>
                    </li>
                    <li>
                        <h4>Item Loren Ipsum</h4>
                        <p>lorem ipsum habhua  dasgf hdjah d</p>
                    </li>
                    <li>
                        <h4>Item Loren Ipsum</h4>
                        <p>lorem ipsum habhua  dasgf hdjah d</p>
                    </li>
                    <li>
                        <h4>Item Loren Ipsum</h4>
                        <p>lorem ipsum habhua  dasgf hdjah d</p>
                    </li>
                    <li>
                        <h4>Item Loren Ipsum</h4>
                        <p>lorem ipsum habhua  dasgf hdjah d</p>
                    </li>
                    <li>
                        <h4>Item Loren Ipsum</h4>
                        <p>lorem ipsum habhua  dasgf hdjah d</p>
                    </li>
                    <li>
                        <h4>Item Loren Ipsum</h4>
                        <p>lorem ipsum habhua  dasgf hdjah d</p>
                    </li>
                    <li>
                        <h4>Item Loren Ipsum</h4>
                        <p>lorem ipsum habhua  dasgf hdjah d</p>
                    </li>
                    <li>
                        <h4>Item Loren Ipsum</h4>
                        <p>lorem ipsum habhua  dasgf hdjah d</p>
                    </li>
                    <li>
                        <h4>Item Loren Ipsum</h4>
                        <p>lorem ipsum habhua  dasgf hdjah d</p>
                    </li>
                    <li>
                        <h4>Item Loren Ipsum</h4>
                        <p>lorem ipsum habhua  dasgf hdjah d</p>
                    </li>
                    <li>
                        <h4>Item Loren Ipsum</h4>
                        <p>lorem ipsum habhua  dasgf hdjah d</p>
                    </li>
                    <li>
                        <h4>Item Loren Ipsum</h4>
                        <p>lorem ipsum habhua  dasgf hdjah d</p>
                    </li>
                    <li>
                        <h4>Item Loren Ipsums</h4>
                        <p>lorem ipsum habhua  dasgf hdjah d</p>
                    </li>
                </ul>
			</div>
    </div>
</div>



    </div>
</div>