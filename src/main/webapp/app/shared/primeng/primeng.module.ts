import {NgModule} from "@angular/core";
import {ToastModule} from "primeng/toast";
import {ButtonModule} from "primeng/button";
import {TableModule} from "primeng/table";
import {InputTextModule} from "primeng/inputtext";
import {CheckboxModule} from "primeng/checkbox";
import {RadioButtonModule} from "primeng/radiobutton";
import {PanelModule} from "primeng/panel";
import {InputTextareaModule} from "primeng/inputtextarea";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {BrowserModule} from "@angular/platform-browser";
import {MessageService} from "primeng/api";

@NgModule({
  imports: [
    ToastModule,
    ButtonModule,
    TableModule,
    InputTextModule,
    CheckboxModule,
    RadioButtonModule,
    PanelModule,
    InputTextareaModule,
  ],
  providers: [
    MessageService
  ],
  exports: [
    ToastModule,
    ButtonModule,
    TableModule,
    InputTextModule,
    CheckboxModule,
    RadioButtonModule,
    PanelModule,
    InputTextareaModule,
  ]
})
export class PrimengModule {}
