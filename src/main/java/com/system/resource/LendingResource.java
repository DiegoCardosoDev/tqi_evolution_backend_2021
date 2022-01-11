package com.system.resource;

import com.system.dto.LendingDto;
import com.system.services.LendingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

public class LendingResource {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private LendingService service;

    public static final String ID = "/{id}";

    //procurar emprestimos por id
    @GetMapping(value = ID)
    public ResponseEntity<LendingDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(mapper.map(service.findById(id), LendingDto.class));
    }

    //listar emprrestimos
    @GetMapping
    public ResponseEntity<List<LendingDto>> findAll() {
        return ResponseEntity.ok()
                .body(service.findAll().stream().map(x -> mapper.map(x, LendingDto.class))
                        .collect(Collectors.toList()));

    }

    //criar emprestimo
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<LendingDto> create(@RequestBody LendingDto obj) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path(ID).buildAndExpand(service.create(obj)
                        .getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

}
