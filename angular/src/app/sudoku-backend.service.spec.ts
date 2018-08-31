import { TestBed, inject } from '@angular/core/testing';

import { SudokuBackendService } from './sudoku-backend.service';

describe('SudokuBackendService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SudokuBackendService]
    });
  });

  it('should be created', inject([SudokuBackendService], (service: SudokuBackendService) => {
    expect(service).toBeTruthy();
  }));
});
