import { Component, EventEmitter, Output, inject } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-weather-form',
  templateUrl: './weather-form.component.html',
  styleUrls: ['./weather-form.component.css']
})
export class WeatherFormComponent {
  
  weatherForm! : FormGroup
  city!: string
  @Output() onSubmit: EventEmitter<string> = new EventEmitter()

  private fb = inject(FormBuilder)

  ngOnInit(): void {
    this.weatherForm = this.createWeatherForm()
  }

  submit(){
    this.city = this.weatherForm.value["city"]
    this.onSubmit.emit(this.city)
  }

  private createWeatherForm(){
    return this.fb.group({
      city: this.fb.control<string>('')
    })
  }
}
