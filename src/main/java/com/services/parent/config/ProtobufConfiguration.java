package com.services.parent.config;

import com.google.protobuf.util.JsonFormat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.protobuf.ProtobufJsonFormatHttpMessageConverter;

@Configuration
public class ProtobufConfiguration {

    @Bean
    ProtobufJsonFormatHttpMessageConverter protobufJsonFormatHttpMessageConverter() {
        return new ProtobufJsonFormatHttpMessageConverter(JsonFormat.parser().ignoringUnknownFields(), JsonFormat.printer().includingDefaultValueFields());
    }
}
