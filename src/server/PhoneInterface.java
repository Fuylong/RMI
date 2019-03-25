/**
 * 
 */
package server;

import java.sql.SQLException;

/**
 * @author f_756
 *
 */
public interface PhoneInterface {

    public void putMenu();

    public void add() throws SQLException;

    public void del() throws SQLException;

    public void update() throws SQLException;

    public void get() throws SQLException;

    public void getAll() throws SQLException;
}
