import { Component, OnInit } from '@angular/core';
import { SudokuBackendService } from '../sudoku-backend.service';

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

  constructor(private sudokuService: SudokuBackendService) {
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

  replaceBoard(): void {
    this.board = this.sudokuService.getRandomSudoku();
  }
}
