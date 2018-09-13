package br.com.markethub.resource;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.markethub.domain.Marketplace;
import br.com.markethub.service.MarketplaceService;

@RestController
@RequestMapping("/api/marketplace")
public class MarketplaceResource {

	private MarketplaceService marketplaceService;

	@Autowired
	public void setMarketplaceService(MarketplaceService marketplaceService) {
		this.marketplaceService = marketplaceService;
	}

	private static final Logger log = LoggerFactory.getLogger(MarketplaceResource.class);

	@GetMapping("/{codigo}")
	public ResponseEntity<Marketplace> buscaInfoMarketplace(@PathVariable(required = true) String codigo) {
		log.info("Acesso em markeplace/markethub-id/{nome}");
		try {
			Optional<Marketplace> id = marketplaceService.buscaInfoMarketplace(codigo);
			if (id.isPresent()) {
				return ResponseEntity.ok(id.get());
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception ex) {
			log.error("Erro ao buscar codigo do markethub no sistema " + codigo, ex);
			return ResponseEntity.status(500).build();
		}
	}

}