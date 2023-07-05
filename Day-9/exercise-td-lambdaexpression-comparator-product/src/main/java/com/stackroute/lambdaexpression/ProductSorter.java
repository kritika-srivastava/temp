package com.stackroute.lambdaexpression;

import java.util.*;

public class ProductSorter {

  List<Product> productList;

  public ProductSorter() {
    productList = new ArrayList<>();
  }

  public List<Product> getProductList() {
    return productList;
  }

  public List<Product> sortProductByNameLength() {
    Collections.sort(
      productList,
      (Product p1, Product p2) ->
        (p1.getName().length() > p2.getName().length())
          ? 1
          : (
            (p1.getName().length() < p2.getName().length())
              ? -1
              : (p1.getName().compareTo(p2.getName()) > 0)
                ? 1
                : ((p1.getName().compareTo(p2.getName()) < 0) ? -1 : 0)
          )
    );

    return productList;
  }

  public List<Product> sortProductByName() {
    Collections.sort(
      productList,
      (Product p1, Product p2) ->
        (p1.getName().compareTo(p2.getName()) > 0)
          ? 1
          : ((p1.getName().compareTo(p2.getName()) < 0) ? -1 : 0)
    );

    return productList;
  }

  public List<Product> sortProductByPriceDescending() {
    Collections.sort(
      productList,
      (Product p1, Product p2) ->
        (p1.getPrice() > p2.getPrice())
          ? -1
          : ((p1.getPrice() < p2.getPrice()) ? 1 : 0)
    );

    return productList;
  }

  public List<Product> sortProductByCategoryAscendingAndByPriceDescending() {
    Collections.sort(
      productList,
      (Product p1, Product p2) ->
        (p1.getCategory().compareTo(p2.getCategory()) > 0)
          ? 1
          : (
            (p1.getPrice() > p2.getPrice())
              ? -1
              : ((p1.getPrice() < p2.getPrice()) ? 1 : 0)
          )
    );
    System.out.println(productList);
    return productList;
  }
}
