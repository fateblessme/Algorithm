package com.strange;

import java.lang.reflect.Field;

/**
 * 交换两个Integer类型的值
 *
 * @author YangBo
 * @date 2018/10/27
 * <p>
 * desc：
 * 写一个方法，实现互换Integer值，不易。
 * Integer是构造函数，被final修饰，value没提供任何set方法，反射解决问题
 */
public class ChangeInteger {
    public static void main(String[] args) {
        Integer a = 10;
        Integer b = 20;
        swap(a, b);
        System.out.println(" a : " + a);
        System.out.println(" b : " + b);

    }

    private static void swap(Integer a, Integer b) {
        int temp = a.intValue();
        try {
            Field value = Integer.class.getDeclaredField("value");
            value.setAccessible(true);
            value.set(a, b);
            //value.set 会将Integer缓存值改变，new Integer 不需要调用缓存
            value.set(b,new Integer(temp));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
