<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="kn" tagdir="/WEB-INF/tags"%>

<kn:page title="Login">
    <jsp:include page="/WEB-INF/zul/login.zul">
        <jsp:param name="controller" value="com.knight.composers.LoginComposer"/>
    </jsp:include>
</kn:page>