package com.colfuturo.service;

import java.util.List;

import com.colfuturo.model.Carta;
import com.colfuturo.model.TipoCarta;


public interface ITipoCartaService extends ICRUD<TipoCarta>{
	
	List<TipoCarta> buscarPorIdioma(String idioma);
	byte[] generarReporte(Carta carta);

}
