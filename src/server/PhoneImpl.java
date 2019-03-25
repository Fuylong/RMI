/**
 * 
 */
package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import phone.OperatePhone;
import phone.Phone;

/**
 * @author f_756
 *
 */
public class PhoneImpl extends UnicastRemoteObject implements PhoneInterface {

    /**
     * @throws RemoteException
     */
    public PhoneImpl() throws RemoteException {
        super();
        // TODO Auto-generated constructor stub
    }

    static Scanner scan = new Scanner(System.in);
    private static Phone p;
    private static List<Phone> list;
    private static OperatePhone op = null;
    // private static PhoneImpl pl = new PhoneImpl();

    @Override
    public void putMenu() {
        System.out.println("1-添加用户通讯信息");
        System.out.println("2-删除用户通讯信息");
        System.out.println("3-修改用户通讯信息");
        System.out.println("4-查询用户通讯信息");
        System.out.println("5-查看用户所有通讯信息");
        System.out.println("0-退出系统");
    }

    public static String getString(int num) {
        if (num == 1) {
            return "name";
        } else {
            return "phone";
        }
    }

    @Override
    public void add() throws SQLException {
        System.out.println("添加用户通讯信息");
        p = new Phone();
        scan.nextLine();
        System.out.print("请输入用户姓名：");
        String name = scan.next();
        p.setName(name);
        System.out.print("请输入用户电话：");
        String phone = scan.next();
        p.setPhone(phone);
        System.out.print("请输入用户性别：");
        String sex = scan.next();
        p.setSex(sex);
        op = new OperatePhone();

        if (op.getPhones().contains(p)) {
            System.out.println("该用户已存在");
        } else {
            op.addPhone(p);
            System.out.println("添加用户通讯信息成功");
        }
    }

    @Override
    public void del() throws SQLException {
        System.out.println("删除用户通讯信息");
        System.out.println("1-按用户姓名删除");
        System.out.println("2-按用户号码删除");
        System.out.println("请输入您的选择：");
        int num = scan.nextInt();
        System.out.println("输入将要删除的姓名或号码：");
        String value = scan.next();
        op = new OperatePhone();
        p = op.getPhone(getString(num), value);
        if (p != null) {
            System.out.println("姓名\t" + "电话号码\t" + "性别");
            System.out.println(p.toString());
            op.delPhone(getString(num), value);
            System.out.println("用户删除成功");
        } else {
            System.out.println("用户不存在");
        }
    }

    @Override
    public void update() throws SQLException {
        op = new OperatePhone();
        System.out.println("更新用户通讯信息");
        System.out.println("请输入要修改的用户的姓名：");
        String name = scan.next();
        p = op.getPhone("name", name);
        if (p != null) {
            System.out.println("姓名\t" + "电话号码\t" + "性别");
            System.out.println(p.toString());
            System.out.println("请输入修改后的电话号码：");
            String value = scan.next();
            op.updatePhone(value, name);
            p = op.getPhone("name", name);
            System.out.println("用户修改成功");
            System.out.println("姓名\t" + "电话号码\t" + "性别");
            System.out.println(p.toString());
        } else {
            System.out.println("用户不存在");
        }
    }

    @Override
    public void get() throws SQLException {
        op = new OperatePhone();
        p = new Phone();
        System.out.println("查询用户通讯信息");
        System.out.println("1-按用户姓名查询");
        System.out.println("2-按用户号码查询");
        System.out.println("请输入您的选择：");
        int num = scan.nextInt();
        System.out.println("输入将要查询的姓名或号码：");
        String value = scan.next();
        p = op.getPhone(getString(num), value);
        if (p != null) {
            System.out.println("姓名\t" + "电话号码\t" + "性别");
            System.out.println(p.toString());
        } else {
            System.out.println("用户不存在");
        }

    }

    @Override
    public void getAll() throws SQLException {
        op = new OperatePhone();
        System.out.println("输出所有用户通讯信息");

        list = new ArrayList<Phone>();
        list = op.getPhones();
        System.out.println("姓名\t" + "电话号码\t" + "性别");
        for (Phone p : list) {
            System.out.println(p.toString());
        }

    }

}
