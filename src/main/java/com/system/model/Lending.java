package com.system.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.query.criteria.internal.expression.function.AggregationFunction;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_lending")
public class Lending {

    @Id
    private Integer id;

    private Double value;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dateOnePayment;
    private  Integer NumberParcel;





    @JoinColumn(name = "userclient_id")
    @ManyToOne
    private UserClient userClient;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lending lending = (Lending) o;
        return Objects.equals(id, lending.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
