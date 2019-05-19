package ru.sinys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.sinys.dao.ItemDao;
import ru.sinys.model.Item;
import ru.sinys.model.Service.ItemService;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class ItemsController {

    @Autowired
    private ItemService itemService;

    @GetMapping("itemsList")
    public String ViewAll(Model model) {
        Iterable<Item> items = itemService.getAllItem();
        model.addAttribute("items", items);
        model.addAttribute("item", new Item());
        return "itemsList";
    }

    @GetMapping("item/delete")
    public String delItem(@RequestParam String article) {
        itemService.deleteItem(article);
        return "redirect:/itemsList";
    }

    @PostMapping("/itemsList")
    public String addItem(@ModelAttribute ("item") @Valid Item item, BindingResult bindingResult, Model model){
        Map<String, Object> errors = new HashMap<>();
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors().forEach(fieldError -> errors.put(fieldError.getField() + "Error",
                    fieldError.getDefaultMessage()));
            model.addAttribute("errors", errors);
            return "redirect:itemsList";
        }
            model.addAttribute("errors", errors);
            itemService.addItem(item);
        return "redirect:itemsList";
    }
}
