package 设计模式.strategy.paystrategy;

import 设计模式.strategy.PayStrategy;

public class CardPayStrategy implements PayStrategy {
    @Override
    public String selectPayWay(Integer paycode) {
        //do something
        return "银行卡支付成功";
    }
}