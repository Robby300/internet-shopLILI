package ru.pcs.web.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="account")
public class User implements Serializable {

    public enum Role {
        ADMIN, USER
    }

    public enum State {
        NOT_CONFIRMED, CONFIRMED
    }

    @Enumerated(value = EnumType.STRING)
    private State state;

    public State getState() {
        return state;
    }

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Id
//    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Column(name="first_name")
    private String firstName;

//    @Column(name="last_name")
    private String lastName;

    @Column(unique = true)
    private String email;


    private String hashPassword;

    public Role getRole() {
        return role;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public void setState(State state) {
        this.state = state;
    }

//    @OneToMany(mappedBy = "user")
//    private List<Order> orders;
}

