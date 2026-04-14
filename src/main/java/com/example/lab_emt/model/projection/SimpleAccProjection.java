package com.example.lab_emt.model.projection;

import com.example.lab_emt.model.enums.Category;

public interface SimpleAccProjection {
    Long getId();

    String getName();

    Category getCategory();

    Integer getNumRooms();
}
