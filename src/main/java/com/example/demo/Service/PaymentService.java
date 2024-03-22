package com.example.demo.Service;

import com.example.demo.exception.PaymentNotFoundException;
import com.example.demo.model.Payment;
import com.example.demo.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class PaymentService {
    private  final PaymentRepo paymentRepo;
    @Autowired
    public PaymentService(PaymentRepo paymentRepo) {
        this.paymentRepo = paymentRepo;
    }
    public Payment addPayment(Payment payment) {
        return paymentRepo.save(payment);
    }
    public  Payment findPaymentById(Long id){
        return paymentRepo.findPaymentById(id)
                .orElseThrow(()-> new PaymentNotFoundException("Payment of" + id + "Not found"));
    }

}
