package br.com.rafaelvalentim.Sales.dtos;

import br.com.rafaelvalentim.Sales.entities.ItemGroup;

import java.math.BigDecimal;

public class ItemCreateDto {
    private String code;
    private String description;
    private BigDecimal price;
    private Integer itemGroup;

    public String getCode() {
        return code;
    }

    public ItemCreateDto setCode(String code) {
        this.code = code;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemCreateDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ItemCreateDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Integer getItemGroup() {
        return itemGroup;
    }

    public ItemCreateDto setItemGroup(Integer itemGroup) {
        this.itemGroup = itemGroup;
        return this;
    }
}
