package com.generation.services;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.generation.models.Usuario;
import com.generation.repositories.UsuarioRepository;

@Service
public class UsuarioService {
/*llamar al repositoru(inyeccion de deendencia)*/
	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	public void saveUsuario(@Valid Usuario usuario) {
	
		usuarioRepository.save(usuario);
	}


    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }
	

/**Logica de negocio o validaciones de sistema**/
/**LLAMAR AL REPOSITORY, es una instancia(inyeccion de dependencia)**/
}
