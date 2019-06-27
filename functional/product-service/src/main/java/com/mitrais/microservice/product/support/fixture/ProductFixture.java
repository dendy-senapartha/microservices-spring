package com.mitrais.microservice.product.support.fixture;

import java.math.BigDecimal;

import com.mitrais.microservice.product.domain.Product;
import com.mitrais.microservice.product.repository.ProductRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 *
 */
@Configuration
@Profile("fixture")
@RequiredArgsConstructor
public class ProductFixture implements CommandLineRunner {
	private final ProductRepository productRepository;

	/**
	 * Insert product sample data.
	 * @param args not used
	 */
	@Override
	public void run(String... args) {
		for (ProductFixtureEnum pfe : ProductFixtureEnum.values()) {
			Product product = Product.builder()
					.name(pfe.getName())
					.number(pfe.getNumber())
					.price(pfe.getPrice())
					.build();
			productRepository.save(product);
		}
	}

	/**
	 * Product sample data.
	 */
	@Getter
	@RequiredArgsConstructor
	public enum ProductFixtureEnum {
		FOOD("Milk", "101", BigDecimal.valueOf(2)),
		SHIRT("Polo", "201", BigDecimal.valueOf(40)),
		JEWELRY("Diamond", "301", BigDecimal.valueOf(200)),
		SHOE("Boot", "202", BigDecimal.valueOf(70));
		private final String name;
		private final String number;
		private final BigDecimal price;
	}
}
