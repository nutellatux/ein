package com.uol.ein.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

public @Data
class MetaWeatherDTO {

    private Integer distance;

    private String title;

    private String location_type;

    private Integer woeid;

    private String latt_long;


}
