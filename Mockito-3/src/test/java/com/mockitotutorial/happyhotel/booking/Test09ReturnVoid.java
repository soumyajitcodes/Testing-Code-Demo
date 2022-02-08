package com.mockitotutorial.happyhotel.booking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class Test09ReturnVoid {
    private BookingService bookingService;
    private PaymentService paymentServiceMock;
    private RoomService roomServiceMock;
    private BookingDAO bookingDAOMock;
    private MailSender mailSenderMock;

    @BeforeEach
    void setup() {
        this.paymentServiceMock = mock(PaymentService.class);
        this.roomServiceMock = mock(RoomService.class);
        this.bookingDAOMock = spy(BookingDAO.class);
        this.mailSenderMock = mock(MailSender.class);
        this.bookingService = new BookingService(paymentServiceMock, roomServiceMock, bookingDAOMock, mailSenderMock);
    }

    @Test
    void should_throwException_When_MailerNotReady() {
        BookingRequest bookingRequest = new BookingRequest("1",
                LocalDate.of(2022,1,1),
                LocalDate.of(2022,1,5),
                2, false);
        doThrow(new BusinessException()).when(mailSenderMock).sendBookingConfirmation(any());
        Executable exec = () -> bookingService.makeBooking(bookingRequest);
        assertThrows(BusinessException.class, exec);
    }

    @Test
    void shouldNot_throwException_When_MailerNotReady() {
        BookingRequest bookingRequest = new BookingRequest("1",
                LocalDate.of(2022,1,1),
                LocalDate.of(2022,1,5),
                2, false);
        doNothing().when(mailSenderMock).sendBookingConfirmation(any());
        Executable exec = () -> bookingService.makeBooking(bookingRequest);
//        assertThrows(BusinessException.class, exec);
    }
}
