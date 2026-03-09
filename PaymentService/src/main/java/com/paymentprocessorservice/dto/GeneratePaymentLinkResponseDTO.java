package com.paymentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GeneratePaymentLinkResponseDTO {
    private Long orderId;
    private String paymentLink;
}
