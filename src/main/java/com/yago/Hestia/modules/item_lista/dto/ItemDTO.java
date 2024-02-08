package com.yago.Hestia.modules.item_lista.dto;

import lombok.Data;

@Data
public class ItemDTO {
    private String name;
    private Long quantity;
    private Long price;
    private String type;
    private String description;

}
