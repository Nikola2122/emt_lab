package com.example.lab_emt.jobs;

import com.example.lab_emt.repository.AccMatViewRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MaterializedViewRefreshScheduler {
    private final AccMatViewRepository accMatViewRepository;

    public MaterializedViewRefreshScheduler(AccMatViewRepository accMatViewRepository) {
        this.accMatViewRepository = accMatViewRepository;
    }

    @Scheduled(cron = "0 * * * * *")
    @Transactional
    public void refreshProductCatalogView() {
        log.info("Refreshing acc_mat_view...");
        System.out.println("working");
        accMatViewRepository.refresh();
        log.info("acc_mat_view successfully refreshed.");
    }
}
