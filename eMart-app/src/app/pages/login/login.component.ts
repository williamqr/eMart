import { OnInit, Component } from "@angular/core";
import {User} from "../../entity/user";
import {UserService} from "../../service/user.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Role} from "../../enum/Role";
@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
  })

export class LoginComponent implements OnInit {
    title = 'eMart-app';
    isInvalid: boolean;
    isLogout: boolean;
    submitted = false;
    model: any = {
        username: '',
        password: '',
        remembered: false
    };

    returnUrl = '/';

    constructor(private userService: UserService,
                private router: Router,
                private route: ActivatedRoute) {
                  this.isInvalid = false;
                  this.isLogout = false;
    }

    ngOnInit() {
      let params = this.route.snapshot.queryParamMap;
      this.isLogout = params.has('logout');
      this.returnUrl = params.get('returnUrl') || '{}';
  }


  login() {
    this.submitted = true;
    this.userService.login(this.model).subscribe(
        user => {
            if (user) {
                if (user.role != Role.Customer) {

                    this.returnUrl = '/seller';
                }

                this.router.navigateByUrl(this.returnUrl);
            } else {
                this.isLogout = false;
                this.isInvalid = true;
            }

        }
    );
}
    
    redirect() {
        this.router.navigate(['product']);
    }

    directtosign() {
        this.router.navigate(['signup']);
    }
    
}