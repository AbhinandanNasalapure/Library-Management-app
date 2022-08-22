import { BookService } from './../../book-service';
import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.scss']
})
export class AddBookComponent implements OnInit {

  public bookFormData: FormGroup;


  submitted = false;
  constructor(private bookService: BookService, private formBuilder: FormBuilder) { this.bookFormData = this.createBooksFormGroup(); }

  ngOnInit() {
    this.bookFormData = this.createBooksFormGroup();
  }

  private createBooksFormGroup(): FormGroup {
    return new FormGroup({
      'title': new FormControl(''),
      'author': this.createAuthorFormGroup(),
      'publisher': new FormControl(''),
      'edition': new FormControl(''),
      'isbn': new FormControl(''),
      'publishingDate': new FormControl(''),
      'chapters': this.formBuilder.array([this.createChapterFormGroup()])
    })
  }

  private createAuthorFormGroup(): FormGroup {
    return this.formBuilder.group({
      'givenName': new FormControl(''),
      'surName': new FormControl(''),
      'dateOfBirth': new FormControl(''),
      'bio': new FormControl(''),
    })
  }

  private createChapterFormGroup(): FormGroup {
    return this.formBuilder.group({
      'title': new FormControl(''),
      'startPage': new FormControl(''),
      'numberOfPages': new FormControl(''),
    })
  }
  addBook() {
    const book = this.bookFormData.value;

    this.bookService.addBook(book).subscribe(
      response => {
        console.log(response);
        this.submitted = true;
      },
      error => {
        console.log(error);
      });
  }
  addChapter() {
    const chapters = this.bookFormData.get('chapters') as FormArray;
    chapters.push(this.createChapterFormGroup());
  }

  removeChapter() {
    const chapters = this.bookFormData.get('chapters') as FormArray;

    for (let i = 1; i < chapters.length; i++) {
      chapters.removeAt(i);
    }


  }
  get chapters() {
    return this.bookFormData.controls['chapters'] as FormArray;
  }

  newBook(): void {
    this.submitted = false;
    this.bookFormData.reset();
  }
}
