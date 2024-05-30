import {NgModule} from "@angular/core";
import {PrimengModule} from "./primeng/primeng.module";
import {CommonModule} from "@angular/common";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {CardModule} from "primeng/card";
import {ButtonModule} from "primeng/button";

@NgModule({
  imports:[
    PrimengModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    CardModule,
    ButtonModule
  ],
  declarations:[],
  exports:[
    PrimengModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    CardModule,
    ButtonModule
  ]
})
export class SharedModule{}
