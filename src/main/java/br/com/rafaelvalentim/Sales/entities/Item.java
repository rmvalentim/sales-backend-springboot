package br.com.rafaelvalentim.Sales.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Table(name="items")
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="group_id", referencedColumnName = "id", nullable = false)
    private ItemGroup itemGroup;

    public Integer getId() {
        return id;
    }

    public Item setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Item setCode(String code) {
        this.code = code;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Item setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Item setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public ItemGroup getItemGroup() {
        return itemGroup;
    }

    public Item setItemGroup(ItemGroup itemGroup) {
        this.itemGroup = itemGroup;
        return this;
    }
}
