package br.com.ribeiroferreiralucas.b2wchallenge.documents;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "planets")
public class PlanetDocument {

	@Id
	private String id;
	
	@Indexed(name = "name_index", unique = true, sparse = true)
	private String name;
	private String weather;
	private String terrain;
	
	public PlanetDocument() {
	}
	
	public PlanetDocument(String name) {
		super();
		this.name = name;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getTerrain() {
		return terrain;
	}
	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}

	
	
}
