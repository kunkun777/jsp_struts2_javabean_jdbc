<%@ page language="java" pageEncoding="gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>�������԰�</title>
</head>
<body bgcolor="#E3E3E3">
<%--<s:form action="main" method="post" theme="simple">--%>
<s:form action="main" method="post">
<table>
	<caption>�û���¼</caption>
	<tr>
		<td>
			�û�����<s:textfield name="user.username" size="20"/>
		</td>
	</tr>
	<tr>
		<td>
			��&nbsp;&nbsp;�룺<s:password name="user.password" size="21"/>
		</td>
	</tr>
	<tr>
		<td>
			<s:submit value="��¼"/>
			<s:reset value="����"/>
		</td>
	</tr>
</table>
</s:form>
���ûע�ᵥ��<a href="">����</a>ע�ᣡ
</body>
</html>
