package com.bjst.dgt.util;

import java.util.Random;

public class CodeUtils {
    /**
     * 随机获取6位数
     * @return
     */
    public static String getNumber4FromRandom(){
        Random r = new Random();
        int xx = r.nextInt(1000000);
        while(xx<100000){
            xx = r.nextInt(1000000);
        }
        return String.valueOf(xx);
    }
}
