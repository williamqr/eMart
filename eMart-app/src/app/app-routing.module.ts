import { NgModule } from '@angular/core';
import { FormsModule }   from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { SignUpComponent } from './pages/signup/signup.component';
import {ProductListComponent} from "./pages/products/product.list.component";
import { LoginComponent } from './pages/login/login.component';
const routes: Routes = [
  {path: 'signup', component: SignUpComponent},
  {path: 'product', component: ProductListComponent},
  {path: 'login', component: LoginComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
