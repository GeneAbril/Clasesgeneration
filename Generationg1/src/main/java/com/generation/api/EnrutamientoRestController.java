package com.generation.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;//controller importado

//Restcontroller despliega la pagina web
@RestController //importar controller, ruta controlador
public class EnrutamientoRestController {
	//en los parentesis se establece la anotacion para capturar las rutas,1°ruta
		
		
		//enrutamientos
		@RequestMapping("/usuario")
		public String usuario() {//METODO
			return "estamos en la url usuario";
		}
		@RequestMapping("/usuario/inscrito")
		public String inscrito() {
			return "estamos en la url usuario/inscrito";
		}
		@RequestMapping("/usuario/registrado")
		public String cliente() {
			return "Ruta de cliente";
		
	}
		@RequestMapping(value = "/proveedor/registrado", method= RequestMethod.GET)
		public String proveedor() {
			return "Ruta de proveedor";
		
	}
	
}
