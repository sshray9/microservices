package com.sshray9;

import com.sshray9.model.Inventory;
import com.sshray9.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplicationMain.class, args);
    }

    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository){
        return args -> {
            Inventory inventory = new Inventory();
            inventory.setSkuCode("iphone 13");
            inventory.setQuantity("50");

            Inventory inventory1 = new Inventory();
            inventory1.setSkuCode("iphone 13 Red");
            inventory1.setQuantity("0");

            inventoryRepository.save(inventory);
            inventoryRepository.save(inventory1);
        };
    }
}
