package 设计模式.strategy;

import 设计模式.strategy.paystrategy.ALPayStrategy;
import 设计模式.strategy.paystrategy.CardPayStrategy;
import 设计模式.strategy.paystrategy.PointCouponPayStrategy;
import 设计模式.strategy.paystrategy.WeChatPayStrategy;

import java.util.HashMap;
import java.util.Map;

public class StrategyFactory {

    private static StrategyFactory factory = new StrategyFactory();

    private StrategyFactory(){}

    //缓存 工厂的成品对象
    private static Map<Integer, Object> strategyMap = new HashMap<>(16);

    static {
        strategyMap.put(PayWayEnum.AL_PAY.getCode(), new ALPayStrategy());
        strategyMap.put(PayWayEnum.WEICHAT_PAY.getCode(), new WeChatPayStrategy());
        strategyMap.put(PayWayEnum.CARD_PAY.getCode(),new CardPayStrategy());
        strategyMap.put(PayWayEnum.PONIT_COUPON_PAY.getCode(),new PointCouponPayStrategy());
    }

    public PayStrategy create(Integer payCode){
        return (PayStrategy) strategyMap.get(payCode);
    }

    public static StrategyFactory getInstance(){
        return factory;
    }
}