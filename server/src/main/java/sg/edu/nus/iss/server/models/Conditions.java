package sg.edu.nus.iss.server.models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Conditions implements Serializable{
    private String description;
    private String icon;
    
}


