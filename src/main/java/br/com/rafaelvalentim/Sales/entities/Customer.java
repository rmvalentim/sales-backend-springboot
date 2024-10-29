package br.com.rafaelvalentim.Sales.entities;

import jakarta.persistence.*;

@Table(name="customers")
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String document;

    public Integer getId() {
        return id;
    }

    public Customer setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Customer setName(String name) {
        this.name = name;
        return this;
    }

    public String getDocument() {
        return document;
    }

    public Customer setDocument(String document) {
        this.document = document;
        return this;
    }
}
