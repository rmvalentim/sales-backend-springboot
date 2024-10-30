package br.com.rafaelvalentim.Sales.controllers;

import br.com.rafaelvalentim.Sales.dtos.ItemCreateDto;
import br.com.rafaelvalentim.Sales.entities.Item;
import br.com.rafaelvalentim.Sales.services.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/item")
@RestController
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Item> createItem(@RequestBody ItemCreateDto itemCreateDto) {
        return ResponseEntity.ok(itemService.createItem(itemCreateDto));
    }
}
