import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SudokuBackendService {

  constructor(private http: HttpClient) {
  }

  // send http request to backend rest interface
}
