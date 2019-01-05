package br.com.ribeiroferreiralucas.b2wchallenge.services;

import java.util.List;

import br.com.ribeiroferreiralucas.b2wchallenge.model.Planet;

public interface IPlanetService {
	
	public Planet insert(Planet planet);
	public Planet findById(String id);
	public List<Planet> getAll();
	public List<Planet> searchByName(String name);
	public Planet update(Planet planet);
	public void delete(String planetId);
}
