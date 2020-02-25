package com.colfuturo.service.impl;

import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.colfuturo.dto.CartaResumenDTO;
import com.colfuturo.model.Carta;
import com.colfuturo.model.TipoCarta;
import com.colfuturo.repo.ITipoCartaRepo;
import com.colfuturo.service.ITipoCartaService;


import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;



@Service
public class TipoCartaServiceImpl implements ITipoCartaService{

	@Autowired
	ITipoCartaRepo repo;

	@Override
	public TipoCarta registrar(TipoCarta tipo) {
		return repo.save(tipo);		
	}

	@Override
	public TipoCarta modificar(TipoCarta tipo) {
		return repo.save(tipo);
	}

	@Override
	public List<TipoCarta> listar() {
		return repo.findAll();
	}

	@Override
	public TipoCarta leerPorId(Integer id) {
		Optional<TipoCarta> obj = repo.findById(id);
		return obj.isPresent() ? obj.get() : new TipoCarta();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

	@Override
	public List<TipoCarta> buscarPorIdioma(String idioma) {
		
		return repo.buscarPorIdioma(idioma);
		
	}

	@Override
	public byte[] generarReporte(Carta carta) {
		byte[] data = null;
		
		//HashMap<String, String> params = new HashMap<String, String>();
		//params.put("txt_empresa", "MitoCode Network");
		List<CartaResumenDTO> cartas = new ArrayList<>();
		
		CartaResumenDTO carta_dto = new CartaResumenDTO();
		carta_dto.setDestino(carta.getDestino());
		carta_dto.setNombre(carta.getTipocarta().getNombre());
		carta_dto.setContenido(carta.getTipocarta().getContenido());
		carta_dto.setNombres(carta.getPersona().getNombres());
		carta_dto.setApellidos(carta.getPersona().getApellidos());
		
		cartas.add(carta_dto);
		
		try {
			File file = new ClassPathResource("/reports/"+ carta.getTipocarta().getUrl()).getFile();
			JasperPrint print = JasperFillManager.fillReport(file.getPath(), null, new JRBeanCollectionDataSource(cartas));
			data = JasperExportManager.exportReportToPdf(print);
		}catch(Exception e) {
			e.printStackTrace();
		}	
		
		return data;
	}

}
