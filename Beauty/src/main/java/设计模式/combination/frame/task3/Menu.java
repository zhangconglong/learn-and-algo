package 设计模式.combination.frame.task3;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合类
 */
public class Menu implements MenuComponent {

    private String name;
    private List<MenuComponent> menuComponents = new ArrayList<>();


    public Menu(String name) {
        this.name = name;
    }

    //添加控件
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    //移除组件
    public void remove (MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    public MenuComponent get(int index) {
        return menuComponents.get(index);
    }

    @Override
    public void operation() {
        System.out.println(this.name);
        for (MenuComponent menuComponent : menuComponents) {
            menuComponent.operation();
        }
    }
}