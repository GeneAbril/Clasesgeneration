package com.generation.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class IndexController {

	
//en los parentesis se establece la anotacion para capturar las rutas,1°ruta
	
	@RequestMapping("/") //vendria siendo localhost (http://localhost:8080/
	
	public String index(Model model) {//capturar valor
		//variable->opcion->  clave-----> valor
		model.addAttribute("apellidos", "Quezada Rodriguez");
		model.addAttribute("nombres", "Genesis Abril");
		model.addAttribute("edad", "27");
		model.addAttribute("direccion", "bahia snug 1787");
		
		//Instancia
		//Usuario usuario = new Usuario("ambar","carrasco",2);
		
		//PASAR OBJETO A LA VUSTA (JSP)
		//model.addAttribute("usuario",usuario);// desde controlador pasa desde jsp la variable
		
		return "index.jsp"; // abrir ruta de otro archivo, siempre en comillas	
	}
}