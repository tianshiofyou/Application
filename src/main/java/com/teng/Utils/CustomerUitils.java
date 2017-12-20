package com.teng.Utils;

import java.util.UUID;

public class CustomerUitils {

        /**
         * 劣势：ID有128 bits,占用的空间较大，需要存成字符串类型，索引效率极低。
         * 生成的ID中没有带Timestamp，无法保证趋势递增
         * @return CustomerId
         */
        public static String getCustomerId(){
                return UUID.randomUUID().toString();
        }
}
