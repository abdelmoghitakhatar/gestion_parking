import { NgModule } from "@angular/core";
import { MessageService } from "primeng/api";
import { ButtonModule } from "primeng/button";
import { CardModule } from "primeng/card";
import { CheckboxModule } from "primeng/checkbox";
import { InputTextModule } from "primeng/inputtext";
import { InputTextareaModule } from "primeng/inputtextarea";
import { PanelModule } from "primeng/panel";
import { RadioButtonModule } from "primeng/radiobutton";
import { TableModule } from "primeng/table";
import { ToastModule } from "primeng/toast";

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
    CardModule,
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
    CardModule,
  ]
})
export class PrimengModule {}
