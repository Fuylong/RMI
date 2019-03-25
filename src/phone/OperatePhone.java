/**
 * 
 */
package phone;

import java.sql.SQLException;
import java.util.List;

/**
 * @author f_756
 *
 */
public class OperatePhone {

    private static PhoneDao pd = new PhoneDao();

    public OperatePhone() {
    }

    public void addPhone(Phone p) throws SQLException {
        pd.addPhone(p);
    }

    public void delPhone(String name, String value) throws SQLException {
        pd.delPhone(name, value);
    }

    public void updatePhone(String value, String name) throws SQLException {
        pd.updatePhone(value, name);
    }

    public Phone getPhone(String name, String value) throws SQLException {
        return pd.getPhone(name, value);
    }

    public List getPhones() throws SQLException {
        return pd.getPhones();
    }
}
