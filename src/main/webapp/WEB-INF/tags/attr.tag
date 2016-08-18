<%--
<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ attribute name="condition" required="true" type="java.lang.Boolean" rtexprvalue="true"%>
<% if(condition) {%>
Condition is true
<% } else { %>
Condition is false
<% } %>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="condition" required="true" type="java.lang.Boolean" rtexprvalue="true"%>
<c:choose>
	<c:when test="${condition }">Condition is true</c:when>
	<c:otherwise>Condition is false</c:otherwise>
</c:choose>