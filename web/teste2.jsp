<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Prodocs</title>
</head>
<body>
<%@taglib  prefix="s" uri="/struts-tags" %>
<%@taglib  prefix="sj" uri="/struts2-jquery-tags" %>
<%@include file="header.jsp" %>
<script type="text/javascript" src="script/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="script/jquery-ui-1.8.22.custom.min.js"></script>
<script type="text/javascript" src="script/jquery.mCustomScrollbar.min.js"></script>
<script type="text/javascript" src="script/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="script/jquery.mousewheel.min.js"></script>
<script type="text/javascript" src="script/jquery.fancybox-1.3.4.js"></script>
<script type="text/javascript" src="script/functions.js"></script>



<!-- WRAPPER -->

<div class="wrapper">
	<!--<div class="scroll">-->
        <div class="box-main-doc">
        		<!-- Iteração -->
	<div class="editor-container shadows">
                            <center>  <sj:div id="editDoc" name="editDoc" reloadTopics="loadEditor" src="editor" onSuccessTopics="remoteDivLoaded"/></center>
	</div>
        </div>
    <!--</div>-->
    <div class="sidebar shadows">
        <%--   <div class="doc-manager">
    	<a title="Salvar" href="#save" class="btn-blue option-save">Salvar</a>
        <a title="Salvar" href="#save" class="btn-blue option-save">Enviar para aprovação</a>
        <div style="display: none;">
            <div id="save" class="highlight-fancy opt-save">
                <h4>Salvando...</h4>
                <div class="highlight-fancy-content">
                	<br/>
                	<p>Por favor, insira o nome deste documento abaixo:</p>
                    <br/>
                   	<input type="text" />
                </div>
                <div class="highlight-btn">
                    <a class="btn-blue" href="#">Salvar</a>
                    <a class="btn-blue" href="#">Salvar como novo documento</a>
                </div>
            </div>
        </div>
    </div>
        --%>
        
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
<!-- -->
<!-- CONTAINER -->

<!-- -->
<!-- HEADER -->
<div class="footer">

</div>

<!-- -->
</body>
</html>
