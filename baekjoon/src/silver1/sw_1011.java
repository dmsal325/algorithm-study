package silver1;

import java.util.Scanner;

/** 2021.02.21 백준 1011 : Fly me to the Alpha Centauri
 *  1. 간격과 출력값 사이의 규칙 찾기
 *  2. 제곱근마다 규칙이 있다는 것, 중간값사이에도 규칙이 존재 -> 코드화
 *  3. 입력받는 자료형 또한 중요 ( int형은 2의 31승 보다 작으므로 double형으로 표현해야함 )
 *  소요시간 : 1시간
 */

public class sw_1011 {
    static int T;
    static double[][] array;
    static int count;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //입력갯수
        T = sc.nextInt();
        array = new double[T][2];

        for(int i=0; i<T; i++){
            count = 0;
            array[i][0] = sc.nextDouble();
            array[i][1] = sc.nextDouble();

            double distance = array[i][1] - array[i][0];
            int max = (int) Math.sqrt(distance);

            if(max*max == distance){ // 제곱근 값일때
                count = max * 2 - 1;
            } else if(distance > max*max && distance<= max*max+max){ // 중간값보다 작을 때
                count = max * 2 ;
            } else { // 중간값보다 클 때
                count = max * 2 + 1;
            }

            // 답출력
            System.out.println(count);
        }
    }
}
