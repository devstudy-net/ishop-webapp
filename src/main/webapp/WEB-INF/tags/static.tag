<%@ tag import="java.util.Date"%>
<%@ tag import="java.text.SimpleDateFormat"%>
<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
Current date: <%=new SimpleDateFormat("dd-MM-yyyy").format(new Date()) %>