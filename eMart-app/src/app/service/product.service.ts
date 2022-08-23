import { Product } from '../entity/product';
import {Observable} from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import {apiUrl} from '../../environments/environment';
import {ProductInfo} from '../entity/productInfo';
import { HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class ProductService {


  private productUrl = `${apiUrl}/product`;
  constructor(private http: HttpClient) { }
  public getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>('http://localhost:8080/api/v1/product');
  }

  postProducts(product:  Product){

    let url = 'http://localhost:8080/api/v1/product';
    let body = JSON.stringify(product);
    let headers = {headers: new HttpHeaders({'Content-Type': 'application/json'})}
    return this.http.post(url, body, headers);
  }
  getAllInPage(page: number, size: number): Observable<any> {
    const url = `${this.productUrl}?page=${page}&size=${size}`;
    return this.http.get(url)
        .pipe(
            // tap(_ => console.log(_)),
        )
}


  getDetail(id: String): Observable<ProductInfo> {
    const url = `${this.productUrl}/${id}`;
    return this.http.get<ProductInfo>(url).pipe();
}
  



}

