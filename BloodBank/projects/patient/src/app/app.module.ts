import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PatinetRequestingComponent } from './patinet-requesting/patinet-requesting.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { GetPatientRequestComponent } from './get-patient-request/get-patient-request.component';

@NgModule({
  declarations: [
    AppComponent,
    PatinetRequestingComponent,
    GetPatientRequestComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
