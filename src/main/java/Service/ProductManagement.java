package Service;

import Model.Product;
import dao.productDAO;

import java.sql.SQLException;
import java.util.List;

public class ProductManagement {
    private productDAO dao = new productDAO();

    // Add product
    public void addProduct(Product p) throws SQLException {
        dao.addProduct(p);
    }

    // View all products
    public List<Product> viewAllProducts() throws SQLException {
        return dao.getAllProducts();
    }

    // Search by ID
    public Product searchProductById(int id) throws SQLException {
        return dao.getProductById(id);
    }

    // Delete product
    public boolean removeProduct(int id) throws SQLException {
        return dao.deleteProduct(id);
    }
}
