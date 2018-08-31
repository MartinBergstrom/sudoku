import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sudoku-board',
  templateUrl: './sudoku-board.component.html',
  styleUrls: ['./sudoku-board.component.css']
})
export class SudokuBoardComponent implements OnInit {

  private board: number[][] = [
    [0, 0, 0, 0, 0, 6, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0]
  ];

  private selectedNumber: number;

  constructor() {
  }

  ngOnInit() {
  }

  trackByIdx(index: number, obj: any): any {
    return index;
  }

  onClick(): void {
    console.log(this.board);
  }

  onInputClick(nbr: number): void {
    console.log(nbr);
  }
}
