package com.system.services.impl;

import com.system.dto.UserClientDto;
import com.system.model.UserClient;
import com.system.repositories.UserClientRepository;
import com.system.services.UserClientService;
import com.system.services.exeptions.ObjectNotFoundExeption;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserClientServiceImpl implements UserClientService {

    @Autowired
    UserClientRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public UserClient findById(Integer id) {
        Optional<UserClient> obj = repository.findById(id);
        return obj.orElseThrow(() -> {
            return new ObjectNotFoundExeption("nao encontrado");
        });

    }

    //listar clientes
    public List<UserClient> findAll() {
        return repository.findAll();
    }

    //metodo create
    @Override
    public UserClient create(UserClientDto obj) {
        return repository.save(mapper.map(obj, UserClient.class));
    }

    @Override
    public UserClient update(UserClientDto obj) {
        return repository.save(mapper.map(obj, UserClient.class));
    }

    @Override
    public void delete(Integer id) {
        findById(id);
        repository.deleteById(id);
    }


}
