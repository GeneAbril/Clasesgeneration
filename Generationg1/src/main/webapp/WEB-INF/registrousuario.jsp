<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro</title>
</head>
<body>
 <div>
 <!--  pasar info desde una vista a una url (action)  -->
 <!--  method get es por default,los parametros se ven en la ruta  -->
 <!--  method post los parametros no se ven,can ocultos  -->
 <form action="/registro/usuario" method="post"> <!--  crear ruta generica con /registro/ a traves de metodo get-->
 <label for=""nombre"> Nombre: </label>
 <input type="texto" id="nombre" name="gato" ><!--  nombre que va a figurar es gato, no necesariamente debe tener mismo nombre que id-->
 <br> <!--  salto de linea -->
 <label for=""apellido"> Apellido: </label> <!--  for: vincula label con input -->
 <input type="texto" id="apellido" name="apellido" >
 <br> <!--  salto de linea -->
  <label for=""edad">Edad: </label> <!--  label capturar informacion -->
 <input type="number" id="edad" name="edad" > <!--  input capturar informacion -->
  <br> <!--  salto de linea -->
  <input type="submit" value="Registrar"> <!--  gatilla acción de enviar informacion -->
  <input type="button" value="Enviar"> <!--  es un boton solamente, se le debe dar funcionalidad-->
 </form> <!--  debe estar todo dentro del form -->
 </div>
</body>
</html>
