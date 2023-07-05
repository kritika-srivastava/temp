import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { AppComponent } from '../app.component';
import { Products } from '../products';
import { ProductService } from '../services/product.service';

@Component({
  selector: 'app-productsdata',
  templateUrl: './productsdata.component.html',
  styleUrls: ['./productsdata.component.css']
})
export class ProductsdataComponent implements OnInit {

  @Input() products: Products[] = [];

  constructor(private appService: AppComponent, private productService: ProductService) {
    this.productService.getProducts().subscribe((res) => this.products = res);
  }

  @Output() delete = new EventEmitter<number>();

  deleteProduct(id: number) {
    console.log("left");
    this.delete.emit(id);
    this.ngOnInit()
  }



  ngOnInit() {
  }


}
