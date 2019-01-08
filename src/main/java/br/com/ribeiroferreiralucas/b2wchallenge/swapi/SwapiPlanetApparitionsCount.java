package br.com.ribeiroferreiralucas.b2wchallenge.swapi;

import java.util.HashMap;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.ribeiroferreiralucas.b2wchallenge.repositories.IPlanetApparitionsCountRepository;
import br.com.ribeiroferreiralucas.b2wchallenge.swapi.entity.SwapiPlanet;
import br.com.ribeiroferreiralucas.b2wchallenge.swapi.entity.SwapiResponsePlanets;

@Repository
public class SwapiPlanetApparitionsCount implements IPlanetApparitionsCountRepository {
    
	public static final String USER_AGENT_NAME = "SWAPI-Java-Client/1.0";

	@Override
	public Integer getApparitionsCount(String planetName) {
		RestTemplate rest = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
	    headers.add("User-Agent", USER_AGENT_NAME);
	    HttpEntity<SwapiResponsePlanets> httpEntity = new HttpEntity<SwapiResponsePlanets>(headers);
	    ParameterizedTypeReference<SwapiResponsePlanets> responseTypeRef = new ParameterizedTypeReference<SwapiResponsePlanets>() {};
		
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
			      .scheme("https").host("swapi.co/api").path("/planets").queryParam("search", planetName).build();		
		
		ResponseEntity<SwapiResponsePlanets> response= rest.exchange(uriComponents.toUri(), HttpMethod.GET, httpEntity, responseTypeRef);
		SwapiResponsePlanets responsePlanets = response.getBody();
				
		
		System.out.println(responsePlanets);
		if(responsePlanets.getCount() == 0) {
			return null;
		}
		
		for (SwapiPlanet resultSwapiPlanet : responsePlanets.getResults()) {
			if(resultSwapiPlanet.getName().toLowerCase().equals(planetName.toLowerCase())) {
				Integer apparitionsCount = resultSwapiPlanet.getFilms().size();
				return apparitionsCount;		
			}
		}
		
		return null;
	}

	@Override
	public HashMap<String, Integer> getApparitionsCount(List<String> planetsName) {
		// TODO Auto-generated method stub
		return null;
	}

}
