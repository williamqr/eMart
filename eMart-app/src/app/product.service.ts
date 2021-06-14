import { Product } from './product';
import {Observable} from 'rxjs';
import 'rxjs/add/operator/map';
import { Injectable } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})

export class ProductService {
  private apiServiceUrl = environment.apiBaseUrl;
  constructor(private http: HttpClient) { }
  public getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>('${this.apiServiceUrl}/product');
  }
}