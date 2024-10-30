package br.com.rafaelvalentim.Sales.dtos;

public class CustomerCreateDto {
    private String name;
    private String document;

    public String getName() {
        return name;
    }

    public CustomerCreateDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getDocument() {
        return document;
    }

    public CustomerCreateDto setDocument(String document) {
        this.document = document;
        return this;
    }
}
