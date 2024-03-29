package com.uol.ein.service;

import com.uol.ein.exception.LocationNotFoundException;
import com.uol.ein.externalservice.IpVililanteService;
import com.uol.ein.externalservice.MetaWeatherService;
import com.uol.ein.model.Location;
import com.uol.ein.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private MetaWeatherService metaWeatherService;

    @Autowired
    private IpVililanteService ipVililanteService;

    public Location findLocationById(Long locationId){
        Optional<Location> location = locationRepository.findById(locationId);
        if(location.isEmpty()){
            throw new LocationNotFoundException("Location not found.");
        }
        return location.get();
    }

    public void createLocation(String ipAddress) throws IOException {

        Location locationFromUser = new Location();

        Location newLocation = ipVililanteService.getIpVigilante(ipAddress);
        locationFromUser.setLatitude(newLocation.getLatitude());
        locationFromUser.setLongitude(newLocation.getLongitude());
//        locationFromUser.setLatitude("-23.562880");
//        locationFromUser.setLongitude("-46.90000");

        // woeid = Where On Earth ID
        String woeid = metaWeatherService.getWOEId(locationFromUser.getLatitude(), locationFromUser.getLongitude());

        Location locationWithWeather = metaWeatherService.getWeather(woeid);
        locationFromUser.setMin_temp(locationWithWeather.getMin_temp());
        locationFromUser.setMax_temp(locationWithWeather.getMax_temp());
    }

    public List<Location> findAllLocation(){
        return locationRepository.findAll();
    }

    public Location updateLocation(Location location) { // TODO: Não esta atualizando direito
        Location foundUser = findLocationById(location.getId());
        foundUser = location;
        return locationRepository.save(location);
    }

    public void deleteLocation(Long locationId) {
        findLocationById(locationId);
        locationRepository.deleteById(locationId);
    }

}
