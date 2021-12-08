package ru.pcs.web.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime createdDt = LocalDateTime.now();

//    @JsonIgnore
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, optional = false)
//    private Consumer consumer;

//    @ElementCollection
//    @Column(name = "amount", nullable = false)
//    @MapKeyJoinColumn(name = "item_id")
//    private Map<Product, Integer> products = new HashMap<>();
//
//    public Map<Product, Integer> getProduct() {
//        return Collections.unmodifiableMap(products);
//    }
//
//    public void addProduct(Product product) {
//        products.merge(product, 1, (v1, v2) -> v1 + v2);
//    }
//
//    public void removeProduct(Product product) {
//        products.computeIfPresent(product, (k, v) -> v > 1 ? v - 1 : null);
//    }
}
