import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HelloComponent} from "./hello/hello.component";

const routes: Routes = [{path: "demo", component: HelloComponent},
  {path: "", component: HelloComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
