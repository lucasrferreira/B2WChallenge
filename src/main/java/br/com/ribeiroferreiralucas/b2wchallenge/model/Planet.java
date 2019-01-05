package br.com.ribeiroferreiralucas.b2wchallenge.model;

public class Planet {

	private String id;
	private String name;
	private String weather;
	private String terrain;
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
	
	@Override
	public String toString() {
		return "Planet [id=" + id + ", name=" + name + ", weather=" + weather + ", terrain=" + terrain + "]";
	}
	
	
}
