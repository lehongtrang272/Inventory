package com.lehongtrang.inventory.inventory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.lehongtrang.inventory.inventory.domain.Category;
import com.lehongtrang.inventory.inventory.domain.CategoryRepository;
import com.lehongtrang.inventory.inventory.domain.Item;
import com.lehongtrang.inventory.inventory.domain.ItemRepository;

@SpringBootApplication
public class InventoryApplication {
	private static final Logger log = LoggerFactory.getLogger(InventoryApplication.class);
	
	public static void main(String[] args) {
	
		SpringApplication.run(InventoryApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoInventoryData(ItemRepository irepository, CategoryRepository crepository) {

		return (arg) -> {
			crepository.save(new Category("Desk"));
			crepository.save(new Category("Chair"));
			crepository.save(new Category("Lamp"));

			irepository.save(new Item("American Style C", 20, 32.45, crepository.findByName("Chair").get(0)));
			irepository.save(new Item("American Style D", 20, 52.45, crepository.findByName("Desk").get(0)));
			irepository.save(new Item("Scandic Style C", 20, 109.45, crepository.findByName("Chair").get(0)));
			irepository.save(new Item("Scandic Style D", 10, 150.45, crepository.findByName("Chair").get(0)));
			irepository.save(new Item("Asian Style C", 10, 50.45, crepository.findByName("Chair").get(0)));

			log.info("fetch all books");

			for (Item item : irepository.findAll()) {
				log.info(item.toString());

			}

		};

	}
}
