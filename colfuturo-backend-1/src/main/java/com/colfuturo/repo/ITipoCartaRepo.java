package com.colfuturo.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.colfuturo.model.TipoCarta;



@Repository
public interface ITipoCartaRepo extends JpaRepository<TipoCarta, Integer>{
	
	@Query("from TipoCarta c where c.idioma =:idioma")
	List<TipoCarta> buscarPorIdioma(@Param("idioma") String idioma);

}
