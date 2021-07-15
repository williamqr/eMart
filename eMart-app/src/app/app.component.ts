import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Product } from './product';
import { ProductService } from './product.service';
import { FormsModule }   from '@angular/forms';
import { HttpHeaders } from '@angular/common/http';
import {ActivatedRoute, Router} from "@angular/router";
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'eMart-app';
  public products : Product[];
  

  

  constructor(private productService: ProductService) {
      this.products = [];
}


  ngOnInit() {
    this.getProducts();
    
  }
  InsertImage(data): void {
    this.productService.postProducts( data)
    .subscribe((response) => {
      console.log(response);
      this.getProducts();
    }, (error) => {
      console.log(error);
    })
    
  }

  public getProducts(): void{
    this.productService.getProducts().subscribe(
      (response: Product[])=> {
        this.products = response;
      },
      (error: HttpErrorResponse) => {
        console.log("error");
        this.products = []
      }
    )
  }

  


}
