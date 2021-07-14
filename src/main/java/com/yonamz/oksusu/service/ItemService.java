package com.yonamz.oksusu.service;

import com.yonamz.oksusu.controller.ItemForm;
import com.yonamz.oksusu.domain.Item;
import com.yonamz.oksusu.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Transactional
    public Long create(ItemForm itemForm){
        return itemRepository.save(itemForm.toEntity()).getItem_no();
    }

    @Transactional
    public List<ItemForm> getItemList(){
        List<Item> items = itemRepository.findAll();
        List<ItemForm> itemForms = new ArrayList<>();

        for(Item item : items){
            ItemForm itemForm = ItemForm.builder()
                    .item_no(item.getItem_no())
                    .title(item.getTitle())
                    .content(item.getContent())
                    .writer(item.getWriter())
                    .deadline(item.getDeadline())
                    .starting_bid(item.getStarting_bid())
                    .createdDate(item.getCreatedDate())
                    .build();

            itemForms.add(itemForm);
        }
        return itemForms;
    }

    @Transactional
    public ItemForm getPost(Long item_no){
        Optional<Item> itemWrapper = itemRepository.findById(item_no);
        Item item = itemWrapper.get();

        ItemForm itemForm = ItemForm.builder()
                .item_no(item.getItem_no())
                .title(item.getTitle())
                .writer(item.getWriter())
                .content(item.getContent())
                .deadline(item.getDeadline())
                .starting_bid(item.getStarting_bid())
                .build();
        return itemForm;
    }

    @Transactional
    public void deletePost(Long item_no){
        itemRepository.deleteById(item_no);
    }


}
