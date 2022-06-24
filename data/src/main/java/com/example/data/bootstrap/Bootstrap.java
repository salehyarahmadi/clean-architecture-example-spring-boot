package com.example.data.bootstrap;

import com.example.data.repository.category.CategoryJpaRepository;
import com.example.data.repository.customer.CustomerJpaRepository;
import com.example.data.model.category.CategoryDB;
import com.example.data.model.customer.CustomerDB;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {
    private final CategoryJpaRepository categoryJpaRepository;
    private final CustomerJpaRepository customerJpaRepository;

    public Bootstrap(
            CategoryJpaRepository categoryJpaRepository,
            CustomerJpaRepository customerJpaRepository
    ) {
        this.categoryJpaRepository = categoryJpaRepository;
        this.customerJpaRepository = customerJpaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCategories();
        loadCustomers();
    }

    private void loadCategories() {
        CategoryDB fruits = new CategoryDB();
        fruits.setName("Fruits");

        CategoryDB dried = new CategoryDB();
        dried.setName("Dried");

        CategoryDB fresh = new CategoryDB();
        fresh.setName("Fresh");

        CategoryDB exotic = new CategoryDB();
        exotic.setName("Exotic");

        CategoryDB nuts = new CategoryDB();
        nuts.setName("Nuts");

        categoryJpaRepository.save(fruits);
        categoryJpaRepository.save(dried);
        categoryJpaRepository.save(fresh);
        categoryJpaRepository.save(exotic);
        categoryJpaRepository.save(nuts);

        System.out.println("Categories Loaded: " + categoryJpaRepository.count());
    }

    private void loadCustomers() {
        CustomerDB customer1 = new CustomerDB();
        customer1.setId(1L);
        customer1.setFirstName("Michale");
        customer1.setLastName("Weston");
        customerJpaRepository.save(customer1);

        CustomerDB customer2 = new CustomerDB();
        customer2.setId(2L);
        customer2.setFirstName("Sam");
        customer2.setLastName("Axe");

        customerJpaRepository.save(customer2);

        System.out.println("Customers Loaded: " + customerJpaRepository.count());
    }
}
