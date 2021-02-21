package math;

import java.util.Scanner;

/** 2021.02.21 백준 10430 : 나머지
 *  1. 그냥 넘나 쉬운문제
 *  소요시간 : 5분?
 */
public class sw_10430 {

    static int A, B, C;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();

        System.out.println((A+B)%C);
        System.out.println(((A%C) + (B%C))%C);
        System.out.println((A*B)%C);
        System.out.println(((A%C)*(B%C))%C);

    }
}
