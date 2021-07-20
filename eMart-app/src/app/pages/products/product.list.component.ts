import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from "rxjs";
import {ActivatedRoute} from "@angular/router";
import { Product } from '../../entity/product';
import { HttpErrorResponse } from '@angular/common/http';
import { FormsModule }   from '@angular/forms';
import {ProductService} from "../../service/product.service";
@Component({
    selector: 'app-product.list',
    templateUrl: './product.list.component.html',
    styleUrls: ['./product.list.component.css']
})

export class ProductListComponent implements OnInit{
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
  