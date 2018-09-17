import { Component, OnInit, Input } from '@angular/core';
import { SudokuBoardComponent } from '../sudoku-board/sudoku-board.component';

@Component({
  selector: 'app-sudoku-optionsbar',
  templateUrl: './sudoku-optionsbar.component.html',
  styleUrls: ['./sudoku-optionsbar.component.css']
})
export class SudokuOptionsbarComponent implements OnInit {

  // activeBoardReference instead, tab component mainting tabs/list of all sudokus
  @Input() sudoukoBoardRef: SudokuBoardComponent;

  constructor() { }

  ngOnInit() {
  }

  onGenerateNewBoardClick(): void {
    console.log('CLICK');
    this.sudoukoBoardRef.replaceBoard();
  }
}
