package ru.pcs.web.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    private String hashPassword;



}

