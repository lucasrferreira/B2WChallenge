package br.com.ribeiroferreiralucas.b2wchallenge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ribeiroferreiralucas.b2wchallenge.model.Planet;
import br.com.ribeiroferreiralucas.b2wchallenge.repositories.IPlanetRepository;

@Service
public class PlanetService implements IPlanetService{

	@Autowired
	private IPlanetRepository planetRepository;
	
	@Override
	public Planet insert(Planet planeta) {
		return planetRepository.save(planeta);
	}

	@Override
	public Planet findById(String id) {
		return planetRepository.findById(id);
	}

	@Override
	public List<Planet> searchByName(String name) {
		return planetRepository.findByName(name);
	}

	@Override
	public Planet update(Planet planet) {
		return planetRepository.save(planet);
	}

	@Override
	public void delete(String planetId) {
		planetRepository.delete(planetId);
	}

	@Override
	public List<Planet> getAll() {
		return planetRepository.findAll();
	}
	
	
}
