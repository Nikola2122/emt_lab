package com.example.lab_emt.model.projection;

import com.example.lab_emt.model.enums.Category;

public interface DetailedAccProjection {
    Long getId();

    String getName();

    Category getCategory();

    Integer getNumRooms();

    String getHostName();

    String getHostSurname();

    String getHostCountryName();
}
