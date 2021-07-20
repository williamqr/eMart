import {User} from "../entity/user";
import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {BehaviorSubject, Observable, of, Subject} from 'rxjs';
import {apiUrl} from '../../environments/environment';
import { HttpHeaders } from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})

export class UserService {
    constructor(private http: HttpClient) { }

    signUp(user: User){
        const url = `${apiUrl}/user`;
        let body = JSON.stringify(user);
        let headers = {headers: new HttpHeaders({'Content-Type': 'application/json'})}
    
        
        
        return this.http.post(url, body, headers);
    }


    getUser(name: string, pwd: Text) {
        let headers = new HttpHeaders({'Content-Type': 'application/json'});
        let params = new HttpParams().append('name', name);
        return this.http.get<User>('http://localhost:8080/api/v1/user/'+name+'/'+pwd, {headers, params});
    }
}