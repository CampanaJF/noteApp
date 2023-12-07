import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { HttpClientModule} from "@angular/common/http";
import { ListnotesComponent } from './components/listnotes/listnotes.component';
import { DatePipe} from '@angular/common';
import { NewNoteComponent } from './components/new-note/new-note.component';
import { ActiveComponent } from './components/active/active.component';
import { ArchiveComponent } from './components/archive/archive.component';
import { EditNoteComponent } from './components/edit-note/edit-note.component';



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ListnotesComponent,
    NewNoteComponent,
    ActiveComponent,
    ArchiveComponent,
    EditNoteComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    AppRoutingModule
  ],
  providers: [DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
