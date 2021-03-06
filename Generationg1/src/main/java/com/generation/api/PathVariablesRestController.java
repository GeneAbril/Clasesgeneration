package com.generation.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//localhost:8080/var
@RequestMapping("/var")//para rutas ("/m") se utiliza cuando el usuario se conecta desde el movil
public class PathVariablesRestController {

	
	/**capturar variables desde la ruta o path de url**/
	//valor entre llaves es dinamico(pueden cambiar),captura valores de la ruta
	
	/**RUTA LARGA**/
	//localhost:8080/var/anio/2023/mes/6/dia/13
	@RequestMapping("/anio/{a}/mes/{m}/dia/{d}")//cuando se quiera acceder a la ruta estara compuesta de esta linea

	//estructura base delos metodos
	//metodo->tipo de dato-> nombre->capturar dato->nombre de dato-> tipo->nombre de variable a capturar
	public String capturarVariablesPath(@PathVariable("a")String anio,
			@PathVariable("m")String mes,
			@PathVariable("d")String dia) {//
		return "la fecha es: "+ anio+ "/" +mes + "/" +dia;
				
	}
	/**RUTA CORTA**/
	//localhost:8080/var/anio/2023/6/13
	@RequestMapping("/fecha/{anio}/{mes}/{dia}")
	public String capturarVariablesPath1(@PathVariable("anio")String anio,
			@PathVariable("mes")String mes,
			@PathVariable("dia")String dia) {//
		return "la fecha es: "+anio+"/"+mes+"/"+dia;

	
}
}