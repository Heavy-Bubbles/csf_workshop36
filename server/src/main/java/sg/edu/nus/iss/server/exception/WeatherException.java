package sg.edu.nus.iss.server.exception;

public class WeatherException extends RuntimeException{

    public WeatherException(){
        super();

    }

    public WeatherException(String message){
        super(message);
    }

    public WeatherException(String message, Throwable cause){
        super(message, cause);
    }

    public WeatherException(Throwable cause){
        super(cause);
    }

    
}
