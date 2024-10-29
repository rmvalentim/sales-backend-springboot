package br.com.rafaelvalentim.Sales.dtos;

public class ItemGroupCreateDto {

    private String description;

    public String getDescription() {
        return description;
    }

    public ItemGroupCreateDto setDescription(String description) {
        this.description = description;
        return this;
    }
}
