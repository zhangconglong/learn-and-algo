package 设计模式.bridge.change;//package com.model.bridge.change;
//
///**
// * @Version: v1.0
// * @ClassName: Client
// * @Description：
// * @Author: zhangconglong on 2021/11/9
// */
//public class Client extends File {
//    public static void main(String[] args) {
//        //从MYSQL转化到pdf
//        File file  = new Pdf(new Mysql());
//        file.info();
//        //从Oracle数据库转化
//        file = new Txt(new Oracle());
//        file.info();
//    }
//}