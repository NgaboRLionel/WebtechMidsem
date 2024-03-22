package com.example.demo.controller;

import com.example.demo.Service.PaymentService;
import com.example.demo.model.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;

    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.findPaymentById(id);
        return new ResponseEntity<>(payment, HttpStatus.OK);

    }
    @PostMapping("/add")
    public ResponseEntity<Payment> addPayment(@RequestBody Payment payment){
        Payment payment1 = paymentService.addPayment(payment);
        return new ResponseEntity<>(payment1, HttpStatus.CREATED);
    }
}
