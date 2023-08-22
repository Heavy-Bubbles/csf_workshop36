package sg.edu.nus.iss.server.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sg.edu.nus.iss.server.exception.WeatherException;
import sg.edu.nus.iss.server.models.Weather;
import sg.edu.nus.iss.server.services.WeatherService;

@Controller
@RequestMapping("/api")
public class WeatherController {
    @Autowired 
    private WeatherService weatherService;

    @GetMapping(path = "/weather")
    @ResponseBody
    public ResponseEntity<Weather> getWeather(@RequestParam(required = true) String city){
        Optional<Weather> weather = weatherService.getWeather(city);
        if (weather.isEmpty()){
            throw new WeatherException();
        }

        return ResponseEntity.ok(weather.get());

    }
}
