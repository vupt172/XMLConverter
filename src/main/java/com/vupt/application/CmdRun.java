package com.vupt.application;

import com.vupt.application.mapper.MapstructMapper;
import com.vupt.application.xml.GDHSConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

/*
@Configuration
*/
public class CmdRun {
    @Autowired
    MapstructMapper mapstructMapper;
    GDHSConverter gdhsConverter;

    @Bean
    public CommandLineRunner getCommandLineRunner() {
        return args -> {
            mapstructMapper.XML1ToHoSoInfo(null);
            int a = 1;
            int b=1;

        };
    }


}

