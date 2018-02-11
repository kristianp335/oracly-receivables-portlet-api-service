<%@ include file="/init.jsp" %>

<%  
List receivableList = (List) renderRequest.getAttribute("receivableList");
int receivableCount = (int) renderRequest.getAttribute("receivableCount"); 
PortletURL myPortletUrl = renderResponse.createRenderURL();
SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");


%>
<!--  link between two jsp pages without bothering to create an MVC Renderer - useful -->
<portlet:renderURL var="addReceivable">
	<portlet:param name="jspPage" value="/create/addReceivable.jsp" />
</portlet:renderURL>


<div style = "margin-left: 93%"><a href="${addReceivable}"><span style="padding: 10px;" aria-hidden="true" class="icon-plus icon-2x"></a></span></div>

		<liferay-ui:search-container delta="10"
		 curParam="cur1"
		 deltaConfigurable="false"
		 iteratorURL="<%= myPortletUrl %>"
		 total="<%= receivableCount %>"
		 id="projects" 
		 emptyResultsMessage="Sorry there are no projects are available">
		
			<aui:nav-bar cssClass="collapse-basic-search" markupView="lexicon">
					<aui:nav-bar-search>
						<aui:form action="<%= myPortletUrl.toString() %>" name="searchFm">
							<aui:input id="clickedField" name="clickedField" type="hidden" value="blank">
							</aui:input>					
							<liferay-ui:input-search markupView="lexicon" />
						</aui:form>
					</aui:nav-bar-search>
			</aui:nav-bar>
		
			<aui:form action="<%= myPortletUrl.toString() %>" id="filters" name="filters">
					<!-- JSTL iterator combined with a liferay aui taglib select will perform the filtering requirement -->  
					<!-- <aui:select id="projectCategory" name="projectCategory" label="Project Category">
									<c:forEach var="projectCategory" items="${projectCategory}">
										<aui:option value="${projectCategory}">${projectCategory}</aui:option>		
									</c:forEach>					
					</aui:select> -->
				</aui:form>
			<liferay-ui:search-container-results
				results="<%= receivableList %>"
				
			/>
		
			<liferay-ui:search-container-row	
				className="com.liferay.oracly.accounts.receivable.model.Receivable"
				keyProperty="receivableId"
				modelVar="receivable"
			>
			
				<liferay-ui:search-container-column-text
					title="${receivable.getSupplierName()}"
				    cssClass="col-md-4 flex-item-break-xs card-row-padded"
					name="Debtor"
					value="<%= receivable.getSupplierName() %>"
				/>
				<liferay-ui:search-container-column-text
					name="Description"
					value="<%= receivable.getDescription() %>"
				/>
				
				<liferay-ui:search-container-column-text
					name="Amount £"
					value="<%= receivable.getAmount().toString() %>"
				/>
				
								
				<liferay-ui:search-container-column-text
					name="Due Date"
					value="<%= dateFormat.format(receivable.getDueDate()).toString() %>"
				/>
				<liferay-ui:search-container-column-text
					name="Status">
					<c:choose>
			  			<c:when test="${receivable.getFlag() != 0 }">	
			  				<span style="padding: 10px; color: red;" aria-hidden="true" class="icon-warning-sign"></span>
			  			</c:when>
						<c:otherwise>						
			  				<span style="padding: 10px;" aria-hidden="true" class="icon-thumbs-up"></span>			  				
						</c:otherwise>
					</c:choose>
				</liferay-ui:search-container-column-text>
				
				<liferay-ui:search-container-column-text name="Invoice"	>
					<a href="<%= receivable.getPath() %>" target="blank"><span style="padding: 10px;" aria-hidden="true" class="icon-download"></span></a>
				</liferay-ui:search-container-column-text>
				
				
							
				</liferay-ui:search-container-row>		
				<liferay-ui:search-iterator markupView="lexicon"  />
			</liferay-ui:search-container>
	



