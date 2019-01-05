package br.com.ribeiroferreiralucas.b2wchallenge.repositories.mongo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.ribeiroferreiralucas.b2wchallenge.documents.PlanetDocument;

public interface PlanetMongoRepository extends MongoRepository<PlanetDocument, String>{

	List<PlanetDocument> findByName(String name);
	
}
