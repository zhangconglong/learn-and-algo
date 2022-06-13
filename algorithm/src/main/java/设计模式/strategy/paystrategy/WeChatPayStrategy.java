package 设计模式.strategy.paystrategy;

import 设计模式.strategy.PayStrategy;

public class WeChatPayStrategy implements PayStrategy {

    @Override
    public String selectPayWay(Integer paycode) {
        //do something
        return "微信支付成功";
    }

}