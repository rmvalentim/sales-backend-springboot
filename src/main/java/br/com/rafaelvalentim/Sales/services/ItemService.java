package br.com.rafaelvalentim.Sales.services;

import br.com.rafaelvalentim.Sales.dtos.ItemCreateDto;
import br.com.rafaelvalentim.Sales.entities.Item;
import br.com.rafaelvalentim.Sales.entities.ItemGroup;
import br.com.rafaelvalentim.Sales.repositories.ItemGroupRepository;
import br.com.rafaelvalentim.Sales.repositories.ItemRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private final ItemRepository itemRepository;
    private final ItemGroupRepository itemGroupRepository;

    public ItemService(ItemRepository itemRepository, ItemGroupRepository itemGroupRepository) {
        this.itemRepository = itemRepository;
        this.itemGroupRepository = itemGroupRepository;
    }

    public Item createItem(ItemCreateDto itemDto)  {
        ItemGroup itemGroup = itemGroupRepository.findById(itemDto.getItemGroup())
                .orElseThrow(() -> new EntityNotFoundException("ItemGroup not found with id " + itemDto.getItemGroup()));

        Item item = new Item()
                .setCode(itemDto.getCode())
                .setDescription(itemDto.getDescription())
                .setPrice(itemDto.getPrice())
                .setItemGroup(itemGroup);

        return itemRepository.save(item);
    }
}