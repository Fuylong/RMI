/**
 * 
 */
package client;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Scanner;

import server.PhoneImpl;
import server.PhoneInterface;

/**
 * @author f_756
 *
 */
public class PhoneClient {

    public static void main(String[] args) throws RemoteException, SQLException {
        Scanner scan = new Scanner(System.in);
        try {
            int RMIPort;
            String hostName;
            String portNum = "1234";
            String registryURL = "rmi://localhost:" + portNum + "/phone";
            PhoneInterface pi = new PhoneImpl();
            Naming.lookup(registryURL);

            System.out.println("欢迎使用通信查询系统！");
            int choice;
            do {
                pi.putMenu();
                System.out.println("输入您的选择：");
                choice = scan.nextInt();
                switch (choice) {
                case 1:
                    pi.add();
                    break;
                case 2:
                    pi.del();
                    // System.out.println("删除用户通讯信息成功");
                    break;
                case 3:
                    pi.update();
                    // System.out.println("修改用户通讯信息成功");
                    break;
                case 4:
                    pi.get();
                    break;
                case 5:
                    pi.getAll();
                    break;
                case 0:
                    System.exit(0);
                }
            } while (true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
