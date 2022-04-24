package java工具类学习.math;

import java.text.DecimalFormat;

/**
 * TestMath
 * author: luyi
 * time: 2022/3/26 15:53
 */
public class TestMath {
    public static void main(String[] args) {
        int i=4;
        int j=14;
        float result =(float)i/j;
        System.out.println(result);

        DecimalFormat format = (DecimalFormat) DecimalFormat.getInstance();
        format.applyPattern("##.###");
        //格式化：保留
        String format1 = format.format(result);
        System.out.println(format1);
        float v = Float.parseFloat(format.format(result));
//        System.out.println(v);
        String fr= v *100 + "";
//        System.out.println("fr："+fr);

        if(fr.length()>4){
            fr=fr.substring(0,4);
        }
        System.out.println(fr+"%");
    }
}
