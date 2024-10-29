package br.com.rafaelvalentim.Sales.entities;


import jakarta.persistence.*;

@Table(name="item_groups")
@Entity
public class ItemGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String description;

    public Integer getId() {
        return id;
    }

    public ItemGroup setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemGroup setDescription(String description) {
        this.description = description;
        return this;
    }
}
