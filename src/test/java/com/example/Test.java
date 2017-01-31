package com.example;

import com.game.impl.Gobang;

/**
 * Created by hang on 17/1/23.
 */
public class Test {

    public int sum(int x, int y) {
        return x + y;
    }

    public boolean haha(float x) {
        return x > 0;
    }

    public boolean plus(float x,float y, float z) {
//        if (x + y == z ) return true; else return false;
        return x + y == z;

    }

    public static void main(String[] args) {
        Test gobang = new Test();

        int z = gobang.sum(1,1);
        System.out.println(z);
        boolean x = gobang.haha(-666);
        System.out.println(x);
        if (x == true) System.out.println("Yeah"); else System.out.println("OH..");

        System.out.println();
    }
}
