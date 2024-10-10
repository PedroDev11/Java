package org.example.payment;

import org.junit.Test;
import org.mockito.Mockito;

import static org.example.payment.PaymentResponse.PaymentStatus.*;
import static org.junit.Assert.*;

public class PaymentProcessorTest {

    @Test
    public void payment_correct() {
        PaymentGateway gateway = Mockito.mock(PaymentGateway.class);

        // Cuando al PaymentGateway se le haga un request de cualquier payment (any()) el va a devolver una respuesta correcta
        Mockito.when(gateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(OK));

        PaymentProcessor processor = new PaymentProcessor(gateway);

        assertTrue(processor.makePayment(1000));
    }

    @Test
    public void payment_wrong() {
        PaymentGateway gateway = Mockito.mock(PaymentGateway.class);

        // Cuando al PaymentGateway se le haga un request de cualquier payment (any()) el va a devolver una respuesta correcta
        Mockito.when(gateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(ERROR));

        PaymentProcessor processor = new PaymentProcessor(gateway);

        assertFalse(processor.makePayment(1000));
    }
}