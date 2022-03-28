import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Hello} from "./hello";
import {Observable, throwError} from 'rxjs';
import {catchError, retry} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class HelloService {

  url: string = "./api/hello/";


  constructor(private http: HttpClient) {
  }

  public get(hello: Hello): Observable<Hello> {
    return this.http.get<Hello>(this.url + hello.id);

  }

  public put(hello: Hello): Observable<Hello> {
    return this.http.put<Hello>(this.url + hello.id, hello);//.pipe(() =>  hello);
  }

}
