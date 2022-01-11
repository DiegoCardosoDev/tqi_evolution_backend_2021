package com.system.services;

import com.system.dto.UserClientDto;
import com.system.model.UserClient;

import java.util.List;


public interface UserClientService {

    UserClient findById(Integer id);

    //listar
    List<UserClient> findAll();
    //criar
    UserClient create(UserClientDto obj);
    //atualizar
    UserClient update(UserClientDto obj);
    //deletar
    void delete(Integer id);




}
