import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserAppService {
  API = 'http://localhost:8081';

  constructor(private http: HttpClient) { }

  public insertUser(userData: any) {
    return this.http.post(this.API + '/insertUser', userData);  // can also write this as this.http.get(`${this.API}/insertUser` , userData);
  }

  public getUsers() {
    return this.http.get(this.API + '/readUser'); // can also write this as this.http.get(`${this.API}/readUser`);
  }

  public deleteUser(id: number) {
    return this.http.delete(this.API + '/deleteUser/' + id);  // can also write this as this.http.get(`${this.API}/deleteUser` , id);
  }
  

  public updateUser(userData: any) {
  return this.http.put(this.API + '/updateUser', userData); // can also write this as this.http.get(`${this.API}/updateUser` , userData);
}
}
