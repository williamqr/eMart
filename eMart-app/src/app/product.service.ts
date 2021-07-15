import { Product } from './product';
import {Observable} from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';

import { HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class ProductService {

  constructor(private http: HttpClient) { }
  public getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>('http://localhost:8080/api/v1/product');
  }

  postProducts(product:  Product){

    let url = 'http://localhost:8080/api/v1/product';
    let body = JSON.stringify(product);
    let headers = {headers: new HttpHeaders({'Content-Type': 'application/json'})}
    console.log(body);
    return this.http.post(url, body, headers);
  }

  



}
