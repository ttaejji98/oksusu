package com.yonamz.oksusu.controller;

import com.yonamz.oksusu.service.ItemService;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(value="/items/new")
    public String registerForm(){
        return "items/registerItemForm";
    }

    @PostMapping(value = "/items/new")
    public String register(ItemForm itemForm){
        itemService.create(itemForm);
        return "redirect:/";
    }

    @GetMapping("/items")
    public String list(Long item_no, Model model){
        List<ItemForm> items = itemService.getItemList();
        model.addAttribute("items", items);
        model.addAttribute("view", itemService.updateCount(item_no));

        return "items/itemsList";
    }

    @GetMapping("/items/{item_no}")
    public String detail(@PathVariable("item_no") Long item_no, Model model){
        ItemForm itemForm = itemService.getPost(item_no);

        model.addAttribute("itemForm",itemForm);
        return "items/detail";
    }

    @GetMapping("/items/edit/{item_no}")
    public String edit(@PathVariable("item_no") Long item_no, Model model){
        ItemForm itemForm = itemService.getPost(item_no);

        model.addAttribute("itemForm",itemForm);
        return "items/update";
    }

    @PutMapping("/items/edit/{item_no}")
    public String update(ItemForm itemForm){
        itemService.create(itemForm);
        return "redirect:/";
    }

    @DeleteMapping("/items/{item_no}")
    public String delete(@PathVariable("item_no") Long item_no){
        itemService.deletePost(item_no);
        return "redirect:/";
    }



}
