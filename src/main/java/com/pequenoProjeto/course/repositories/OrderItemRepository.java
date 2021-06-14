package com.pequenoProjeto.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pequenoProjeto.course.entities.OrderItem;

@Repository //-> anotation que indica essa classe como repository. No caso do repository, a anotation é opcional.
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
