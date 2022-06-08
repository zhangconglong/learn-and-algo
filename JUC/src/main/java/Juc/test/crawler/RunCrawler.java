package Juc.test.crawler;

/**
 * RunCrawler
 * author: luyi
 * time: 2022/3/14 21:59
 */
class RunCrawler extends Thread{

    String tag ="<a href=\"http://";
    String url="https://www.sina.com.cn/";
    static int i=0;
    static String [] urlconntion=new String[100];

    public void run() {

        Crawler crawler = new Crawler(url, tag, urlconntion);
        String s2 = crawler.find();

        while(urlconntion[90]==null){
            //线程锁，防止并发导致的线程安全
            synchronized(this)
            {
                if(s2==null){
                    crawler=new Crawler(url, tag,urlconntion);
                    s2=crawler.find();
                }
                System.out.println(s2);

                crawler = new Crawler(s2, tag,urlconntion);

                urlconntion[i++]=s2;
                s2 = crawler.find();
            }
        }       
    }   
}
