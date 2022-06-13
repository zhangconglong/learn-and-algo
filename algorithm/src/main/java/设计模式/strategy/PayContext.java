package 设计模式.strategy;

public class PayContext {

    private PayStrategy payStrategy;

    public String selectPayWay(Integer payCode){
        //使用策略工程 创建策略
        payStrategy =  StrategyFactory.getInstance().create(payCode);
        return payStrategy.selectPayWay(payCode);
    }

    public PayStrategy getPayStrategy() {

        return payStrategy;
    }

    public void setPayStrategy(PayStrategy payStrategy) {
        this.payStrategy = payStrategy;
    }
}