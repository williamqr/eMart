import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {ErrorInterceptor} from "./_interceptors/error-interceptor.service";
import {JwtInterceptor} from "./_interceptors/jwt-interceptor.service";
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule }   from '@angular/forms';
import {ProductListComponent} from './pages/products/product.list.component';
import { SignUpComponent } from './pages/signup/signup.component';
import { LoginComponent } from './pages/login/login.component';
import { PaginationComponent } from './parts/pagination/pagination.component';
import {DetailComponent} from './pages/product-detail/detail.component';
import {NavigationComponent} from './parts/navigation/navigation.component';
import { CookieService } from 'ngx-cookie-service';
import { CartComponent } from './pages/cart/cart.component';
import { CardComponent } from './pages/card/card.component';
import { MatCardModule } from '@angular/material/card';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    SignUpComponent,
    NavigationComponent,
    LoginComponent,
    CartComponent,
    DetailComponent,
    CardComponent,
    PaginationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    MatCardModule,
    FormsModule,
    BrowserAnimationsModule
  ],
  providers: [CookieService,
    {provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true},
    {provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true}],
bootstrap: [AppComponent]
})
export class AppModule { }
