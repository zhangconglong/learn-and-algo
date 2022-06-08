package Juc.test.crawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

class Crawler {

    String url;
    String prefix;
    //爬去过的url地址集合
    String[] urlConntion;

    //构造函数
    Crawler(String url, String prefix, String[] urlConntion){
        this.url=url;
        this.prefix=prefix;
        this.urlConntion = urlConntion;
    }

    //根据类的url开始爬取新的url实现循环爬取
    public String find(){
        URL url2;
        URLConnection con;
        BufferedReader bfr=null;
        String rpurl;

        try {
            url2=new URL(url);
            con=url2.openConnection();
            //模拟成用户，访问部分网站，部分网站会拒绝爬虫爬取
            con.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            InputStream is=con.getInputStream();
            bfr=new BufferedReader(new InputStreamReader(is));
            String s;
            while((s=bfr.readLine())!=null){
                if(s.contains(prefix))
                     {
                        rpurl=getUrl(s);
                        if(urlRepetition(rpurl)!=-1){
                            return rpurl;
                        }
                     }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                assert bfr != null; //断言
                bfr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;

    }

    //判断url是否被爬去过 (被爬去可返回-1，没有则返回1)
    public int urlRepetition(String rpurl){

        int i=0;
        while(urlConntion[i]!=null){
            if(urlConntion[i++].equals(rpurl)){
                return -1;
            }
        }
        return 1;
    }

    //从爬去过的源码中截取url地址；
    public String getUrl(String s){
        int index1=s.indexOf(prefix);
        s=s.substring(index1+9);
        int index2=s.indexOf("\"");
        s=s.substring(0,index2);
        return s;
    }
}
