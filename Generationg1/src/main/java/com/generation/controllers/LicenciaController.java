package com.generation.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.generation.models.Licencia;
import com.generation.models.Usuario;
import com.generation.services.LicenciaService;
import com.generation.services.UsuarioService;

@Controller
@RequestMapping("/licencia")
public class LicenciaController {
    //inyeccion de dependencia
    //usar metodo
    @Autowired
    LicenciaService licenciaService;
    
//inyeccion de dependencia
    //usar metodo
    @Autowired
    UsuarioService usuarioService;
    //para desplegar jsp
    @RequestMapping("")
 //Model model pasar objeto 
    public String depliegue(Model model){
        Licencia licencia = new Licencia();
        //licencia.setEstado("activo");
        model.addAttribute("licencia", licencia);

        //buscar lista de usuarios en licencia controller
        //lista-> nombre modelo-> nombre de lista-> usuarioservice(service)-> find all
        List<Usuario> listaUsuarios = usuarioService.findAll();

        //va al jsp a traves del model attribute
        //model -> nombre lista -> variable indicada
model.addAttribute("listaUsuarios", listaUsuarios);
//enviar de licencias a jsp
List<Licencia> listaLicencias = licenciaService.findAll();
model.addAttribute("listaLicencias", listaLicencias);
        return "licencia.jsp";
    }
@PostMapping("/guardar")
public String guardarLicencia(@Valid @ModelAttribute("licencia") Licencia licencia){
    licenciaService.save(licencia);
    return"redirect:/licencia";
}

}


