import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { Product } from '../../entity/product';
import { HttpErrorResponse } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { ProductService } from '../../service/product.service';
import { UserService } from 'src/app/service/user.service';
import { ProductStatus } from '../../enum/ProductStatus';
import { ProductInfo } from '../../entity/productInfo';
import { JwtResponse } from '../../response/JwtResponse';
import { Role } from '../../enum/Role';
import { ThrowStmt } from '@angular/compiler';
@Component({
  selector: 'app-product.list',
  templateUrl: './product.list.component.html',
  styleUrls: ['./product.list.component.css'],
})
export class ProductListComponent implements OnInit, OnDestroy {
  title = 'eMart-app';
  public products: Product[];

  Role = Role;
  currentUser: JwtResponse;
  page: any;
  ProductStatus = ProductStatus;
  private querySub: Subscription;

  constructor(
    private userService: UserService,
    private productService: ProductService,
    private route: ActivatedRoute
  ) {
    this.currentUser = new JwtResponse;
    this.querySub = new Subscription;
    this.products = [];
  }

  ngOnInit() {
    this.querySub = this.route.queryParams.subscribe(() => {
      this.update();
    });
  }

  ngOnDestroy(): void {
    this.querySub.unsubscribe();
  }

  update() {
    if (this.route.snapshot.queryParamMap.get('page')) {
      const currentPage = +this.route.snapshot.queryParamMap.get('page')!;
      const size = +this.route.snapshot.queryParamMap.get('size')!;
      this.getProds(currentPage, size);
    } else {
      this.getProds();
    }
  }

  getProds(page: number = 1, size: number = 5) {
    this.productService.getAllInPage(+page, +size)
        .subscribe(page => {
            this.page = page;
        });

}
  InsertImage(data): void {
    this.productService.postProducts(data).subscribe(
      (response) => {
        console.log(response);
        this.getProducts();
      },
      (error) => {
        console.log(error);
      }
    );
  }


  public getProducts(): void {
    this.productService.getProducts().subscribe(
      (response: Product[]) => {
        this.products = response;
      },
      (error: HttpErrorResponse) => {
        console.log('error');
        this.products = [];
      }
    );
  }
}
