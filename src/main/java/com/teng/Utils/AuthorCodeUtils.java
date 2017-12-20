package com.teng.Utils;

import java.util.Random;

public class AuthorCodeUtils {

        public static int getAuthorCode(){
                Random r = new Random();
                int num = r.nextInt(999999) + 100000;
                if (num > 999999){
                        return 999999;
                }
                return num;
        }
}
