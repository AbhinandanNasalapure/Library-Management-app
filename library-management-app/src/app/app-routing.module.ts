import { AddBookComponent } from './book/add-books/add-book/add-book.component';
import { BookComponent } from './book/book.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {path: 'book', component: BookComponent},
//{path: 'book/add-book', component: AddBookComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
