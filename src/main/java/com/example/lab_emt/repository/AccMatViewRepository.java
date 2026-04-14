package com.example.lab_emt.repository;

import com.example.lab_emt.model.views.AccMatView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccMatViewRepository extends JpaRepository<AccMatView, Long> {
    @Modifying
    @Query(value = "call refresh_acc_mat_view()", nativeQuery = true)
    void refresh();
}
