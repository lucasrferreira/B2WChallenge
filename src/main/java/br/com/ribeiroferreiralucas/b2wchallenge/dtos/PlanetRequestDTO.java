package br.com.ribeiroferreiralucas.b2wchallenge.dtos;

import javax.validation.constraints.NotEmpty;

public class PlanetRequestDTO {
	
	@NotEmpty(message = "Nome não pode ser vazio")
	private String name;
	private String weather;
	private String terrain;
	
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

	
	@Override
	public String toString() {
		return "PlanetDto [ name=" + name + ", weather=" + weather + ", terrain=" + terrain + "]";
	}

	
	
}
