package com.system.resource;


import com.system.dto.UserClientDto;
import com.system.model.UserClient;
import com.system.services.UserClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserClientResource {

    public static final String ID = "/{id}";

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserClientService service;



    @GetMapping(value = ID)
    public ResponseEntity<UserClientDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(mapper.map(service.findById(id), UserClientDto.class));
    }

    @GetMapping
    public ResponseEntity<List<UserClientDto>> findAll() {
        return ResponseEntity.ok()
                .body(service.findAll().stream().map(x -> mapper.map(x, UserClientDto.class)).collect(Collectors.toList()));

    }

    //metodo para criar um user
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserClientDto> create(@RequestBody UserClientDto obj) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path(ID).buildAndExpand(service.create(obj)
                        .getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    //metod delete por id
    @DeleteMapping(value = ID)
    public ResponseEntity<UserClientDto> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();


    }

    //metodo para atulizar user por id
    @PutMapping(value = ID)
    public ResponseEntity<UserClientDto> update(@PathVariable Integer id, @RequestBody UserClientDto obj) {
        UserClient newObj = service.update(obj);
        return ResponseEntity.ok().body(mapper.map(newObj, UserClientDto.class));

    }

}







