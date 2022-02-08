package com.mockitotutorial.happyhotel.booking;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class Test13StrictStubbing {

    @InjectMocks
    private BookingService bookingService;

    @Mock
    private PaymentService paymentServiceMock;

    @Mock
    private RoomService roomServiceMock;

    @Mock
    private BookingDAO bookingDAOMock;

    @Mock
    private MailSender mailSenderMock;

    @Captor
    private ArgumentCaptor<Double> doubleCaptor;

    @Test
    void should_Invoke_Pay_ifPrepaid() {
        // given
        BookingRequest bookingRequest = new BookingRequest("1",
                LocalDate.of(2022, 1, 1),
                LocalDate.of(2022, 1, 5),
                2, false);
        lenient().when(paymentServiceMock.pay(any(), anyDouble())).thenReturn("1");
//        when(paymentServiceMock.pay(any(), anyDouble())).thenReturn("1");
        // when
        bookingService.makeBooking(bookingRequest);

        // then
        // should throw exception
    }
}
