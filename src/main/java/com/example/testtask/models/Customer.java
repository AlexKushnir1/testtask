package com.example.testtask.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "Full name should not be empty ")
    @Size(min = 2, max = 50, message = "Full name should include from 2 to 50 characters")

    private String fullName;
    @NotEmpty(message = "Email should not be empty ")
    @Size(min = 1, max = 100, message = "Email should include from 2 to 50 characters")
    @Email(message = "Email should be valid")
//    @UniqueElements(message = "This email was used before")
    private String email;
    @Pattern(regexp = "(\\+380|0)[0-9]{9}", message = "Phone must start with 0 or +38 and contain only digits")
    private String phone;
}
