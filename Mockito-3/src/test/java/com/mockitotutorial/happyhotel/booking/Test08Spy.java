package com.mockitotutorial.happyhotel.booking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

public class Test08Spy {
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
    void should_Return_BookingID_If_PrepaidTrue() {
        // given
        BookingRequest bookingRequest = new BookingRequest("1",
                LocalDate.of(2022, 1, 1),
                LocalDate.of(2022, 1, 5),
                2, true);

        // when
        String bookingId = bookingService.makeBooking(bookingRequest);

        // then
        verify(bookingDAOMock);
        System.out.println("Booking Id = "+bookingId);
    }

    @Test
    void should_Cancel_Booking_if_Exists() {
        // given
        BookingRequest bookingRequest = new BookingRequest("1",
                LocalDate.of(2022, 1, 1),
                LocalDate.of(2022, 1, 5),
                2, true);

        // when
        String bookingId = bookingService.makeBooking(bookingRequest);
        doReturn(bookingRequest).when(bookingDAOMock).get(bookingId);

        // then
        bookingService.cancelBooking(bookingId);
    }
}
