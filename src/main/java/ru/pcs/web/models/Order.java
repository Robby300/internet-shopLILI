package ru.pcs.web.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="\"order\"")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /*public Order(List<Product> products) {
        this.products = products;
    }*/

    @ManyToMany
    @JoinTable(
            name = "order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


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

    public void addProduct(Product product) {
        products.add(product);
    }

//    public LocalDateTime getCreatedDt() {
//        return createdDt;
//    }

//    public User getUser() {
//        return user;
//    }

}
