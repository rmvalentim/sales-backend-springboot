package br.com.rafaelvalentim.Sales.dtos;

import java.math.BigDecimal;

public class OrderLineCreateDto {

    private Integer itemId;
    private BigDecimal price;

    public Integer getItemId() {
        return itemId;
    }

    public OrderLineCreateDto setItemId(Integer itemId) {
        this.itemId = itemId;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderLineCreateDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
