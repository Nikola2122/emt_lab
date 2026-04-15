package com.example.lab_emt.service.application;

import com.example.lab_emt.model.dto.MostPopularAccProjection;
import com.example.lab_emt.model.dto.MostPopularHostProjection;

public interface MostPopularAppService {
    MostPopularAccProjection getMostPopularAcc();
    MostPopularHostProjection getMostPopularHost();
}
