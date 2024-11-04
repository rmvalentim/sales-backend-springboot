package br.com.rafaelvalentim.Sales.dtos;

import java.util.Date;
import java.util.List;

public class OrderCreateDto {

    private Date date;
    private Integer customerId;
    private List<OrderLineCreateDto> orderLines;

    public Date getDate() {
        return date;
    }

    public OrderCreateDto setDate(Date date) {
        this.date = date;
        return this;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public OrderCreateDto setCustomerId(Integer customerId) {
        this.customerId = customerId;
        return this;
    }

    public List<OrderLineCreateDto> getOrderLines() {
        return orderLines;
    }

    public OrderCreateDto setOrderLines(List<OrderLineCreateDto> orderLines) {
        this.orderLines = orderLines;
        return this;
    }
}
