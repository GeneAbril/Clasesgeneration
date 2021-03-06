package com.generation.api;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")//establecer el inicio de ruta por defecto
public class ParametrosRestController {
	
	//localhost:8080/api?fecha=20220613
@RequestMapping("/")
public String fecha(@RequestParam(value="fecha")String fecha) {
	return "la fecha es: " + fecha;
}
//RUTAS CON PARAMETROS OBLIGATORIOS
//localhost:8080/api/seccion?modulo=3&seccion=5
/*deben estar los 2 parametros*/
@RequestMapping("/seccion")
public String seccion(@RequestParam(value="modulo") String modulo, //metodo
	@RequestParam(value="seccion")String seccion){
	return "el modulo es: " + modulo+ "la seccion es: " + seccion;
}
	//RUTAS CON PARAMETROS NO OBLIGATORIOS
//LA ESTRUCTURA ES LA MISMA PARA TODOS LOS METODOS

//localhost:8080/api/date?anio=2022&mes=6&dia=13
@RequestMapping("/date")                                //required establece si es o no obligatorio       
public String capturaraParametros(@RequestParam(value="anio",required=false)String anio, //param parametros de ruta
		@RequestParam(value="dia",required=false)String dia, //se establece dato a solicitar
		@RequestParam(value="mes",required=false)String mes ) {
	return "";//return imprime en url
	 //sysou imprimeen consola
	
	
	/*if(anio != null) {
		System.out.println();
	}
	if(mes != null) { 
		System.out.println( "el mes es: "+ mes);
	}
	if(dia != null) {
		System.out.println( "el dia es: "+ dia);
	}
	return"la fecha es: " + anio + mes + dia;*/

}
}



