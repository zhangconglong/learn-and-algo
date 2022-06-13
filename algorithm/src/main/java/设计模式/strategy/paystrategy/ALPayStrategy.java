package 设计模式.strategy.paystrategy;

import 设计模式.strategy.PayStrategy;

public class ALPayStrategy implements PayStrategy {

    @Override
    public String selectPayWay(Integer paycode) {
        //do something
        return "支付宝支付成功";
    }
}