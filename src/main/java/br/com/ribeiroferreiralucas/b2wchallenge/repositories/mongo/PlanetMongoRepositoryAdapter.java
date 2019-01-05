package br.com.ribeiroferreiralucas.b2wchallenge.repositories.mongo;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.reflect.TypeToken;

import br.com.ribeiroferreiralucas.b2wchallenge.documents.PlanetDocument;
import br.com.ribeiroferreiralucas.b2wchallenge.dtos.PlanetResponseDTO;
import br.com.ribeiroferreiralucas.b2wchallenge.model.Planet;
import br.com.ribeiroferreiralucas.b2wchallenge.repositories.IPlanetRepository;

@Repository
public class PlanetMongoRepositoryAdapter implements IPlanetRepository {

	@Autowired
	private PlanetMongoRepository planetMongoRepository; 
	@Autowired
	private ModelMapper modelMapper; 
	
	@Override
	public Planet save(Planet planet) {

		PlanetDocument document = modelMapper.map(planet, PlanetDocument.class);
		document = planetMongoRepository.insert(document);
		planet = modelMapper.map(document, Planet.class);
		return planet;
	}

	@Override
	public Planet findById(String id) {
		
		Optional<PlanetDocument> document = planetMongoRepository.findById(id);
		
		if(!document.isPresent()) {
			return null;
		}
		
		Planet planet = modelMapper.map(document.get(), Planet.class);
		
		return planet;
	}

	@Override
	public List<Planet> findByName(String name) {


		List<PlanetDocument> documents = planetMongoRepository.findByName(name);
		
		Type listType = new TypeToken<List<Planet>>(){}.getType();
		List<Planet> planets = modelMapper.map(documents, listType);

		return planets;
	}

	@Override
	public void delete(String planetId) {
		planetMongoRepository.deleteById(planetId);
	}

	@Override
	public List<Planet> findAll() {
		List<PlanetDocument> documents = planetMongoRepository.findAll();
		Type listType = new TypeToken<List<Planet>>(){}.getType();
		List<Planet> planets = modelMapper.map(documents, listType);

		return planets;
	}

	
}
