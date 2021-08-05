<%@ page import="com.example.smtp.SmtpApplication" %>
<%@ page import="com.example.smtp.SMTPController" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>

<%
    SMTPController ms = new SMTPController();
    ms.index();

    System.out.println("COMPLETE");
%>
</body>