import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HelloComponent} from './hello/hello.component';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {HelloService} from "./hello/hello.service";
import {HelloInterceptor} from "./interceptor/helloInterceptor";

@NgModule({
  declarations: [
    AppComponent,
    HelloComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatInputModule,MatButtonModule,FormsModule,CommonModule,HttpClientModule],

  providers: [    { provide: HTTP_INTERCEPTORS, useClass: HelloInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
