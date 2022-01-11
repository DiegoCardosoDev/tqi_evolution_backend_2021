package com.system.services;

import com.system.dto.LendingDto;
import com.system.model.Lending;
import java.util.List;


public interface LendingService {

    Lending findById(Integer id);
    List<Lending> findAll();
    Lending create(LendingDto obj);


}
