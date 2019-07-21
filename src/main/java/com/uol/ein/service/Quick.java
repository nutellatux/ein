package com.uol.ein.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uol.ein.DTO.MetaWeatherDTO;
import com.uol.ein.DTO.MetaWeatherSearchDTO;
import com.uol.ein.model.IpData;
import com.uol.ein.model.Location;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;

@Component
public class Quick {
    public static void main(String[] args) throws IOException {

        LocationService locationService = new LocationService();

        String ipAddress = "";

//        locationService.createLocation(ipAddress);

        Date data = new Date();
        Calendar cal = Calendar.getInstance();
//        cal.setTime(data);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);



        String latitudeByIp = "-23.562880";
        String longitudeByIp = "-46.654659";



        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(
                "https://www.metaweather.com/api/location/search/?lattlong=" + latitudeByIp + "," + longitudeByIp);
        request.setHeader("Contenty-Type", String.valueOf(MediaType.APPLICATION_JSON_UTF8));

        HttpResponse responseExternal = client.execute(request);
        String response = EntityUtils.toString(responseExternal.getEntity());

        int codeHttp = responseExternal.getStatusLine().getStatusCode();

        if(codeHttp == 200){

            Location location = new Location();
            ObjectMapper mapper = new ObjectMapper();

            List<Map<String, Object>> listMapMetaWeather = mapper.readValue(response, new TypeReference<List<Map<String,Object>>>(){});

            for (Map<String, Object> mapMetaWeather: listMapMetaWeather) {
                mapMetaWeather.get("");
            }


//            System.out.println(mapWeather);


//                mapWeather.
//                location.setLatitude((String) mapWeather.get("distance "));
//                location.setLongitude((String) mapWeather.get("title "));
//                location.setLongitude((String) mapWeather.get("woeid "));


        }



    }
}
