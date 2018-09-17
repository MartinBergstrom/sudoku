import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { SudokuBoardComponent } from './sudoku-board/sudoku-board.component';
import { HttpClientModule } from '@angular/common/http';
import { SudokuOptionsbarComponent } from './sudoku-optionsbar/sudoku-optionsbar.component';

@NgModule({
  declarations: [
    AppComponent,
    SudokuBoardComponent,
    SudokuOptionsbarComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
