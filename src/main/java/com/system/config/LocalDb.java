package com.system.config;

import com.system.model.Lending;
import com.system.model.UserClient;
import com.system.repositories.UserClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


@Configuration
@Profile("local")
public class LocalDb {

    @Autowired
    private UserClientRepository repository;


    @Bean
    public void startDb() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<Lending> list = new ArrayList<>();

        UserClient u1 = new UserClient(1L, "jose", "jose@j", "3334444", "3333333", "av.jose",
                222, "ap 22", "sp", "sp", "sp", "098888", 2000.0, "4451", (List<Lending>) list);

        Lending l1 = new Lending(1, 50.000, sdf.parse("01/05/2022 "),12, u1);
        list.add(l1);

    }
}
