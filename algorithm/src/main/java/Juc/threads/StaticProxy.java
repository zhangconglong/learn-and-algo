package Juc.threads;

public class StaticProxy {
    public static void main(String[] args) {
        WeddingCompany company = new WeddingCompany(new You());
        company.HappyMarry();
    }
}

interface Marry{ //真实角色和代理角色都实现同一个接口
    void HappyMarry();
}

class You implements Marry{ //真实角色

    @Override
    public void HappyMarry() {
        System.out.println("张从龙结婚");
    }
}

class WeddingCompany implements Marry{ //代理角色

    private final Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }

    //让婚庆公司进行处理
    private void after() {
        System.out.println("结婚之后，收钱");
    }

    private void before() {
        System.out.println("结婚之前，布置");
    }
}