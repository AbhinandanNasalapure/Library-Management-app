import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookComponent } from './book/book.component';
import { HttpClientModule } from '@angular/common/http';
import { AddBookComponent } from './book/add-books/add-book/add-book.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ViewBooksComponent } from './book/display-books/view-books/view-books.component';

@NgModule({
  declarations: [
    AppComponent,
    BookComponent,
    AddBookComponent,
    ViewBooksComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
