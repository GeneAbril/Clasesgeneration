package com.generation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.generation.models.Usuario;


//REPOSITORY GUARDA LA INFO
@Repository
//JpaRepository<objeto, tipo de dato de la foreing key>
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
/** las interfaces solo definen los metodos**/
/**EJECUTAR QUERYS Y USAR METODOS QUE SE CONECTAN A LA BASEDEDATOS**/

}
