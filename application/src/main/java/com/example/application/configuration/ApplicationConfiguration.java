package com.example.application.configuration;

import com.example.data.database.Database;
import com.example.data.database.JpaDatabase;
import com.example.data.repository.category.CategoryJpaRepository;
import com.example.data.repository.customer.CustomerJpaRepository;
import com.example.domain.input_boundary.category.get.all.GetAllCategoriesInputBoundary;
import com.example.domain.input_boundary.category.get.by_name.GetCategoryByNameInputBoundary;
import com.example.domain.input_boundary.customer.create.CreateNewCustomerInputBoundary;
import com.example.domain.input_boundary.customer.delete.DeleteCustomerInputBoundary;
import com.example.domain.input_boundary.customer.get.all.GetAllCustomersInputBoundary;
import com.example.domain.input_boundary.customer.get.by_id.GetCustomerInputBoundary;
import com.example.domain.input_boundary.customer.patch.PatchCustomerInputBoundary;
import com.example.domain.input_boundary.customer.update.UpdateCustomerInputBoundary;
import com.example.domain.output_boundary.category.get.all.GetAllCategoriesOutputBoundary;
import com.example.domain.output_boundary.category.get.by_name.GetCategoryByNameOutputBoundary;
import com.example.domain.output_boundary.customer.create.CustomerCreatedOutputBoundary;
import com.example.domain.output_boundary.customer.delete.DeleteCustomerOutputBoundary;
import com.example.domain.output_boundary.customer.get.all.GetAllCustomersOutputBoundary;
import com.example.domain.output_boundary.customer.get.by_id.GetCustomerOutputBoundary;
import com.example.domain.output_boundary.customer.patch.PatchCustomerOutputBoundary;
import com.example.domain.output_boundary.customer.update.UpdateCustomerOutputBoundary;
import com.example.domain.usecase.category.GetAllCategoriesUseCase;
import com.example.domain.usecase.category.GetCategoryByNameUseCase;
import com.example.domain.usecase.customer.*;
import com.example.presentation.presenter.category.GetAllCategoriesPresenter;
import com.example.presentation.presenter.category.GetCategoryByNamePresenter;
import com.example.presentation.presenter.customer.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.example.data")
@EnableJpaRepositories(basePackages = "com.example.data")
@ComponentScan({"com.example.data", "com.example.domain", "com.example.presentation"})
public class ApplicationConfiguration {
    @Bean
    public Database database(CategoryJpaRepository categoryJpaRepository,
                             CustomerJpaRepository customerJpaRepository) {
        return new JpaDatabase(categoryJpaRepository, customerJpaRepository);
    }

    @Bean
    public GetAllCategoriesInputBoundary getAllCategoriesInputBoundary(
            GetAllCategoriesOutputBoundary presenter, Database database) {
        return new GetAllCategoriesUseCase(presenter, database.categoryGateway());
    }

    @Bean
    public GetAllCategoriesOutputBoundary getAllCategoriesOutputBoundary() {
        return new GetAllCategoriesPresenter();
    }

    @Bean
    public GetCategoryByNameInputBoundary getCategoryByNameInputBoundary(
            GetCategoryByNameOutputBoundary presenter, Database database) {
        return new GetCategoryByNameUseCase(database.categoryGateway(), presenter);
    }

    @Bean
    public GetCategoryByNameOutputBoundary getCategoryByNameOutputBoundary() {
        return new GetCategoryByNamePresenter();
    }

    @Bean
    public CreateNewCustomerInputBoundary createNewCustomerInputBoundary(
            CustomerCreatedOutputBoundary presenter, Database database) {
        return new CreateNewCustomerUseCase(database.customerGateway(), presenter);
    }

    @Bean
    public CustomerCreatedOutputBoundary customerCreatedOutputBoundary() {
        return new CustomerCreatedPresenter();
    }

    @Bean
    public DeleteCustomerInputBoundary deleteCustomerInputBoundary(
            DeleteCustomerOutputBoundary presenter, Database database) {
        return new DeleteCustomerByIdUseCase(database.customerGateway(), presenter);
    }

    @Bean
    public DeleteCustomerOutputBoundary deleteCustomerOutputBoundary() {
        return new CustomerDeletedPresenter();
    }

    @Bean
    public GetAllCustomersInputBoundary getAllCustomersInputBoundary(
            GetAllCustomersOutputBoundary presenter, Database database) {
        return new GetAllCustomersUseCase(database.customerGateway(), presenter);
    }

    @Bean
    public GetAllCustomersOutputBoundary getAllCustomersOutputBoundary() {
        return new GetAllCustomersPresenter();
    }

    @Bean
    public GetCustomerInputBoundary getCustomerInputBoundary(
            GetCustomerOutputBoundary presenter, Database database) {
        return new GetCustomerByIdUseCase(database.customerGateway(), presenter);
    }

    @Bean
    public GetCustomerOutputBoundary getCustomerOutputBoundary() {
        return new GetCustomerPresenter();
    }

    @Bean
    public PatchCustomerInputBoundary patchCustomerInputBoundary(
            PatchCustomerOutputBoundary presenter, Database database) {
        return new PatchCustomerUseCase(database.customerGateway(), presenter);
    }

    @Bean
    public PatchCustomerOutputBoundary patchCustomerOutputBoundary() {
        return new CustomerPatchedPresenter();
    }

    @Bean
    public UpdateCustomerInputBoundary updateCustomerInputBoundary(
            UpdateCustomerOutputBoundary presenter, Database database) {
        return new UpdateCustomerUseCase(database.customerGateway(), presenter);
    }

    @Bean
    public UpdateCustomerOutputBoundary updateCustomerOutputBoundary() {
        return new CustomerUpdatedPresenter();
    }
}
