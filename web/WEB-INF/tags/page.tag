<%-- 
    Document   : page.tag
    Created on : Apr 20, 2017, 8:24:57 PM
    Author     : artur
--%>

<%@tag import="com.knight.application.ConfigurationManager"%>
<%@tag import="com.knight.ApplicationUtilities"%>

<%--<%@tag description="utilitario" body-content="scriptless" pageEncoding="UTF-8"%>--%>
<%--<%!public ApplicationUtilities app = ApplicationUtilities.getInstance();%>--%>
<%--<%!public ConfigurationManager cfg = ConfigurationManager.getInstance();%>--%>

<%@attribute name="title" required="true" type="String"%>

<html>
    <head>
        <meta charset="UTF-8">
        
        <title>Knight System(${title})</title>

        <link rel="stylesheet" href="assets/materialize/dist/css/materialize.min.css" type="text/css"/>
        <link rel="stylesheet" href="assets/sweetalert/dist/sweetalert.css" type="text/css"/>
        <link rel="stylesheet" href="assets/jquery-ui/themes/smoothness/jquery-ui.min.css" type="text/css"/>
        <link rel="stylesheet" href="assets/components-font-awesome/css/font-awesome.min.css" type="text/css"/>
        <link rel="stylesheet" href="assets/css/application.css" type="text/css"/>

        <script type="text/javascript" src="assets/jquery/dist/jquery.min.js"></script>
        <script type="text/javascript" src="assets/jquery-ui/jquery-ui.min.js"></script>
        <script type="text/javascript" src="assets/materialize/dist/js/materialize.min.js"></script>
        <script type="text/javascript" src="assets/sweetalert/dist/sweetalert.min.js"></script>
        <script type="text/javascript" src="assets/js/application.js"></script>
    </head>
    
     <jsp:doBody/>
     
</html>