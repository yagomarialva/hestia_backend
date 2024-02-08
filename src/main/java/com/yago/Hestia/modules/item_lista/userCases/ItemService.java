package com.yago.Hestia.modules.item_lista.userCases;
import com.yago.Hestia.modules.item_lista.dto.ItemDTO;
import com.yago.Hestia.modules.item_lista.entities.ItemEntity;

import com.yago.Hestia.modules.item_lista.repositories.ItemRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<ItemEntity> getAllItems() {
        return itemRepository.findAll();
    }

    public ItemEntity getItemById(UUID id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Item not found with id: " + id));
    }

    public ItemEntity createItem(ItemDTO itemDTO) {
        ItemEntity newItem = new ItemEntity();
        newItem.setName(itemDTO.getName());
        newItem.setQuantity(itemDTO.getQuantity());
        newItem.setPrice(itemDTO.getPrice());
        newItem.setType(itemDTO.getType());
        newItem.setDescription(itemDTO.getDescription());
        itemRepository.save(newItem);
        return newItem;
    }



    public ItemEntity updateItem(UUID id, ItemDTO itemDTO) {
        // Find existing item
        ItemEntity existingItem = getItemById(id);

        // Update fields
        BeanUtils.copyProperties(itemDTO, existingItem);

        // Additional validation or business logic can be added here

        return itemRepository.save(existingItem);
    }

    @Transactional
    public void deleteItem(UUID id) {
        itemRepository.deleteById(id);
    }
}

