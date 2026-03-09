package com.paymentservice.paymentgateway;

import com.paymentservice.dto.OrderDTO;
import com.paymentservice.exceptions.PaymentLinkGenerationException;

public interface PaymentGateway {
    String generatePaymentLink(OrderDTO orderDTO) throws PaymentLinkGenerationException;
}
