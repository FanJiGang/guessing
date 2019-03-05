package cn.fan.main;

import cn.fan.utils.GuessingUtils;

import java.util.Scanner;

/**
 * 猜字符主运行程序
 */
public class Guessing {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("*************游戏开始*************");
        //生成指定范围数字
        int level =0;
        while (true){
            System.out.println("请输入游戏等级level(3,6,9)");
            level=scan.nextInt();
            if(level==3 || level==6 || level==9){
                break;
            }
        }
        String hide_str = GuessingUtils.generateStr(level);
        //玩家输入数字
        while (true) {
            System.out.println("请输入所猜字符:<输入EXIT退出游戏>");
            String guess_str = scan.next();
            //提前输入指令退出游戏
            if("EXIT".equalsIgnoreCase(guess_str)){
                System.out.println("欢迎下次再来挑战!");
                return;
            }
            int[] result = GuessingUtils.compare(hide_str, guess_str.toUpperCase());
            if(result[0] == level){
                //全部猜中,游戏结束
                break;
            }else{
                //未全部猜中,给予提示
                System.out.println("猜对了 "+result[1]+" 个,其中位置正确的有 "+result[0]+" 个");
            }
        }
        //游戏结束
        System.out.println("恭喜,猜对了!");

    }
}
