import { Component, ElementRef, Input, OnInit, OnDestroy } from '@angular/core';
import { SudokuBackendService } from '../sudoku-backend.service';
import { ModalService } from './sudoku-modal.service';

@Component({
  selector: 'app-sudoku-modal',
  templateUrl: './sudoku-modal.component.html',
  styleUrls: ['./sudoku-modal.component.css']
})
export class SudokuModalComponent implements OnInit, OnDestroy {
  @Input() id: string;
  private element: any;

  constructor(private el: ElementRef, private modalService: ModalService) {
    this.element = el.nativeElement;
  }

  ngOnInit() {
    document.body.appendChild(this.element);

    if (!this.id) {
      console.error('modal must have an id');
      return;
    }
    this.element.addEventListener('click', function (e: any) {
      if (e.target.className === 'sd-modal') {
        this.close();
      }
    });
    this.modalService.add(this);
  }

  open(): void {
    console.log('attemping to open modal');
    this.element.style.display = 'block';
    document.body.classList.add('sd-modal-open');
  }

  close(): void {
    this.element.style.display = 'none';
    document.body.classList.remove('sd-modal-open');
  }

  ngOnDestroy(): void {
    this.modalService.remove(this.id);
    this.element.remove();
  }
}
