package br.com.ribeiroferreiralucas.b2wchallenge.swapi.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SwapiResponsePlanets implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4316136936667459616L;
	
	private Integer count;
	private List<SwapiPlanet> results;
	
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List<SwapiPlanet> getResults() {
		return results;
	}
	public void setResults(List<SwapiPlanet> results) {
		this.results = results;
	}
	@Override
	public String toString() {
		return "SwapiResponsePlanets [count=" + count + ", results=" + results + "]";
	}
	
	
}
