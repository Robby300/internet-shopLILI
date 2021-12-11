package ru.pcs.web.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.pcs.web.models.Order;

public interface OrdersRepository extends JpaRepository<Order, Integer> {
}
