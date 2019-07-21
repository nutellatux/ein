package com.uol.ein.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

public @Data class MetaWeatherSearchDTO {

    private List<MetaWeatherDTO> weatherDTOList;

}
