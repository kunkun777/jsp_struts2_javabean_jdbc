<%@ page language="java" pageEncoding="gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>���԰���Ϣ</title>
</head>
<body>
	<s:set name="user" value="#session['user']"/>
	<s:property value="#user.username"/>�����ã���ӭ��¼���԰塣
</body>
</html>
