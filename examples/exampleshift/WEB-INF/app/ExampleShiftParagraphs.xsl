<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/root">
		<!-- ======================================================================================== -->
		<html>
			<head>
				<meta charset="utf-8"></meta>
				<meta content="no-cache" http-equiv="cache-control"/>
				<meta content="no-cache" http-equiv="pragma"/>
				<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=0"/>
				<title>Paloula Shift Example 1</title>
				<link href="app/css/examples.css" rel="stylesheet"/>
			</head>
			<body>
				<header id="app-example-logo-wrapper">
					<img class="app-logo" src="app/img/logo_1000_001.png"/>
					<img class="app-slogan" src="app/img/slogan_1000_002.png"/>
				</header>	

				<main class="app-example-content">
					<div class="app-example-multipart-articles-wrapper">
						<ul class="app-example-multipart-articles">
							<li class="app-example-multipart-article" data-part="1">
								<h1>de.paloula.xml.sequence.Sequence</h1>
								<h1>Beispiel 1 - Shift</h1>
								<p>Ein einfaches Server/Client-Beispiel zeigt, wie der serverseitige XML-Content(org.jdom2.Document) komfortabel verändert wird.</p>
								<p>Es genügt dabei, die ID des zu bearbeitenden Artikles (plus ein Kommando) per Parameter an das Servlet(ShiftParagraphServlet.java) zu übergeben.</p>
								<h1>Verwendete Methoden:</h1>
								<ul class="app-example-multipart-article-methods">
										<li class="app-example-multipart-article-methods"><strong>shiftNextWithinTagNameSiblings</strong>(@NotNull String shiftElementId)</li>
										<li><strong>shiftPreviousWithinTagNameSiblings</strong>(@NotNull String shiftElementId)</li>
										<li><strong>deleteWithinTagNameSiblings</strong>(String deleteElementId)</li>
										<li><strong>insertBeforeWithinTagNameSiblings</strong>(@NotNull String beforeElementId, @NotNull Element insertElement)</li>
										<li><strong>insertAfterWithinTagNameSiblings</strong>(@NotNull String afterElementId, @NotNull Element insertElement)</li>
										<li><strong>insertAtWithinTagNameSiblings</strong>(@NotNull String siblingElementId, @NotNull Element insertElement, int targetPosition)</li>
								</ul>
								<button class="app-example-multipart-article-next"></button>
							</li>
							<!-- ===================================================== -->
							<li id="exampleArticles" class="app-example-multipart-article" data-part="2">

								<xsl:choose>
									<xsl:when test=" count(./article) &gt; 0">
										<xsl:for-each select="./article">
											<xsl:sort select="./@pos"/>
											<article class="app-example-article">

												<p><xsl:value-of select="." /></p>

												<div class="app-example-edit-article" id="{./@id}" data-pos="{./@pos}">
													<div class="app-example-edit-article-buttons">

														<xsl:choose>
															<xsl:when test="position() &gt; 1">
																<button class="app-example-article-edit-button app-example-icon-up" title="Shift paragraph up" data-article-id="{./@id}"></button>
															</xsl:when>
															<xsl:otherwise>
																<div class="app-example-article-edit-button-dummy"></div>
															</xsl:otherwise>
														</xsl:choose>

														<button class="app-example-article-edit-button app-example-icon-new-up"  title="New paragraph above" data-article-id="{./@id}"></button>
													</div>
													<div class="app-example-edit-article-buttons">
														<button class="app-example-article-edit-button app-example-icon-delete" title="Delete paragraph" data-article-id="{./@id}"></button>
													</div>
													<div class="app-example-edit-article-buttons">

														<xsl:choose>
															<xsl:when test="position() != last()">
																<button class="app-example-article-edit-button app-example-icon-down" title="Shift paragraph dwown" data-article-id="{./@id}"></button>
															</xsl:when>
															<xsl:otherwise>
																<div class="app-example-article-edit-button-dummy"></div>
															</xsl:otherwise>
														</xsl:choose>

														<button class="app-example-article-edit-button app-example-icon-new-down"  title="New paragraph underneath" data-article-id="{./@id}"></button>
													</div>										
												</div>											

											</article>
										</xsl:for-each>
									</xsl:when>
									<xsl:otherwise>
											<button class="app-example-article-edit-button app-example-icon-new-down-empty"  title="New paragraph underneath" data-article-id="{./@id}"></button>
									</xsl:otherwise>
								</xsl:choose>

								<div class="app-example-xml-display">
									<div class="app-example-xml-display-menubar">
										<button class="app-example-article-edit-button app-example-icon-back" title="Shift paragraph up" data-article-id="{./@id}"></button>
									</div>
									<p>Server XML</p>
									<pre id="displayXml"></pre>
								</div>

							</li>
						</ul>
					</div>
				</main>

				<script>
							var paloula = {};
							paloulaAppUrl = "";
				</script>
				<script src="app/js/jquery-3.2.1.min.js"></script> 
				<script src="app/js/app-example.js"></script> 
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>
