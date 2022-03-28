import { Injectable } from '@angular/core';

import { catchError } from 'rxjs/operators';
import {HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Observable, throwError} from "rxjs";

@Injectable()
export class HelloInterceptor implements HttpInterceptor {
  intercept(httpRequest: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return next.handle(httpRequest).pipe(
      catchError((error: HttpErrorResponse) => {
        let errorMsg = '';
        if (error.error instanceof ErrorEvent) {
          alert('this is client side error');
          errorMsg = `Error: ${error.error.message}`;
        }
        else {
          errorMsg = `Error Code: ${error.status},  Message: ${error.message}`;
          alert(errorMsg);

        }

        //return throwError(() => new Error(errorMsg))
        return throwError(errorMsg);
      })
    );
  }
}
