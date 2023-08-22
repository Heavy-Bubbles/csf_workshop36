import { Component, OnDestroy, OnInit, inject } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Weather } from '../models';
import { Subscription } from 'rxjs';
import { WeatherService } from '../services/weather.service';


@Component({
  selector: 'app-weather-details',
  templateUrl: './weather-details.component.html',
  styleUrls: ['./weather-details.component.css']
})
export class WeatherDetailsComponent implements OnInit, OnDestroy{

  

  city!: string
  weather!: Weather
  sub$!: Subscription

  weatherSvc = inject(WeatherService)
  activatedRoute = inject(ActivatedRoute)

  ngOnInit(): void {
    this.city = this.activatedRoute.snapshot.params['city']
    this.sub$ = this.weatherSvc.getWeather(this.city)
      .subscribe(w => {
        console.log(w)
        this.weather = w
      })
      
  }

  ngOnDestroy(): void {
    this.sub$.unsubscribe
  }

  

}
