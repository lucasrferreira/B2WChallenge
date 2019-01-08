package br.com.ribeiroferreiralucas.b2wchallenge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ribeiroferreiralucas.b2wchallenge.model.Planet;
import br.com.ribeiroferreiralucas.b2wchallenge.repositories.IPlanetApparitionsCountRepository;
import br.com.ribeiroferreiralucas.b2wchallenge.repositories.IPlanetRepository;

@Service
public class PlanetService implements IPlanetService{

	@Autowired
	private IPlanetRepository planetRepository;
	@Autowired
	private IPlanetApparitionsCountRepository planetApparitionsCountRepository;
	
	@Override
	public Planet insert(Planet planet) {
		Planet savedPlanet = planetRepository.save(planet);
		
		fillApparitionsCount(savedPlanet);
		
		return savedPlanet;
	}

	@Override
	public Planet findById(String id) {
		Planet planet = planetRepository.findById(id);
		fillApparitionsCount(planet);
		return planet;
	}

	@Override
	public List<Planet> searchByName(String name) {
		List<Planet> foundPlanets = planetRepository.findByName(name);
		
		for (Planet planet : foundPlanets) {
			fillApparitionsCount(planet);
		}
		
		return foundPlanets;
	}

	@Override
	public Planet update(Planet planet) {
		Planet savedPlanet = planetRepository.save(planet);
		
		fillApparitionsCount(savedPlanet);
		
		return savedPlanet;
	}

	@Override
	public void delete(String planetId) {
		planetRepository.delete(planetId);
	}

	@Override
	public List<Planet> getAll() {
		List<Planet> foundPlanets = planetRepository.findAll();
		
		for (Planet planet : foundPlanets) {
			fillApparitionsCount(planet);
		}
		
		return foundPlanets;
	}
	
	
	private void fillApparitionsCount(Planet planet) {
		Integer appearancesCount = planetApparitionsCountRepository.getApparitionsCount(planet.getName());
		planet.setAppearancesCount(appearancesCount);
	}
	
}
