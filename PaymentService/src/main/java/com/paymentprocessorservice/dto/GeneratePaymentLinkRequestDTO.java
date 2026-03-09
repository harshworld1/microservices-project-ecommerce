package com.paymentservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneratePaymentLinkRequestDTO {
    private Long orderId;
    private PaymentGatewayProvider paymentGatewayProvider;
}
