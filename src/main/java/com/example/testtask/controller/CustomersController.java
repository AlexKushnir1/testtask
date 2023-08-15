package com.example.testtask.controller;

import com.example.testtask.dao.CustomerDAO;
import com.example.testtask.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomersController {

    private final CustomerDAO customerDAO;

    @Autowired
    public CustomersController(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @GetMapping()
    public String readAll(Model model) {
        // отримаємо всіх людей з DAO і передамо в View
        model.addAttribute("customers", customerDAO.readAll());
        return "customers/readAll";
    }

    @GetMapping("/{id}")
    public String readById(@PathVariable("id") int id, Model model) {
        // Отримаємо одну людину по його id з DAO і передамо у VIEW
        model.addAttribute("customer", customerDAO.readById(id));
        return "customers/readById";
    }

    @GetMapping("/new")
    public String newCustomer(@ModelAttribute("customer") Customer customer) {
        return "customers/new";
    }
    @PostMapping
    public String create(@ModelAttribute("customer") Customer customer) {
        customerDAO.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("customer", customerDAO.readById(id));
        return "customers/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("customer") Customer customer, @PathVariable("id") int id){
        customerDAO.update(id, customer);
        return "redirect:/customers";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
    customerDAO.delete(id);
    return "redirect:/customers";
    }


}
