package cn.fan.utils;

import java.util.Arrays;

/**
 * 猜字符游戏的工具类
 */
public abstract class GuessingUtils {

    /*
     * 用于比较所猜字符是否正确
     * result[0] 代表字符位置正确个数
     * result[1] 代表字符正确个数
     */
    public static int[] compare(String hide_str,String guess_str){
        char[] hide_char = hide_str.toCharArray();
        char[] guess_char = guess_str.toCharArray();
        int [] result = {0,0};

        //循环判断字符是否相同
        for (int i = 0; i <hide_char.length ; i++) {
            for (int j = 0; j < guess_char.length; j++) {
                if (hide_char[i] == guess_char[j]) {
                    //该字符正确
                    result[1]++;
                    if(i==j){
                        //该字符位置也正确
                        result[0]++;
                    }
                    break;
                }
            }
        }
        return result;
    }

    /*
     * 用于随机生成字符串
     */
    public static String generateStr(int levle){
        //从String数组中挑选字符
        String strs[] ={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P",
                "Q","R","S","T","U","V","W","X","Y","Z"};
        //与String数组对应,用于判断字符是否已用过
        boolean flag[] = new boolean[strs.length];

        StringBuilder hide_str = new StringBuilder("");
        //根据游戏等级,确定生成字符串长度
        for (int i = 0; i < levle; i++) {
            int rand = (int)(Math.random()*26);
            if (flag[rand]==true){
                //字符重复,重新生成随机数
                i--;
            } else {
                //字符不重复,添加到生成的字符串中
                hide_str.append(strs[rand]);
                flag[rand]=true;
            }
        }
        return hide_str.toString();
    }
}
