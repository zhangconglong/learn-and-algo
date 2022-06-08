package 设计模式.combination.frame.task3;

/**
 * 应用与测试
 * 区别与不同：之前文件夹可以
 */
public class Test {

    public static void main(String[] args) {

        Menu menu = new Menu("目录1");

        MenuItem menuItem1 = new MenuItem("文件1");
        MenuItem menuItem2 = new MenuItem("文件2");
        MenuItem menuItem3 = new MenuItem("文件3");

        menu.add(menuItem1);
        menu.add(menuItem2);
        menu.add(menuItem3);

        menu.operation();
    }
}