package com.yago.Hestia.modules.item_lista.repositories;

import com.yago.Hestia.modules.item_lista.entities.ItemEntity;


import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
    Optional<ItemEntity> findById(UUID id);

//    @Modifying
//    @Query("UPDATE ItemEntity i SET i.name = :name, i.quantity = :quantity, i.price = :price, i.type = :type, i.description = :description WHERE i.id = :id")
//    void updateItem(
//            @Param("id") UUID id,
//            @Param("name") String name,
//            @Param("quantity") Long quantity,
//            @Param("price") Long price,
//            @Param("type") String type,
//            @Param("description") String description
//    );

    @Modifying
    @Query("DELETE FROM ItemEntity i WHERE i.id = :id")
    void deleteById(@Param("id") UUID id);
}
