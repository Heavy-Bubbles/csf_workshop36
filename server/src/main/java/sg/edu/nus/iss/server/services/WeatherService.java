package sg.edu.nus.iss.server.services;

import java.util.Optional;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import sg.edu.nus.iss.server.Utility;
import sg.edu.nus.iss.server.models.Weather;

@Service
public class WeatherService {

    private static final String openWeatherUrl = "https://api.openweathermap.org/data/2.5/weather";
    private static final String openWeatherApiKey = "476e23fe1116f4e69d2a3e68672604e1";

    public Optional<Weather> getWeather(String city){
        String weatherUrl = UriComponentsBuilder
            .fromUriString(openWeatherUrl)
            .queryParam("q", city)
            .queryParam("appId", openWeatherApiKey)
            .toUriString();

        RequestEntity<Void> req = RequestEntity.get(weatherUrl).build();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> resp = restTemplate.exchange(req, String.class);
        Weather weather = Utility.createWeather(resp.getBody());
        if (weather != null){
            return Optional.of(weather);
        }
        return Optional.empty();
    }
    
}
