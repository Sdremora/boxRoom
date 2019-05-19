package ru.sinys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.sinys.dao.ItemDao;
import ru.sinys.model.Item;

import javax.validation.Valid;

@Controller
public class OrdersController {

    @GetMapping("ordersList")
    public String ViewAll(Model model) {
        return "ordersList";
    }

}
