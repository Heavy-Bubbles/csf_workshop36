package sg.edu.nus.iss.server.models;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Weather implements Serializable{

    private String city;
    private String temperature;
    private List<Conditions> Conditions;
    private Long weatherTimeStamp;
    private Long sunsetTimeStamp;
    private Long sunriseTimeStamp;
    
}
