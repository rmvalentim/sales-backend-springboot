package br.com.rafaelvalentim.Sales.controllers;

import br.com.rafaelvalentim.Sales.entities.ItemGroup;
import br.com.rafaelvalentim.Sales.services.ItemGroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/item-groups")
@RestController
public class ItemGroupController {

    private final ItemGroupService itemGroupService;

    public ItemGroupController(ItemGroupService itemGroupService) {
        this.itemGroupService = itemGroupService;
    }

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<ItemGroup>> allItemGroups() {
        List<ItemGroup> itemGroups = itemGroupService.getAllItemGroups();
        return ResponseEntity.ok(itemGroups);
    }

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ItemGroup> createItemGroup(@RequestBody ItemGroup itemGroup) {
        return ResponseEntity.ok(itemGroupService.createItemGroup(itemGroup));
    }
}
