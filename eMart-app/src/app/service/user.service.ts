import { User } from '../entity/user';
import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { BehaviorSubject, Observable, of, Subject } from 'rxjs';
import { apiUrl } from '../../environments/environment';
import { HttpHeaders } from '@angular/common/http';
import { JwtResponse } from '../response/JwtResponse';
import { catchError, tap } from 'rxjs/operators';
import { CookieService } from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private currentUserSubject: BehaviorSubject<JwtResponse>;
  public currentUser: Observable<JwtResponse>;
  public nameTerms = new Subject<string>();
  public name$ = this.nameTerms.asObservable();
  constructor(private http: HttpClient, private cookieService: CookieService) {
    const memo = localStorage.getItem('currentUser')!;
    this.currentUserSubject = new BehaviorSubject<JwtResponse>(JSON.parse(memo));
    this.currentUser = this.currentUserSubject.asObservable();
    cookieService.set('currentUser', memo);
  }

  get currentUserValue() {
    return this.currentUserSubject.value;
  }

  getToken() {
      return localStorage.getItem('token');
  }

  signUp(user: User) {
    const url = `${apiUrl}/user`;
    let body = JSON.stringify(user);
    let headers = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
    };
    return this.http.post(url, body, headers);
  }

  get(email: string): Observable<User> {
    const url = `${apiUrl}/profile/${email}`;
    return this.http.get<User>(url);
  }
  getUser(name: string, pwd: Text) {
    let headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    let params = new HttpParams().append('name', name);
    return this.http.get<User>(
      'http://localhost:8080/api/v1/user/' + name + '/' + pwd,
      { headers, params }
    );
  }

  login(loginForm): Observable<JwtResponse | null> {
    const url = `${apiUrl}/user/login`;
    console.log("HEYYYY");
    return this.http.post<JwtResponse>(url, loginForm).pipe(
      tap((user) => {
        console.log("HEYYYY");
        if (user && user.token) {
            console.log(JSON.stringify(user));
          this.cookieService.set('currentUser', JSON.stringify(user));
          if (loginForm.remembered) {
            localStorage.setItem('currentUser', JSON.stringify(user));
          }
          console.log(user.name);
          this.nameTerms.next(user.name);
          this.currentUserSubject.next(user);
          return user;
        }
        else {
            console.log("WRONG");
        }
      }),
      catchError(this.handleError('Login Failed', null))
    );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.log(error); // log to console instead

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  logout() {
    this.currentUserSubject.next(new JwtResponse());
    localStorage.removeItem('currentUser');
    this.cookieService.delete('currentUser');
  }
}
