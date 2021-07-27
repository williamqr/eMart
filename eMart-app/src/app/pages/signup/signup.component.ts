import { OnInit, Component } from "@angular/core";
import {User} from "../../entity/user";
import {UserService} from "../../service/user.service";
import {Router} from "@angular/router";


@Component({
    selector: 'app-signup',
    templateUrl: './signup.component.html',
    styleUrls: ['./signup.component.css']
  })

export class SignUpComponent implements OnInit{
    title = 'eMart-app';
    public user: User;

    constructor(private userService: UserService,
        private router: Router) {
            this.user = new User();
        }
    ngOnInit() {

    }

    signup(data){
      
        this.userService.signUp( data)
        .subscribe((response) => {
          console.log(response);
          this.redirect();
        }, (error) => {
          console.log(error);
        })
        
      }

      redirect() {
        this.router.navigate(['login']);
    }


}