import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { RouterModule, Routes } from '@angular/router';
import { WeatherDetailsComponent } from './components/weather-details.component';
import { WeatherFormComponent } from './components/weather-form.component';
import { WeatherListComponent } from './components/weather-list.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http'

const appRoutes: Routes = [
  { path: 'weather/:city', component: WeatherDetailsComponent }
]

@NgModule({
  declarations: [
    AppComponent,
    WeatherDetailsComponent,
    WeatherFormComponent,
    WeatherListComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes),
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
