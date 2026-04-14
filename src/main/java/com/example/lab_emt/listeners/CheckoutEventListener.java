package com.example.lab_emt.listeners;

import com.example.lab_emt.events.BookEvent;
import com.example.lab_emt.model.activities.BookingActivity;
import com.example.lab_emt.service.domain.BookingActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@Slf4j
public class CheckoutEventListener {
    private final BookingActivityService bookingActivityService;

    public CheckoutEventListener(BookingActivityService bookingActivityService) {
        this.bookingActivityService = bookingActivityService;
    }

    @EventListener()
    @Async
    public void onCartCheckedOut(BookEvent event) {
        log.info("onBook");

        if (event.full()) {
            log.info("FULL ACCOMMODATION {}", event.accName());
        }

        saveBookingActivity(event);
    }

    private void saveBookingActivity(BookEvent event) {
        try {
            Thread.sleep(2000);
            BookingActivity ba = new BookingActivity(event.accName(), event.bookTime(), event.successful(), event.full());
            bookingActivityService.create(ba);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
