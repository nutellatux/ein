package com.uol.ein.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public @Data class IpData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String ipv4;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String continent_name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String country_name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String subdivision_1_name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String subdivision_2_name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String city_name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String latitude;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String longitude;
}
