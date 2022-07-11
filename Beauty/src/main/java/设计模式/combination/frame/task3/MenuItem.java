package 设计模式.combination.frame.task3;

/**
 * 简单类
 */
public class MenuItem implements MenuComponent {

  private String name;

  /*构造函数*/
  public MenuItem(String name) {
   this.name = name;
  }

  @Override
  public void operation() {
   System.out.println(this.name);
  }

  public String getName() {
   return name;
  }
}