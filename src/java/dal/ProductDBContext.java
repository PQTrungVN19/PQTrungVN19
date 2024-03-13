/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;

/**
 *
 * @author phamt
 */
public class ProductDBContext extends DBContext {

    public ArrayList<Product> getAllProduct() {
        ArrayList<Product> Products = new ArrayList<>();
        try {

            String sql = "SELECT * FROM [product]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product a = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                                rs.getInt(9));
                Products.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Products;
    }

    public static void main(String[] args) {
//            System.out.println(new ProductDBContext().getRelatedProductByCId("2").size());
        ArrayList<Product> p = new ProductDBContext().getProductByName("one");
        for (Product product : p) {
            System.out.println(product.getName());
        }
    }

    public Product getProductById(String pid) {
        try {
            String sql = "SELECT * FROM [product] where id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, pid);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Product product = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9));
                return product;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Product> getRelatedProduct(String cid) {
        ArrayList<Product> ps = new ArrayList<>();
        try {
            String sql = "SELECT * FROM [product] where cateID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, cid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9));
                ps.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }

    public ArrayList<Product> getProductByName(String BookSearch) {
        ArrayList<Product> ps = new ArrayList<>();
        try {
            String sql = "SELECT * FROM [product] where [name] like ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, "%" + BookSearch + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                rs.getInt(9));
                ps.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }

    public ArrayList<Product> getProductBySell(int uid) {
        ArrayList<Product> ps = new ArrayList<>();
        try {
            String sql = "SELECT *\n"
                    + "  FROM product where sell_ID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, uid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8),
                            rs.getInt(9));
                ps.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }

    public void deleteProduct(String pid) {
        try {

            String sql = "DELETE FROM [dbo].[product]\n"
                    + "      WHERE id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, pid);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createProduct(Product p) {
        try {
            String sql = "INSERT INTO [dbo].[product]\n"
                    + "           ([name]\n"
                    + "           ,[image]\n"
                    + "           ,[price]\n"
                    + "           ,[title]\n"
                    + "           ,[description]\n"
                    + "           ,[cateID]\n"
                    + "           ,[sell_ID]\n"
                    + "           ,[quantity])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, p.getName());
            stm.setString(2, p.getImage());
            stm.setDouble(3, p.getPrice());
            stm.setString(4, p.getTitle());
            stm.setString(5, p.getDescription());
            stm.setInt(6, p.getCategoryId());
            stm.setInt(7, p.getSellerId());
            stm.setInt(8, p.getQuantity());
            stm.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Product p) {
        try {
            String sql = "UPDATE [dbo].[product]\n"
                    + "   SET [name] = ?\n"
                    + "      ,[image] = ?\n"
                    + "      ,[price] = ?\n"
                    + "      ,[title] = ?\n"
                    + "      ,[description] = ?\n"
                    + "      ,[cateID] = ?\n"
                    + "      ,[sell_ID] = ?\n"
                    + "      ,[quantity] = ?\n"
                    + " WHERE id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, p.getName());
            stm.setString(2, p.getImage());
            stm.setDouble(3, p.getPrice());
            stm.setString(4, p.getTitle());
            stm.setString(5, p.getDescription());
            stm.setInt(6, p.getCategoryId());
            stm.setInt(7, p.getSellerId());
            stm.setInt(8, p.getQuantity());
            stm.setInt(9, p.getId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
