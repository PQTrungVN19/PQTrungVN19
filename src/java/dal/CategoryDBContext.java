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
import model.Category;


/**
 *
 * @author phamt
 */
public class CategoryDBContext extends DBContext {

    public ArrayList<Category> getAllCate() {
        ArrayList<Category> Categorys = new ArrayList<>();
        try {

            String sql = "SELECT * FROM [category]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Category a = new Category(rs.getInt(1), rs.getString(2));
                Categorys.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Categorys;
    }

}
