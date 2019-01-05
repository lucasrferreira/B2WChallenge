package br.com.ribeiroferreiralucas.b2wchallenge.dtos;

import javax.validation.constraints.NotEmpty;

public class PlanetResponseDTO {
	
	private String id;
	
	@NotEmpty(message = "Nome não pode ser vazio")
	private String name;
	private String weather;
	private String terrain;
	private Integer appearancesCount;
	
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
	public Integer getAppearancesCount() {
		return appearancesCount;
	}
	public void setAppearancesCount(Integer appearancesCount) {
		this.appearancesCount = appearancesCount;
	}
	
	@Override
	public String toString() {
		return "PlanetDto [id=" + id + ", name=" + name + ", weather=" + weather + ", terrain=" + terrain
				+ ", appearancesCount=" + appearancesCount + "]";
	}

	
	
}
