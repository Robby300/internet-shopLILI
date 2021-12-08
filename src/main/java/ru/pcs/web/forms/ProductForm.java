package ru.pcs.web.forms;

import lombok.Data;

@Data
public class ProductForm {
    private String description;
    private Double price;
    private Integer amount;
}
