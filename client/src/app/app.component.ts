import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  cities: string[] = []

  receiveQuery(event: string){
    this.cities.push(event)
    console.log(this.cities)
  }

  ngOnInit(): void {
    this.cities.push("Singapore")
    this.cities.push("Kuala Lumpur")
    this.cities.push("Tokyo")
    this.cities.push("Bangkok")
    this.cities.push("Hong Kong")
    this.cities.push("Beijing")
  }
}
