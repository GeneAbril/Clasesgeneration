<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>auto</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
            </head>

            <body>
                <h1 style="text-align: center">Los datos se han ingresado exitosamente!
                </h1>
                <div class="container">
                    <table class="table table-dark table-striped">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">ID</th>
                                <th scope="col">Marca</th>
                                <th scope="col">Modelo</th>
                                <th scope="col">Color</th>
                                <th scope="col">Velocidad</th>
                            </tr>
                            </th> AGREGAR ID</th>

                        </thead>
                        <tbody>
                            <c:forEach var="auto" items="${autosCapturados}">
                                <!--  mostramos los atributos de  la captura -->
                                <!-- <p>${auto.marca}${auto.modelo}${auto.color}</p> -->
                                <tr>
                                    <th scope="row">${auto.id}</th>
                                    <td>${auto.marca}</td>
                                    <td>${auto.modelo}</td>
                                    <td>${auto.color}</td>
                                    <td>${auto.velocidad}</td>
                                    <!--  Se agrega los botones de acciones editar y eliminar con colores gracoas a bootstrap -->
                                    <td><a class="btn btn-warning" href="/auto/editar/${auto.id}" role="button">Editar</a></td>
                                    <td><a class="btn btn-danger" href="/auto/eliminar/${auto.id}" role="button">Eliminar</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
            </body>

            </html>