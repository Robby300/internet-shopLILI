package ru.pcs.web.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Order(List<Product> products) {
        this.products = products;
    }

    @OneToMany(mappedBy = "product")
    private List<Product> products;

//
//    @Column(name="created_dt")
//    private LocalDateTime createdDt = LocalDateTime.now();

//    @ManyToOne
//    @JoinColumn(name ="user_id")
//    private User user;

//    @ElementCollection
//    @Column(name = "quantity", nullable = false)
//    @MapKeyJoinColumn(name = "product_id")
//    private Map<Product, Integer> products = new HashMap<>();


//    public Map<Product, Integer> getProduct() {
//        return Collections.unmodifiableMap(products);
//    }
//
    public void addProduct(Product product) {
        products.add(product);
    }
//
//    public void deleteProduct(Product product) {
//        products.computeIfPresent(product, (k, v) -> v > 1 ? v - 1 : null);
//    }
//
//

    public void setId(Integer id) {
        this.id = id;
    }

//    public void setCreatedDt(LocalDateTime createdDt) {
//        this.createdDt = createdDt;
//    }

//    public void setUser(User user) {
//        this.user = user;
//    }

    public Integer getId() {
        return id;
    }

//    public LocalDateTime getCreatedDt() {
//        return createdDt;
//    }

//    public User getUser() {
//        return user;
//    }

}
