package com.generation.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.models.Auto;
import com.generation.services.AutoService;
//API: DISPONE INFO PARA SER CONSUMIDA POR CUALQUIER OTRO USUARIO
@RestController
@RequestMapping("/api")

public class ApiRestController{

@Autowired//inyeccion de dependencias de clase
//instancia de clase,accede a atributos
AutoService autoService;

@RequestMapping("/obtener/autos")
//en restcontroller se debe especificar tipo de dato a retornar

//localhost:8080/api/obtener/autos
//retornar lista->auto->nombre de lista
public List <Auto> obtenerAutos(){
    //find all entrega objetos
    //transforma la lista en un String
List<Auto> listaAutos= autoService.findAll(); //retornar la lista
return listaAutos;
}
//findall retorna una lista
//API (JSON) --> ES UN FORMATO DE TEXTO
}