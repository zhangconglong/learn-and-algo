package 面试题.Y2022春招.奇虎360;

public class Order01 {

    public static String unique_string(String s) {
        String aa = new String();//存储结果

        char[] chars = s.toCharArray();
        int j;
        Boolean flag;

        for (int i = 0; i < chars.length; i++) {
            flag = true;

            for (j = 0; j < aa.length(); j++) {
                if (chars[i] == aa.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {//一开始，加上第一个char字符
                aa += chars[i];
            }
        }

        return aa;
    }

    public static void main(String[] args) {
        System.out.println(unique_string("hello, xiaomi"));
    }
}
