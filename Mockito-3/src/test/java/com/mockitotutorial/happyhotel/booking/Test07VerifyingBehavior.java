package com.mockitotutorial.happyhotel.booking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.*;

public class Test07VerifyingBehavior {
    private BookingService bookingService;
    private PaymentService paymentServiceMock;
    private RoomService roomServiceMock;
    private BookingDAO bookingDAOMock;
    private MailSender mailSenderMock;

    @BeforeEach
    void setup() {
        this.paymentServiceMock = mock(PaymentService.class);
        this.roomServiceMock = mock(RoomService.class);
        this.bookingDAOMock = mock(BookingDAO.class);
        this.mailSenderMock = mock(MailSender.class);
        this.bookingService = new BookingService(paymentServiceMock, roomServiceMock, bookingDAOMock, mailSenderMock);
    }

    @Test
    void should_Invoke_Pay_ifPrepaid() {
        // given
        BookingRequest bookingRequest = new BookingRequest("1",
                LocalDate.of(2022, 1, 1),
                LocalDate.of(2022, 1, 5),
                2, true);

        // when
        bookingService.makeBooking(bookingRequest);

        // then
        verify(paymentServiceMock, times(1)).pay(bookingRequest,400.0);
        verifyNoMoreInteractions(paymentServiceMock);
    }

    @Test
    void should_Not_Invoke_Pay_if_Not_Prepaid() {
        // given
        BookingRequest bookingRequest = new BookingRequest("1",
                LocalDate.of(2022, 1, 1),
                LocalDate.of(2022, 1, 5),
                2, false);

        // when
        bookingService.makeBooking(bookingRequest);

        // then
//        verify(paymentServiceMock, times(1)).pay(bookingRequest,400.0);
        verifyNoInteractions(paymentServiceMock);
    }
}
