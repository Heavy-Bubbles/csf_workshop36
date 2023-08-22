import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Weather } from '../models';
import { Observable } from 'rxjs';

const url ="/api/weather"

@Injectable({
  providedIn: 'root'
})
export class WeatherService {

  http = inject(HttpClient)

  getWeather(city: string):Observable<Weather>{
    const params = new HttpParams()
      .set('city', city)

    return this.http.get<Weather>(url, {params: params})
    
  }
}
