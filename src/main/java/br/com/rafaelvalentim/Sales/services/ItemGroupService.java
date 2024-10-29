package br.com.rafaelvalentim.Sales.services;

import br.com.rafaelvalentim.Sales.entities.ItemGroup;
import br.com.rafaelvalentim.Sales.repositories.ItemGroupRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemGroupService {
    private final ItemGroupRepository itemGroupRepository;

    public ItemGroupService(ItemGroupRepository itemGroupRepository) {
        this.itemGroupRepository = itemGroupRepository;
    }

    public ItemGroup createItemGroup(ItemGroup itemGroup) {
        return itemGroupRepository.save(itemGroup);
    }

    public List<ItemGroup> getAllItemGroups() {
        List<ItemGroup> itemGroups = new ArrayList<>();
        itemGroupRepository.findAll().forEach(itemGroups::add);
        return itemGroups;
    }
}
