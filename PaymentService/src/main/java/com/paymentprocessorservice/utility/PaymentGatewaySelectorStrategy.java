package com.paymentservice.utility;

import org.springframework.stereotype.Component;

import com.paymentservice.dto.PaymentGatewayProvider;
import com.paymentservice.exceptions.InvalidPaymentGatewayException;
import com.paymentservice.paymentgateway.PaymentGateway;
import com.paymentservice.paymentgateway.RazorpayPaymentGateway;
import com.paymentservice.paymentgateway.StripePaymentGateway;

@Component
public class PaymentGatewaySelectorStrategy {
    private final RazorpayPaymentGateway razorpayPaymentGateway;
    private final StripePaymentGateway stripePaymentGateway;

    public PaymentGatewaySelectorStrategy(RazorpayPaymentGateway razorpayPaymentGateway, StripePaymentGateway stripePaymentGateway) {
        this.razorpayPaymentGateway = razorpayPaymentGateway;
        this.stripePaymentGateway = stripePaymentGateway;
    }

    public PaymentGateway getPaymentGateway(PaymentGatewayProvider paymentGatewayProvider) throws InvalidPaymentGatewayException {
        if (paymentGatewayProvider == PaymentGatewayProvider.RAZORPAY) {
            return razorpayPaymentGateway;
        } else if (paymentGatewayProvider == PaymentGatewayProvider.STRIPE) {
            return stripePaymentGateway;
        }
        throw new InvalidPaymentGatewayException("Error in providing payment gateway object of type : "+ paymentGatewayProvider);
    }
}
