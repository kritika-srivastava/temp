package com.stackroute.oops;

import java.util.ArrayList;

/*
    Class for Analyzing the products present in ProductRepository
 */
public class ProductService {

  /*
        Returns the name of the product given the productCode
     */
  public String findProductNameByCode(int productCode) {
    Product[] all_products = ProductRepository.getProducts();
    for (int i = 0; i < all_products.length; i++) {
      if (all_products[i].getProductCode() == productCode) {
        return all_products[i].getName();
      }
    }
    return null;
  }

  /*
        Returns the Product with maximum price in a given category
     */
  public Product findMaxPriceProductInCategory(String category) {
    Product[] all_products = ProductRepository.getProducts();
    Product MaxPriceProductInCategory = new Product(-1, null, 0, null);
    double price = -1;
    boolean flag = false;
    for (int i = 0; i < all_products.length; i++) {
      if (
        all_products[i].getCategory() == category &&
        all_products[i].getPrice() >= price
      ) {
        flag = true;
        price = all_products[i].getPrice();
        MaxPriceProductInCategory = all_products[i];
      }
    }
    if (flag) {
      return MaxPriceProductInCategory;
    }
    return null;
  }

  /*
        Returns a array of products for a given category
     */
  public Product[] getProductsByCategory(String category) {
    ArrayList<Product> ProductsByCategory = new ArrayList<>();

    Product[] all_products = ProductRepository.getProducts();
    boolean flag = false;
    for (int i = 0; i < all_products.length; i++) {
      if (all_products[i].getCategory() == category) {
        flag = true;
        ProductsByCategory.add(all_products[i]);
      } else {}
    }
    Product[] ret = new Product[ProductsByCategory.size()];
    ProductsByCategory.toArray(ret);
    if (flag) {
      return ret;
    }
    return null;
  }
}
