package sg.edu.nus.iss.server;

import java.io.StringReader;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import sg.edu.nus.iss.server.models.Conditions;
import sg.edu.nus.iss.server.models.Weather;

public class Utility {

    public static JsonObject toJsonObject(String data) {
        JsonReader reader = Json.createReader(new StringReader(data));
        return reader.readObject();
    }

    public static Conditions createConditions(JsonObject j){
        Conditions c = new Conditions();
        c.setDescription("%s - %s".formatted(j.getString("main"), j.getString("description")));
        c.setIcon("https://openweathermap.org/img/wn/%s@4x.png".formatted(j.getString("icon")));
        return c;
    }

    public static Weather createWeather(String json){
        Weather weather = new Weather();
        JsonObject o = Utility.toJsonObject(json);
        weather.setCity(o.getString("name"));
        weather.setWeatherTimeStamp(o.getJsonNumber("dt").longValue());
        weather.setTemperature(o.getJsonObject("main").getJsonNumber("temp").toString());
        weather.setSunriseTimeStamp(o.getJsonObject("sys").getJsonNumber("sunrise").longValue());
        weather.setSunsetTimeStamp(o.getJsonObject("sys").getJsonNumber("sunset").longValue());
        weather.setConditions(o.getJsonArray("weather").stream()
            .map(v -> (JsonObject) v)
            .map(Utility :: createConditions)
            .toList());

        return weather;
    }
    
}
