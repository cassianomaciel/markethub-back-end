package br.com.markethub.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;

import br.com.markethub.domain.Marketplace;
import br.com.markethub.repository.MarketplaceRepository;

public class MarketplaceService {
	
	@Value("${marketplace.mercado-livre.id}")
	private Integer ID_MERCADO_LIVRE;

	@Value("${marketplace.mercado-livre.secret}")
	private String SECRET_MERCADO_LIVRE;
	
	private MarketplaceRepository marketplaceRepository;
	
	public void setMarketplaceRepository(MarketplaceRepository marketplaceRepository) {
		this.marketplaceRepository = marketplaceRepository;		
	}

	public Optional<Marketplace> buscaInfoMarketplace(String codigo) {
		return marketplaceRepository.findById(codigo);
	}

}
