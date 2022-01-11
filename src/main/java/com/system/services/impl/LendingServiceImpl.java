package com.system.services.impl;


import com.system.dto.LendingDto;
import com.system.dto.UserClientDto;
import com.system.model.Lending;
import com.system.model.UserClient;
import com.system.repositories.LendingRepository;
import com.system.services.LendingService;
import com.system.services.exeptions.ObjectNotFoundExeption;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LendingServiceImpl implements LendingService {

    @Autowired
    LendingRepository repository;

    @Autowired
    private ModelMapper mapper;

    //por id
    @Override
    public Lending findById(Integer id) {
        Optional<Lending> obj = repository.findById(id);
        return obj.orElseThrow(() -> {
            return new ObjectNotFoundExeption("mmm");
        });
    }

    //listar todos emprestimos
    @Override
    public List<Lending> findAll() {
        return repository.findAll();
    }

    //metodo create emprestimo
    @Override
    public Lending create(LendingDto obj) {
        LocalDate limitData = LocalDate.now().plusMonths(3);

        if (obj.getDateOnePayment().equals(limitData)) {
            if (obj.getNumberParcel() <= 60 && obj.getNumberParcel() < 1) {

                return repository.save(mapper.map(obj, Lending.class));

            }else
                throw  new ObjectNotFoundExeption("quanditade de parcelas 60");
        }else {
            throw  new ObjectNotFoundExeption("data exedida");
        }

    }
}
