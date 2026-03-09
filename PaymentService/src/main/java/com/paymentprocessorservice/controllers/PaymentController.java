package com.paymentservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paymentservice.dto.APIResponse;
import com.paymentservice.dto.APIResponseFailure;
import com.paymentservice.dto.APIResponseSuccess;
import com.paymentservice.dto.GeneratePaymentLinkRequestDTO;
import com.paymentservice.dto.GeneratePaymentLinkResponseDTO;
import com.paymentservice.exceptions.InvalidPaymentGatewayException;
import com.paymentservice.exceptions.PaymentLinkGenerationException;
import com.paymentservice.services.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

   @PostMapping("/generatePaymentLink")
    public ResponseEntity<APIResponse> createPaymentLink(@RequestBody GeneratePaymentLinkRequestDTO request) {
        APIResponse apiResponse;
        HttpStatus status = HttpStatus.CREATED;
        try {
            String link = paymentService.createPaymentLink(request.getOrderId(), request.getPaymentGatewayProvider());
            apiResponse = new APIResponseSuccess<>(new GeneratePaymentLinkResponseDTO(request.getOrderId(), link));
        } catch (PaymentLinkGenerationException | InvalidPaymentGatewayException ex) {
            apiResponse = new APIResponseFailure(ex);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return ResponseEntity.status(status).body(apiResponse);
    }
}
