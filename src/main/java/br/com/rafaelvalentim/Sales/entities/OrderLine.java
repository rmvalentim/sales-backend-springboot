package br.com.rafaelvalentim.Sales.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Table(name="order_lines")
@Entity
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false)
    private Order order;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="item_id", referencedColumnName = "id", nullable = false)
    private Item item;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    public Integer getId() {
        return id;
    }

    public OrderLine setId(Integer id) {
        this.id = id;
        return this;
    }

    public Order getOrder() {
        return order;
    }

    public OrderLine setOrder(Order order) {
        this.order = order;
        return this;
    }

    public Item getItem() {
        return item;
    }

    public OrderLine setItem(Item item) {
        this.item = item;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OrderLine setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderLine setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
