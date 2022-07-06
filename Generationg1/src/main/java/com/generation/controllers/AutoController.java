package com.generation.controllers;


import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.generation.models.Auto;
import com.generation.services.AutoService;



@Controller
@RequestMapping("/auto")
public class AutoController {
	@Autowired
	AutoService autoService;
	
	@RequestMapping("")
	public String inicio(@ModelAttribute("auto") Auto auto) {
		
		return "auto.jsp";
	}
	
	@PostMapping("/guardar")
	public String guardarAuto(@Valid @ModelAttribute("auto") Auto auto,
			BindingResult resultado,
			Model model) {
		
		
		if(resultado.hasErrors()) {
			model.addAttribute("msgError","Datos erroneos");
			return "mostrarAutos.jsp";
		}else {
			//enviamos el obJeto a persistir en base datos
			autoService.guardarAuto(auto);
			//obtener un alista de autos
			List<Auto> listaAutos = autoService.findAll();
			//pasamos la lista de autos al jsp
			model.addAttribute("autosCapturados", listaAutos);
			return "mostrarAutos.jsp";
		}
		
		
	}
	//solo mostrar enlistado de autos
@RequestMapping("/mostrar")
public String mostrar(Model model){
//obtener un alista de autos
List<Auto> listaAutos = autoService.findAll();
//pasamos la lista de autos al jsp
model.addAttribute("autosCapturados", listaAutos);
return "mostrarAutos.jsp";
}
@RequestMapping("/editar/{id}")

public String editar(@PathVariable("id")Long id, Model model){
	System.out.println("el id es: " + id);
	Auto auto =autoService.buscarId(id); //buscar objeto auto
	model.addAttribute("auto",auto);

	return "editarauto.jsp";
	//return "redirect:/auto/mostrar";//redireccionar a otra path o url

	//localhost:8080/auto/actualizar/{id}-> actualizar para la persistencia de bbd	
}
@PostMapping("/actualizar/{id}")
	public String actualizarAuto(@PathVariable("id") Long id,@Valid @ModelAttribute("auto") Auto auto,
			BindingResult resultado,
			Model model) {
		
		
		if(resultado.hasErrors()) {
			model.addAttribute("msgError","Datos erroneos");
			return "editarauto.jsp";
		}else {
			auto.setId(id);
			//enviamos el objeto a persistir en base datos
			autoService.guardarAuto(auto);
			//obtener un alista de autos
			List<Auto> listaAutos = autoService.findAll();
			//pasamos la lista de autos al jsp
			model.addAttribute("autosCapturados", listaAutos);
			return "redirect:/auto/mostrar";
		}
}

@RequestMapping("/eliminar/{id}")

//pathvariable para capturar id
public String eliminarAuto(@PathVariable("id")Long id){
autoService.eliminarPorId(id);

return "redirect:/auto/mostrar"; //llamar a la ruta mostrar y cargar jsp
}

//FILTRAR DATOS 
@PostMapping("/buscar")//establecer ruta
//metodo buscar -> capturar parametro marca -> guardar en variable marca
public String buscar(@RequestParam(value="marca")String marca, Model model){
	if(marca.equals("")) {
		return "redirect:/auto/mostrar";
	}	
	//retornar lista de auto
	//1° llegar al service 
	List<Auto> listaAutos = autoService.buscarMarca(marca);	
	if(listaAutos.size()< 1){
	model.addAttribute("msgAuto", "Autonoencontrado");
} 
	
	model.addAttribute("autosCapturados", listaAutos);

return"mostrarAutos.jsp";//retorna en url
}

//paginasautos
	//siempre ver en que pag estams posicionados
@RequestMapping("/pagina/{numeroPagina}")
//metodo
public String paginarAutos(@PathVariable("numeroPagina")int numeroPagina, Model model){
	Page<Auto>listaAutos = autoService.paginarAutos(numeroPagina -1);// para que sea pag 0 por default
	model.addAttribute("autosCapturados", listaAutos);
	//pasar numero total de paginas
	//TOTALPAGE: se calcula considerando el total de elementos dividido por lote
	model.addAttribute("totalPaginas", listaAutos.getTotalPages());

	return "autosPaginados.jsp";
}
}