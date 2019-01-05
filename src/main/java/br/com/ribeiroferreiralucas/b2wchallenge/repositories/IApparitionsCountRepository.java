package br.com.ribeiroferreiralucas.b2wchallenge.repositories;

import java.util.HashMap;
import java.util.List;

public interface IApparitionsCountRepository {
	
	Integer getApparitionsCount(String planetName);
	HashMap<String, Integer> getApparitionsCount(List<String> planetsName);

}
