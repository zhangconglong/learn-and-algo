package 设计模式.strategy.paystrategy;

import 设计模式.strategy.PayStrategy;

public class PointCouponPayStrategy implements PayStrategy {

    @Override
    public String selectPayWay(Integer paycode) {
        //do something
        return "点券支付成功";
    }
}