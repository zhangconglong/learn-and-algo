package 设计模式.combination.frame;

/**
 * 菜单组件，不管是菜单还是菜单项，都应该继承自该类
 */
public abstract class MenuComponent {

    protected String name; //菜单组件的名称
    protected int level; //菜单的层级

    //添加子菜单
    public void add (MenuComponent menuComponent){
        throw new UnsupportedOperationException();
    }

    //移出子菜单
    public void remove(MenuComponent  menuComponent){
        throw new UnsupportedOperationException();
    }

    //获取指定的子菜单
    public MenuComponent getChild(int index){
        throw new UnsupportedOperationException();
    }

    //获取菜单或者菜单项的名称
    public String getName(){
        return name;
    }

    //打印菜单的名称(包含子菜单和子菜单项)
    public abstract void printMenu();
}