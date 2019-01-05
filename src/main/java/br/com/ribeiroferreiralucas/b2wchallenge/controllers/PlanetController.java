package br.com.ribeiroferreiralucas.b2wchallenge.controllers;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.reflect.TypeToken;

import br.com.ribeiroferreiralucas.b2wchallenge.dtos.PlanetRequestDTO;
import br.com.ribeiroferreiralucas.b2wchallenge.dtos.PlanetResponseDTO;
import br.com.ribeiroferreiralucas.b2wchallenge.model.Planet;
import br.com.ribeiroferreiralucas.b2wchallenge.responses.Response;
import br.com.ribeiroferreiralucas.b2wchallenge.services.IPlanetService;

@RestController
@RequestMapping("/v1/planets")
public class PlanetController {

	@Autowired
	private IPlanetService planetService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping
	public ResponseEntity<Response<List<PlanetResponseDTO>>> get(@RequestParam(required=false) String name){
		Response<List<PlanetResponseDTO>> response = new Response<List<PlanetResponseDTO>>();

		List<PlanetResponseDTO> planetsDto;
		List<Planet> planets;
		
		if(name == null || name.isEmpty()) {
			planets = planetService.getAll();
		}else {
			planets = planetService.searchByName(name);
		}

		Type listType = new TypeToken<List<PlanetResponseDTO>>(){}.getType();
		planetsDto = modelMapper.map(planets, listType);
		
		response.setData(planetsDto);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping
	public ResponseEntity<Response<PlanetResponseDTO>> insert(@Valid @RequestBody PlanetRequestDTO planetDto, BindingResult result, UriComponentsBuilder uriBuilder ){
		Response<PlanetResponseDTO> response = new Response<PlanetResponseDTO>();
		
		if(result.hasErrors()) {
			response.setErrors(new ArrayList<String>());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		Planet planet = modelMapper.map(planetDto, Planet.class);
		planet = planetService.insert(planet);
		
		PlanetResponseDTO planetResponseDto = modelMapper.map(planet, PlanetResponseDTO.class);
		
		response.setData(planetResponseDto);
		
		UriComponents uriComponents = 
				uriBuilder.path("/planets/{id}").buildAndExpand(planetResponseDto.getId());
		
		return ResponseEntity.created(uriComponents.toUri()).body(response);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Response<PlanetResponseDTO>> getById(@PathVariable String id){	
		Response<PlanetResponseDTO> response = new Response<PlanetResponseDTO>();

		Planet planet = planetService.findById(id);
		if(planet == null) {
			return ResponseEntity.notFound().build();
		}
		PlanetResponseDTO planetDto = modelMapper.map(planet, PlanetResponseDTO.class);
		
		response.setData(planetDto);
		
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Response<PlanetResponseDTO>> remove(@PathVariable String id){
		
		planetService.delete(id); 
		
		return ResponseEntity.noContent().build();
	}
}
