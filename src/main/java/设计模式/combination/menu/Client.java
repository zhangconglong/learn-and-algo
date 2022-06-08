package 设计模式.combination.menu;

/**
 * @Version: v1.0
 * @ClassName: Client
 * @Description: 测试组合模式的代码
 * @Author: zhangconglong on 2021/11/9
 */
public class Client {

    public static void main(String[] args) {
        //创建菜单树
        //一级菜单
        MenuComponent menu = new Menu("系统管理", 1);

        //二级菜单
        MenuComponent menu1 = new Menu("菜单管理", 2);
        MenuComponent menu2 = new Menu("权限管理", 2);
        MenuComponent menu3 = new Menu("角色管理", 2);


        menu1.add(new MenuItem("展开菜单", 3));
        menu1.add(new MenuItem("页面访问", 3));
        menu1.add(new MenuItem("编辑菜单", 3));

        menu.add(menu1);
        menu.add(menu2);

        menu.printMenu();
    }
}