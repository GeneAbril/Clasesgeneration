<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>Registro</title>
            </head>

            <body>
                <div>
                    <c:if test="${msgError!= null}">
                        <c:out value="${msgError}"></c:out>

                    </c:if>

                    <form:form action="/registro/usuario" method="post" modelAttribute="usuario">
                        <!--  estructura para trabajar con formluario-->
                        <form:label path="nombre">Nombre:</form:label>
                        <!--  crea nombre de casilla-->
                        <form:input type="text" path="nombre" />
                        <!--  crear atributos-->
                        <br>
                        <!--  separa lineas-->
                        <form:label path="apellido">Apellido:</form:label>
                        <!--  crea nombre de casilla-->
                        <form:input path="apellido" />
                        <br>
                        <!--  separa lineas-->
                        <form:label path="edad">Edad:</form:label>
                        <!--  crea nombre de casilla-->
                        <form:input type="number" path="edad" />
                        <!--  tipo de dato ya viene dado desde modelo usuario-->
                        <br>
                        <!--  separa lineas-->
                        <form:label path="password">Contraseña</form:label>
                        <form:input type="password" path="password" />
                        <br>
                        <input type="submit" value="Registrar">
                    </form:form>

                </div>
            </body>

            </html>