import { Product } from './product';
import {Observable} from 'rxjs';
import { Injectable } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})

export class ProductService {
  constructor(private http: HttpClient) { }
  public getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>('http://localhost:8080/api/v1/product');
  }
}
