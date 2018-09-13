package br.com.markethub.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.markethub.domain.Marketplace;

public interface MarketplaceRepository extends MongoRepository<Marketplace, String> {

}
