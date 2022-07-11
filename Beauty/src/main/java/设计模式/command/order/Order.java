package 设计模式.command.order;

import java.util.HashMap;
import java.util.Map;

/**
 * @version: v1.0
 * @className: Order
 * @description：订单类
 * @author: zhangconglong on 2021/11/20
 */
public class Order {
    //餐桌号码
    private int diningTable;
    //所下的餐品及份数
    public Map<String, Integer> foodDir = new HashMap<>();

    public int getDiningTable() {
        return diningTable;
    }

    public void setDiningTable(int diningTable) {
        this.diningTable = diningTable;
    }

    public Map<String, Integer> getFood() {
        return foodDir;
    }

    public void setFood(String foodName, int num) {
        foodDir.put(foodName, num);
    }
}