/**
 * 
 */
package phone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.Database;

/**
 * @author f_756
 *
 */
public class PhoneDao {

    Phone phone = null;
    List<Phone> list = null;

    public void addPhone(Phone p) throws SQLException {
        Connection conn = Database.getConnection();
        String sql = "insert into number " + "(name,phone,sex)" + "values" + "(?,?,?)";
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setString(1, p.getName());
        ptmt.setString(2, p.getPhone());
        ptmt.setString(3, p.getSex());
        ptmt.execute();
    }

    public void delPhone(String name, String value) throws SQLException {
        Connection conn = Database.getConnection();
        String sql = "delete from number where " + name + " = ?";
        PreparedStatement ptmt = conn.prepareStatement(sql);
        // ptmt.setString(1, name);
        ptmt.setString(1, value);
        ptmt.execute();
    }

    public void updatePhone(String value, String name) throws SQLException {
        Connection conn = Database.getConnection();
        String sql = "update number set phone = ? where name = ?";
        // System.out.println(sql);
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setString(1, value);
        ptmt.setString(2, name);
        ptmt.execute();
    }

    public Phone getPhone(String name, String value) throws SQLException {
        Connection conn = Database.getConnection();

        String sql = "select * from number " + "where " + name + " = ?";
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setString(1, value);
        ResultSet rs = ptmt.executeQuery();
        phone = new Phone();
        if (rs.next()) {
            phone.setName(rs.getString("name"));
            phone.setPhone(rs.getString("phone"));
            phone.setSex(rs.getString("sex"));
        } else {
            phone = null;
        }

        return phone;
    }

    public List<Phone> getPhones() throws SQLException {
        Connection conn = Database.getConnection();
        list = new ArrayList<Phone>();
        String sql = "select * from number";
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ResultSet rs = ptmt.executeQuery();
        while (rs.next()) {
            phone = new Phone();
            phone.setName(rs.getString("name"));
            phone.setPhone(rs.getString("phone"));
            phone.setSex(rs.getString("sex"));
            list.add(phone);
        }

        return list;
    }
}
