package com.paymentservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymentservice.dto.OrderDTO;
import com.paymentservice.dto.PaymentGatewayProvider;
import com.paymentservice.exceptions.InvalidPaymentGatewayException;
import com.paymentservice.exceptions.PaymentLinkGenerationException;
import com.paymentservice.paymentgateway.PaymentGateway;
import com.paymentservice.utility.PaymentGatewaySelectorStrategy;

@Service
public class PaymentService {

    private final PaymentGatewaySelectorStrategy gatewaySelector;

    @Autowired
    private OrderService orderService;

    public PaymentService(PaymentGatewaySelectorStrategy gatewaySelector) {
        this.gatewaySelector = gatewaySelector;
    }

    public String createPaymentLink(Long orderId, PaymentGatewayProvider vendor) throws PaymentLinkGenerationException, InvalidPaymentGatewayException {
        PaymentGateway gateway = gatewaySelector.getPaymentGateway(vendor);
        OrderDTO order = orderService.getOrderById(orderId);
        return gateway.generatePaymentLink(order);
    }
}
