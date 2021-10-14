package com.assignment.movies.controllers;

import com.assignment.movies.entities.Order;
import com.assignment.movies.services.PayPalService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller("payment")
@RequestMapping("/payment")
public class PayPalController {

    @Autowired
    PayPalService paypalService;

    public static final String SUCCESS_URL = "/success";
    public static final String CANCEL_URL = "/cancel";

    //the url which leads to the payform of the site
    @GetMapping("/{sellPrice}")
    public String home(@PathVariable("sellPrice") double sellPrice,Model model) {
        Order order = new Order();
        model.addAttribute("order",order);
        model.addAttribute("sellPrice",sellPrice);
        return "payform";
    }

    //when the users make the choice to pay for the movie it leads him here where in this case the phantom page will take place
    //he will go the paypall site to put his email and password and if he is successful since it is a fake account he always he will go 
    //to the SUCCESS_RL but if he wants to cancel he will go the CANCEL_URL
    @PostMapping("/form")
    public String payment(@ModelAttribute("order") Order order) {
        try {
            Payment payment = paypalService.createPayment(order.getPrice(), order.getCurrency(), order.getMethod(),
                    order.getIntent(), order.getDescription(), "http://localhost:8080/payment" + CANCEL_URL,
                    "http://localhost:8080/payment" + SUCCESS_URL);
            for (Links link : payment.getLinks()) {
                if (link.getRel().equals("approval_url")) {
                    return "redirect:" + link.getHref();
                }
            }

        } catch (PayPalRESTException e) {

            e.printStackTrace();
        }
        return "redirect:/";
    }

    //The method that leads to the view if the payment is cancelled
    @GetMapping(value = CANCEL_URL)
    public String cancelPay() {
        return "cancel";
    }

    //And the url which leads to the view if the payment was successful
    @GetMapping(value = SUCCESS_URL)
    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
        try {
            Payment payment = paypalService.executePayment(paymentId, payerId);
            System.out.println(payment.toJSON());
            if (payment.getState().equals("approved")) {
                return "success";
            }
        } catch (PayPalRESTException e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/";
    }

}
