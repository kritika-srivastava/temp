import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormControl, FormGroup, NgForm } from '@angular/forms';
import { Products } from '../products';
import { ProductService } from '../services/product.service';
import { AppComponent } from '../app.component';
@Component({
  selector: 'app-addproduct',
  templateUrl: './addproduct.component.html',
  styleUrls: ['./addproduct.component.css']
})
export class AddproductComponent {

  constructor(private appService: AppComponent, private productService: ProductService) { }

  // Write Your Code Here
  product: Products = new Products();

  products: Products[] = []
  @Output() save = new EventEmitter;

  handleFormSubmit(form: NgForm) {

    console.log(form.value.name);

    if (form.valid) {
      this.product.name = form.value.name;
      this.product.brand = form.value.brand;
      this.product.price = form.value.price;
      this.product.quantity = form.value.quantity;

      this.save.emit(this.product);
      this.displayList();
      form.reset();

    }
  }

  displayList() {
    this.productService.getProducts().subscribe((res) => this.products = res);
  }

}
