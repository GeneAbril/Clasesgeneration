package com.generation.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.generation.models.Usuario;
import com.generation.services.UsuarioService;



@Controller
@RequestMapping("/registro")//ruta por default
public class RegistroControllers {
	
//inyeccion de dependencias, traer al controlador una clase
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping("")//ruta para desplegar jsp
	
	//pasar un objeto vacio al jsp --model ->nombreattribute-> objeto ->nombreobjeto 
	public String registro(@ModelAttribute("usuario") Usuario usuario) {//creacion de objeto usuario,se pasara al jsp
		return "registro.jsp";//pag a desplegar
	}
	
	//generar ruta /registro/usuario
	//CAPTURAR DATOS DE USUARIO
	//POSTMAPPING: recibir a traves de un formulario post. para que la url no nos de parametros.

	/*CAPTURAR VARIABLE VACIA*/
	@PostMapping("/usuario/respaldo")//ruta          <Establece nombre>
	public String registroUsuario(@RequestParam(value="gato") String nombre,
			@RequestParam(value="apellido") String apellido,
			@RequestParam(value="edad") String edad) {
		
		//se debe concatenar 
		System.out.println("parametro gato" + nombre);//verificar mapeo entre jsp y consola
		System.out.println("parametro gato" + apellido);//capturar dato y visualizar en consola
		System.out.println("parametro gato" + edad);// mensaje que se visualizara en consola
		
		
		return "registro.jsp";//pag a desplegar
	}
	
	/*CAPTURAR OBJETOS CON ATRIBUTOS LLENOS*/
	@PostMapping("/usuario")
	public String guardarUsuario(@Valid @ModelAttribute("usuario") Usuario usuario, 
			BindingResult resultado, Model model) {//BINDINGRESULT: se verifica si se cumple con condicion size
		
		if(resultado.hasErrors()){//captura si existe un error en el ingreso de datos desde jsp
	model.addAttribute("msgError","Ingrese datos correctamente");
			return "registro.jsp";
		}
		
		
System.out.println(usuario.getNombre() + " "+ usuario.getApellido() + " "+ usuario.getEdad());
	
//enviar objeto al servicio
usuarioService.saveUsuario(usuario);

List <Usuario> listaUsuarios =usuarioService.findAll();
model.addAttribute("usuariosCapturados",listaUsuarios);

		return "usuarios.jsp";//enviar a index para enviar a ese jsp
	}
	
}
