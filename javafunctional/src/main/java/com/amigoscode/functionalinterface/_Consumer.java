package com.amigoscode.functionalinterface;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello ".concat(customer.name)
                                       .concat(", thanks for registering phone number ")
                                       .concat(customer.phoneNumber));
    static BiConsumer<Customer, Boolean> greetCustomerConsumerBiConsumer = (customer, showPhoneNumber) ->
            System.out.println("Hello ".concat(customer.name)
                                       .concat(", thanks for registering phone number ")
                                       .concat(showPhoneNumber ? customer.phoneNumber : "********"));

    public static void main(String[] args) {
        Customer maria = new Customer("Maria", "99999");
        greetCustomer(maria);

        greetCustomerConsumer.accept(maria);

        greetCustomerConsumerBiConsumer.accept(maria, false);
    }

    static void greetCustomer(Customer customer) {
        System.out.println("Hello ".concat(customer.name)
                                   .concat(", thanks for registering phone number ")
                                   .concat(customer.phoneNumber));
    }

    @Data
    @AllArgsConstructor
    static class Customer {
        private final String name;
        private final String phoneNumber;
    }
}
