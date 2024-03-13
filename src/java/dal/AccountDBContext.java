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
import model.Account;

/**
 *
 * @author phamt
 */
public class AccountDBContext extends DBContext {

    public Account getAccountByUserPass(String user, String pass) {
        try {
            String sql = "SELECT * FROM Account WHERE [user] = ? and [pass] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, user);
            stm.setString(2, pass);

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Account account = new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getBoolean(5),
                        rs.getBoolean(6));
                return account;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        Account a = new Account(0, "nam", "123", false, false, true);
        new AccountDBContext().createUser(a);
    }

    public Account checkAccountEx(String user) {
        try {
            String sql = "SELECT * FROM Account WHERE [user] = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, user);

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Account account = new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getBoolean(5),
                        rs.getBoolean(6));
                return account;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void createUser(Account account) {
        try {
            String sql = "INSERT INTO [dbo].[Account]\n"
                    + "           ([user]\n"
                    + "           ,[pass]\n"
                    + "           ,[isSell]\n"
                    + "           ,[isAdmin]\n"
                    + "           ,[active])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, account.getUser());
            stm.setString(2, account.getPass());
            stm.setBoolean(3, account.isIsSell());
            stm.setBoolean(4, account.isIsAdmin());
            stm.setBoolean(5, account.isActive());
            stm.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Account> getAllAccount() {
        ArrayList<Account> Accounts = new ArrayList<>();
        try {

            String sql = "SELECT * FROM [Account]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Account a = new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getBoolean(5),
                        rs.getBoolean(6));
                Accounts.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Accounts;
    }

    public Account getAccountById(String aid) {
        try {
            String sql = "SELECT * FROM [Account] where uID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, aid);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Account Account = new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getBoolean(4),
                        rs.getBoolean(5),
                        rs.getBoolean(6));
                return Account;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void update(Account account) {
        try {
            String sql = "UPDATE [dbo].[Account]\n"
                    + "   SET [user] = ?\n"
                    + "      ,[pass] = ?\n"
                    + "      ,[isSell] = ?\n"
                    + "      ,[isAdmin] = ?\n"
                    + "      ,[active] = ?\n"
                    + " WHERE uID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, account.getUser());
            stm.setString(2, account.getPass());
            stm.setBoolean(3, account.isIsSell());
            stm.setBoolean(4, account.isIsAdmin());
            stm.setBoolean(5, account.isActive());
            stm.setInt(6, account.getuID());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteAccountbyID(String aid) {
        try {

            String sql = "DELETE FROM [dbo].[Account]\n"
                    + "      WHERE uID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, aid);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

}
