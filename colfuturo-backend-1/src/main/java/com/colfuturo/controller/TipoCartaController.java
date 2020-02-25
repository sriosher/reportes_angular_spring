package com.colfuturo.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.colfuturo.exception.ModeloNotFoundException;
import com.colfuturo.model.Carta;
import com.colfuturo.model.TipoCarta;
import com.colfuturo.service.ITipoCartaService;

@RestController
@RequestMapping("/tipos")
public class TipoCartaController {
	
	@Autowired
	private ITipoCartaService service;
	
	
	@GetMapping
	public ResponseEntity<List<TipoCarta>> listar() {
		List<TipoCarta> lista_tipo_carta = service.listar();
		return new ResponseEntity<List<TipoCarta>>(lista_tipo_carta, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<TipoCarta> leerPorId(@PathVariable("id") Integer id) {
		TipoCarta tipo = service.leerPorId(id);

		if (tipo.getIdTipoCarta() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id); 
		}
		return new ResponseEntity<TipoCarta>(tipo, HttpStatus.OK);
	}

	/*
	 * @PostMapping public ResponseEntity<Especialidad> registrar(@Valid @RequestBody
	 * Especialidad especialidad) { Especialidad obj = service.registrar(especialidad); return new
	 * ResponseEntity<Especialidad>(obj, HttpStatus.OK); }
	 */
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody TipoCarta tipo) {
		TipoCarta obj = service.registrar(tipo);
		// especialidads/4
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getIdTipoCarta()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<TipoCarta> modificar(@Valid @RequestBody TipoCarta tipo) {
		TipoCarta obj = service.modificar(tipo);
		return new ResponseEntity<TipoCarta>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		TipoCarta tipo = service.leerPorId(id);
		if (tipo.getIdTipoCarta() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id); 
		}
		service.eliminar(id);

		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@GetMapping("/buscarporidioma/{idioma}")
	public ResponseEntity<List<TipoCarta>> buscarxIdioma(@PathVariable("idioma") String idioma) {
		List<TipoCarta> lista_tipo_carta = service.buscarPorIdioma(idioma);
		return new ResponseEntity<List<TipoCarta>>(lista_tipo_carta, HttpStatus.OK);
	}
	
	@PostMapping("/generarReporte")
	//@PostMapping(value = "/generarReporte", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> generarReporte(@Valid @RequestBody Carta carta){
		
		byte[] data = null;
		data = service.generarReporte(carta);
		
		return new ResponseEntity<byte[]>(data, HttpStatus.OK);
	}


}
