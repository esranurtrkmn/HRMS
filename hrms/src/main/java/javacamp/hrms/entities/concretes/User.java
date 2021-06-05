package javacamp.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


@Data
@Entity
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotEmpty
    @NotBlank(message = "Email cannot be empty!")
    @Column(name = "email") 
    private String email;

    @NotEmpty
    @NotBlank(message = "Password cannot be empty!")
    @Column(name = "password")
    private String password;
}
