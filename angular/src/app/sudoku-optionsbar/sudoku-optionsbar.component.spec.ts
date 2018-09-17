import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SudokuOptionsbarComponent } from './sudoku-optionsbar.component';

describe('SudokuOptionsbarComponent', () => {
  let component: SudokuOptionsbarComponent;
  let fixture: ComponentFixture<SudokuOptionsbarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SudokuOptionsbarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SudokuOptionsbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
