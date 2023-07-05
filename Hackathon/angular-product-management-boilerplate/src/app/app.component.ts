import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Products } from './products';
import { ProductService } from './services/product.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'productapp';
  constructor(private service: ProductService) { }

  productslist: Products[] = [];
  errormessage = '';


  addProduct(event: Products) {
    this.reloadPage();
    this.service.addProduct(event).subscribe();

  }

  deleteProduct(event: number) {
    console.log("received");
    this.reloadPage();
    this.service.deleteProduct(event).subscribe();

  }
  reloadPage() {
    window.location.reload()
  }
  ngOnInit() {
    this.service.getProducts().subscribe((res) => this.productslist = res);
    //this.reloadPage();
  }
}
