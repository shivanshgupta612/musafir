package com.musafir.matching.service;

import com.musafir.driver.entity.Driver;
import org.springframework.stereotype.Service;

@Service
public class MatchingService {
    public Driver findAvailableDriver(){
        return new Driver();
    }
}
