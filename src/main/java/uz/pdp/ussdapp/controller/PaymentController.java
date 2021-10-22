package uz.pdp.ussdapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.ussdapp.payload.ApiResponse;
import uz.pdp.ussdapp.payload.PaymentDTO;
import uz.pdp.ussdapp.service.PaymentService;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;
    @PostMapping
    public HttpEntity<?> add(@RequestBody PaymentDTO paymentDTO){
        ApiResponse apiResponse = paymentService.add(paymentDTO);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);

    }
}
