import { Component, OnInit } from '@angular/core';
import { ProglanguaappService } from '../proglanguaapp.service';


@Component({
  selector: 'app-proglanguaapp',
  templateUrl: './proglanguaapp.component.html',
  styleUrls: ['./proglanguaapp.component.css']
})
export class ProglanguaappComponent implements OnInit {

  prglangs: Array<any> | undefined;
  totalPages: Array<number> | undefined;

  page = 0;
  size = 10;
  order = 'id';
  asc = true;

  isFirst = false;
  isLast = false;

  constructor(private proglanguaappService: ProglanguaappService) { }

  ngOnInit() {
    this.cargarPaises();
  }

  cargarPaises() {
    this.proglanguaappService.PrgLang(this.page, this.size, this.order, this.asc).subscribe(
      data => {
        this.prglangs = data.content;
        this.isFirst = data.first;
        this.isLast = data.last;
        this.totalPages = new Array(data['totalPages']);
        console.log(data);
      },
      err => {
        console.log(err.error);
      }
    );
  }

  sort(): void {
    this.asc = !this.asc;
    this.cargarPaises();
  }

  rewind(): void {
    if (!this.isFirst) {
      this.page--;
      this.cargarPaises();
    }
  }

  forward(): void {
    if (!this.isLast) {
      this.page++;
      this.cargarPaises();
    }
  }

  setPage(page: number): void {
    this.page = page;
    this.cargarPaises();
  }

  setOrder(order: string): void {
    this.order = order;
    this.cargarPaises();
  }

}
