package 设计模式.combination.menu;

/**
 * 菜单项类：叶子节点
 * @author: luyi
 * time: 2022/6/8 16:08
 */
public class MenuItem extends MenuComponent{

    //构造方法
    public MenuItem(String name, int level){
        this.name = name;
        this.level = level;
    }

    @Override
    public void printMenu() {
        for (int i = 0; i < level; i++) {
            System.out.print("-");
        }
        //打印菜单项名称
        System.out.println(name);
    }
}