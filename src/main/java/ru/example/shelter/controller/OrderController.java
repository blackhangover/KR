package ru.example.shelter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.example.shelter.model.User;
import ru.example.shelter.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{id}")
    public String order(@AuthenticationPrincipal User user, @PathVariable("id") Long animalId) { //????? ??????? ????????? ?????? ?? ????????, ????????? ???? ?????
        orderService.order(user.getId(), animalId);
        return "order/complete";
    }

    @GetMapping("/complete/{id}")
    public String complete(@PathVariable Long id) { //??? ????, ??? ?? ???????? ?????? ??? ???????????
        orderService.completeOrder(id);
        return "redirect:/order/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) { //??? ???????? ??????
        orderService.delete(id);
        return "redirect:/order/list";
    }

    @GetMapping("/list")
    public String list(Model model) { //?????????? ????????????? ?? ??????? ??????
        model.addAttribute("orders", orderService.getOrders());
        return "order/list";
    }

}
