package br.com.ribeiroferreiralucas.b2wchallenge.repositories;

import java.util.List;

import br.com.ribeiroferreiralucas.b2wchallenge.model.Planet;

public interface IPlanetRepository {

	public Planet save(Planet planet);
	public Planet findById(String id);
	public List<Planet> findAll();
	public List<Planet> findByName(String name);
	public void delete(String planetId);
}
