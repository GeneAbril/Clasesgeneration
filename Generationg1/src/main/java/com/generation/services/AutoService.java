package com.generation.services;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.generation.models.Auto;
import com.generation.repositories.AutoRepository;

@Service
@Transactional 
public class AutoService {
	@Autowired 
	AutoRepository autoRepository;

	//guardar un auto 
	public void guardarAuto(@Valid Auto auto) {
		autoRepository.save(auto);
		
	}
	//obtener una lista de autos
	public List<Auto> findAll() {
		
		return autoRepository.findAll();
	}
public Auto buscarId(Long id){
	// findbyid= es de tipo opcional con-> .get especifica el tipo de dato, auto en este caso
	return autoRepository.findById(id).get();
}
public void eliminarPorId(Long id) {
autoRepository.deleteById(id);

}
public List<Auto> buscarMarca(String marca) {
	//llamado a un metodo propio
	//return autoRepository.findAllAutoMarca(marca);
	return autoRepository.findAllAutoMarca(marca);// uso del objeto
}

//PAGINACION se usa para retornar lista pero por cantidades, pasar pagina
//cantidad de datos a mostrar por paginas
//variable estatica, PONER EN MAYUSCULA PORQUE ES ESTATICA
private static final int LOTE = 5;// cantidad de datos a mostrar por pagina

public Page<Auto> paginarAutos(int numeroPagina){
	//page request permite capturar la info
	//sort permite ordenar de manera asc o desc
	PageRequest pageRequest = PageRequest.of(numeroPagina, LOTE,Sort.Direction.DESC,"marca");
	//Page<Auto> autos = autoRepository.findAll(pageRequest);
	return autoRepository.findAll(pageRequest);

}


}
