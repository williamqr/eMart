import { NgModule } from '@angular/core';
import { FormsModule }   from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { SignUpComponent } from './pages/signup/signup.component';
import {ProductListComponent} from "./pages/products/product.list.component";
import { LoginComponent } from './pages/login/login.component';
import { CartComponent } from './pages/cart/cart.component';
import { DetailComponent } from './pages/product-detail/detail.component';
import { CardComponent } from './pages/card/card.component';
const routes: Routes = [

  {path: '', redirectTo: '/product', pathMatch: 'full'},
  {path: 'product', component: CardComponent},
  {path: 'signup', component: SignUpComponent},
  {path: 'login', component: LoginComponent},
  {path: 'cart', component: CartComponent},
  {path: 'product/:id', component: DetailComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
