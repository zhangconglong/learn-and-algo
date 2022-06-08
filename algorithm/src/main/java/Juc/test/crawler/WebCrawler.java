package Juc.test.crawler;

public class WebCrawler{

    public static void main(String[] args){
        //创建三个爬虫运行类
        RunCrawler t1=new RunCrawler();
        RunCrawler t2=new RunCrawler();
        RunCrawler t3=new RunCrawler();

        t1.start();
        t2.start();
        t3.start();     
    }
}
