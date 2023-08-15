package com.example.testtask.dao;

import com.example.testtask.models.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerDAO {
    private static long CUSTOMERS_COUNT;
    private List<Customer> customers;

    {
        customers = new ArrayList<>();

        customers.add(new Customer(++CUSTOMERS_COUNT,"Tom Jones",
                "alyosha.ksuhnir2004@gmail.com","+380672631560"));
        customers.add(new Customer(++CUSTOMERS_COUNT,"Alex Brains",
                "alyosha.asd@gmail.com","+380623631560"));
        customers.add(new Customer(++CUSTOMERS_COUNT,"Fenix Loyd",
                "asdsa.asd@gmail.com","+380323861560"));
    }

    public List<Customer> readAll(){
        return customers;
    }

    public Customer readById(long id){
        return customers.stream()
                .filter(customer -> customer.getId() == id)
                .findAny().orElse(null);
    }

    public void save(Customer customer){
        customer.setId(++CUSTOMERS_COUNT);
        customers.add(customer);
    }

    public void update(int id, Customer updatedCustomer){
        Customer customerToBeUpdated = readById(id);

        customerToBeUpdated.setFullName(updatedCustomer.getFullName());
        customerToBeUpdated.setEmail(updatedCustomer.getEmail());
        customerToBeUpdated.setPhone(updatedCustomer.getPhone());
    }

    public void delete(int id){
        customers.removeIf(p->p.getId()==id);
    }
}
