package br.com.rafaelvalentim.Sales.controllers;

import br.com.rafaelvalentim.Sales.dtos.ItemCreateDto;
import br.com.rafaelvalentim.Sales.entities.Item;
import br.com.rafaelvalentim.Sales.services.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/items")
@RestController
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<Item>> allItems() {
        List<Item> items = itemService.getAllItems();
        return ResponseEntity.ok(items);
    }

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Item> createItem(@RequestBody ItemCreateDto itemCreateDto) {
        return ResponseEntity.ok(itemService.createItem(itemCreateDto));
    }
}
