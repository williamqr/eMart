import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormsModule }   from '@angular/forms';
import { HttpHeaders } from '@angular/common/http';
import {ActivatedRoute, Router} from "@angular/router";
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{
  title = 'eMart-app';
  constructor() {
}

}
