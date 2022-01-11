package com.system.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class LendingDto {

    @Id
    private Integer id;
    private Double value;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime dateOnePayment;
    private  Integer NumberParcel;
}
