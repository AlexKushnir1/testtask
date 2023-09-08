package com.example.testtask.dao;

import com.example.testtask.models.Customer;
import com.example.testtask.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerDAO {
    private final CustomerRepo customerRepository;

    @Autowired
    public CustomerDAO(CustomerRepo customerRepo){
        this.customerRepository = customerRepo;
    }
//    private static long CUSTOMERS_COUNT;
//    private static final String URL = "jdbc:mysql://localhost:3306/testtask";
//    private static final String USERNAME = "root";
//    private static final String PASSWORD = "AlexRei22122001";


    public List<Customer> readAll(){
//        List<Customer> customers = new ArrayList<>();

//        try {
//            Statement statement = connection.createStatement();
//            String SQL = "SELECT * FROM customers";
//            ResultSet resultSet = statement.executeQuery(SQL);
//
//            while (resultSet.next()){
//                 Customer customer = new Customer();
//
//                 customer.setId(resultSet.getInt("id"));
//                 customer.setFullName(resultSet.getString("full_name"));
//                 customer.setEmail(resultSet.getString("email"));
//                 customer.setPhone(resultSet.getString("phone"));
//
//                 customers.add(customer);
//            }
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        return customerRepository.findAll();
    }

    public Customer readById(long id){
//        return customers.stream()
//                .filter(customer -> customer.getId() == id)
//                .findAny().orElse(null);
        return customerRepository.getOne(id);
    }

    public void save(Customer customer){
//        customer.setId(++CUSTOMERS_COUNT);
//        customers.add(customer);
        customerRepository.save(customer);
    }

    public void update(long id, Customer updatedCustomer){
        Customer customerToBeUpdated = customerRepository.getById(id);
//
        customerToBeUpdated.setId(id);
        customerToBeUpdated.setFullName(updatedCustomer.getFullName());
        customerToBeUpdated.setEmail(updatedCustomer.getEmail());
        customerToBeUpdated.setPhone(updatedCustomer.getPhone());
        customerRepository.deleteById(id);
        customerRepository.sa
        customerRepository.save(customerToBeUpdated);
    }

    public void delete(long id){
//        customers.removeIf(p->p.getId()==id);
        customerRepository.deleteById(id);
    }
}
