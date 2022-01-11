package com.system.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


//getters e setters
@Getter
@Setter
//construtores

@AllArgsConstructor
@NoArgsConstructor
public class UserClientDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;
    private String email;
    private String cpf;
    private String rg;
    private String andress;
    private Integer number;
    private String complements;
    private String city;
    private String state;
    private String country;
    private String cep;
    private Double salary;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;











}
