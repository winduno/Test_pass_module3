package service.product_service;

import model.Category;
import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> searchAllProduct();
    Product searchProductByID(int productId);
    void editProduct(Product productId);
    void deleteProduct(int productId);
    Category getCategoryById(int catId);
    void createProduct(Product product);
    Category getCategoryByName(String catName);
    List<Category> getAllCategories();
}
