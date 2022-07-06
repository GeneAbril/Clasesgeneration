package com.generation.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.generation.models.Auto;

@Repository
public interface AutoRepository extends JpaRepository<Auto, Long>{
//JPQL, 2 formas de llamar
//1°USAMOS OBJETO permite uso de eager o lazy
       // -> objeto auto-> alias de auto (a)-> haciendo uso del objeto no de la tabla
//pregunta por objeto y entrega objeto
@Query("SELECT a FROM Auto a a.marca= ?1")
//objeto -> marca
List<Auto> findAllAutoMarca(String marca);

//2°QUERY TRADICIONAL permite uso de eager o lazy
@Query(value="SELECT*FROM autos a WHERE a.marca= ?1",nativeQuery = true)
    List<Auto> buscarMarca(String marca);

    //filtro por algunas columnas de la tabla, retorna objeto no una entidad    @Query(value="SELECT a.marca, a.color FROM autos a WHERE a.marca = ?1 and a.color=?2",nativeQuery = true)
	List<Object[]> buscarMarcaColor(String marca, String color);

    //JOIN, retorna lista de autos
    @Query("SELECT a from a Auto a JOIN a.CompraVenta cv")
    List<Auto> buscarAutosVendidos();
    //QUERYS, HACER CONSULTA ESPECIFICA A BASE DE DATOS
    

}