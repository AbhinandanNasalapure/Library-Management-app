import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, throwError } from "rxjs";
import { tap, catchError, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class BookService {
  apiurl = 'http://localhost:8080/library/book';
  headers = new HttpHeaders().set('Content-Type', 'application/json').set('Accept', 'application/json');
  httpOptions = {
    headers: this.headers
  };

  constructor(private httpClient: HttpClient){
  }

  private handleError(error: any) {
    console.log(error);
    return throwError(error);
  }

  getBooks(): Observable<any[]> {
    return this.httpClient.get<any[]>(this.apiurl).pipe(
      tap(data => console.log(data)),
      catchError(this.handleError)
    );
  }

  addBook(book:any): Observable<any> {
    return this.httpClient.post(this.apiurl, book, this.httpOptions).pipe(
      tap(data => console.log(data)),
      catchError(this.handleError)
    );
  }

  updateBook(book:any, title:string): Observable<any> {
    return this.httpClient.patch<any>(this.apiurl + '/' + title, book, this.httpOptions).pipe(
      tap(data => console.log(data)),
      catchError(this.handleError)
    );
  }

  deleteany(title:string): Observable<any> {
    return this.httpClient.delete<any>(this.apiurl+'/'+title, this.httpOptions).pipe(
      tap(data => console.log(data)),
      catchError(this.handleError)
    )
  }
}
