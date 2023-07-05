package com.stackroute.lambdaexpression;

public class Product {

  int ProductId;
  String category;
  String productName;
  double price;

  public Product(
    int ProductId,
    String category,
    String productName,
    double price
  ) {
    this.ProductId = ProductId;
    this.category = category;
    this.productName = productName;
    this.price = price;
  }

  public int getId() {
    return ProductId;
  }

  public String getCategory() {
    return category;
  }

  public String getName() {
    return productName;
  }

  public double getPrice() {
    return price;
  }

  //id=1, category='Electronics', name='Samsung S10 Mobile', price=35000.0"

  @Override
  public String toString() {
    return new String(
      "id=" +
      ProductId +
      ", category='" +
      category +
      "', name='" +
      productName +
      "', price=" +
      price
    );
  }
}
