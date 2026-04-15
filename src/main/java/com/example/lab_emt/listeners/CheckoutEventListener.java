package com.example.lab_emt.listeners;

import com.example.lab_emt.events.BookEvent;
import com.example.lab_emt.model.activities.BookingActivity;
import com.example.lab_emt.model.domain.Accommodation;
import com.example.lab_emt.model.domain.Host;
import com.example.lab_emt.model.exception.HostNotFoundException;
import com.example.lab_emt.service.domain.AccommodationService;
import com.example.lab_emt.service.domain.BookingActivityService;
import com.example.lab_emt.service.domain.HostService;
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
    private final AccommodationService accommodationService;
    private final HostService hostService;

    public CheckoutEventListener(BookingActivityService bookingActivityService, AccommodationService accommodationService, HostService hostService) {
        this.bookingActivityService = bookingActivityService;
        this.accommodationService = accommodationService;
        this.hostService = hostService;
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
            Host h = hostService.findById(event.hostId())
                    .orElseThrow(() -> new HostNotFoundException(event.hostId()));

            Accommodation a = accommodationService.findById(event.accId())
                    .orElseThrow(() -> new RuntimeException("No accommodation found with id " + event.accId()));


            BookingActivity ba = new BookingActivity(event.accName(), event.bookTime(), event.successful(), event.full(), a, h);
            bookingActivityService.create(ba);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
