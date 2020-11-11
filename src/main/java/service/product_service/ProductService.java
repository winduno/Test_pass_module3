package service.product_service;

import model.Category;
import model.Product;
import service.ConnectDB;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {
    @Override
    public List<Product> searchAllProduct() {
        List<Product> productList = new ArrayList<>();
        Connection connection = ConnectDB.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from product;");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                float price = resultSet.getFloat("price");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                int catId = resultSet.getInt("catId");

                productList.add(new Product(id, name, price, color, description, getCategoryById(catId)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productList;
    }

    @Override
    public Product searchProductByID(int productId) {
        Product product = null;
        Connection connection = ConnectDB.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from product where id = " + productId);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                float price = resultSet.getFloat("price");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                int catId = resultSet.getInt("catId");

                product = new Product(id, name, price, color, description, getCategoryById(catId));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    @Override
    public void editProduct(Product product) {
        Connection connection = ConnectDB.getInstance().getConnection();
        String sql = "update product set name = ?, price = ?, color = ?, description = ?, catId = ? where id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(6, product.getId());
            preparedStatement.setString(1, product.getName());
            preparedStatement.setFloat(2, product.getPrice());
            preparedStatement.setString(3, product.getColor());
            preparedStatement.setString(4, product.getDescription());
            preparedStatement.setInt(5, product.getCategory().getCatId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteProduct(int productId) {
        Connection connection = ConnectDB.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute("delete from product where id = " + productId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Category getCategoryById(int catId) {
        Category category = null;
        Connection connection = ConnectDB.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from category where id = " + catId);
            while (resultSet.next()){
                String name = resultSet.getString("catName");
                category = new Category(catId, name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return category;
    }

    @Override
    public Category getCategoryByName(String catName) {
        Category category = null;
        Connection connection = ConnectDB.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from category where catNam = " + catName);
            while (resultSet.next()){
                int catId = resultSet.getInt("id");
                category = new Category(catId, catName);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return category;
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> categoryList = new ArrayList<>();
        Connection connection = ConnectDB.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from category;");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String catName = resultSet.getString("catName");

                categoryList.add(new Category(id, catName));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return categoryList;
    }

    public static void main(String[] args) {
        ProductService service = new ProductService();
        List<Category> list = service.getAllCategories();
        System.out.println(list.get(1).getCatName());
    }

    @Override
    public void createProduct(Product product) {
        Connection connection = ConnectDB.getInstance().getConnection();
        String sql = "insert into product (name, price, color, description, catId) values (?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setFloat(2, product.getPrice());
            preparedStatement.setString(3, product.getColor());
            preparedStatement.setString(4, product.getDescription());
            preparedStatement.setInt(5, product.getCategory().getCatId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
