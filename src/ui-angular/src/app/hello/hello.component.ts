import {Component, OnInit} from '@angular/core';
import {Hello} from "./hello";
import {HelloService} from './hello.service';
import {Observable, of} from "rxjs";

@Component({
  selector: 'app-hello',
  templateUrl: './hello.component.html',
  styleUrls: ['./hello.component.css']
})
export class HelloComponent implements OnInit {

  public hello: Hello = new Hello("", "hello");
  public result: Observable<Hello> = of(new Hello("", ""));
  public show = true;

  constructor(private helloService: HelloService) {
  }

  ngOnInit(): void {
  }


  get(): void {
    this.result = this.helloService.get(this.hello);
    this.show = true;
  }
  put(): void {
    this.helloService.put(this.hello).subscribe();
    this.show = false;

  }



}


