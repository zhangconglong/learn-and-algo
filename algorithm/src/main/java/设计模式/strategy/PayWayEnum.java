package 设计模式.strategy;

public enum PayWayEnum {

    /**微信支付*/
    WEICHAT_PAY("微信支付",100),
    /**支付宝支付*/
    AL_PAY("支付宝支付",101),
    /**银行卡支付*/
    CARD_PAY("银行卡支付",102),
    /**点券支付*/
    PONIT_COUPON_PAY("点券支付",103);

    private String msg;
    private Integer code;

    PayWayEnum(String msg, Integer code) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public Integer getCode() {
        return code;
    }
}