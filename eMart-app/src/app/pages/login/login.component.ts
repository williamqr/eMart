import { OnInit, Component } from "@angular/core";
import {User} from "../../entity/user";
import {UserService} from "../../service/user.service";
import {Router} from "@angular/router";

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
  })

export class LoginComponent implements OnInit {
    title = 'eMart-app';
    public user: User;

    constructor(private userService: UserService,
        private router: Router) {
            this.user = new User();
        }
    ngOnInit() {

    }


    login(data){
        this.userService.getUser(data.name, data.pwd)
        .subscribe((response) => {
          if(response) {
              this.redirect();
          }
        }, (error) => {
          console.log(error);
        })
        
      }
    
    redirect() {
        this.router.navigate(['product']);
    }

    directtosign() {
        this.router.navigate(['signup']);
    }
    
}