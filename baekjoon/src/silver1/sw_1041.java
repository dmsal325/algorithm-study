package silver1;

import java.util.Scanner;
import static java.lang.Math.*;

/** 2021.02.21 백준 1041 : 주사위
 *  1. N의 3승개로 주사위를 만들었을 때의 모양을 상상해야함 ( 역시나 문제해석 하기가 넘 어려움 )
 *  2. 1면이 보일때, 2면이 보일때, 3면이 보일때의 최솟값 구하기
 *     (단, 마주보는 면의 제외)
 *  3. 보이는 면수에 따라 출력되는 갯수를 수식화해서 값 구하기
 *     - 3면이 보이는 주사위는 4개
 *     - 2면이 보이는 주사위는 4(N-1)(N-2) = 8N-12개
 *     - 1면이 보이는 주사위는 4N(N-2)+(N-2)(N-2) = 5*N*N-16N+12
 *  4. 주의점
 *      - max값, min값 초기화 안해서 error
 *      - 역시나 자료형 int가 아닌 long으로 해줘야 정답
 *      - N값 1일 때의 처리
 *
 *  소요시간 : 16시 5분 ~ 16시 55분(약 1시간)
 */
public class sw_1041 {

    static int N, diceMax = 0, diceMin1 = 51, diceMin2 = 101, diceMin3 = 151;
    static int[] dice = new int[6];
    static long answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        for(int i = 0; i<6; i++){
            dice[i] = sc.nextInt();
            answer += dice[i];
            diceMax = max(diceMax, dice[i]);
        }

        if(N==1){
            answer -= diceMax;
        }else{
            for(int i=0; i<6; i++){
                diceMin1 = min(diceMin1, dice[i]); // 주사위 한개에서의 최솟값
                for(int j=i+1; j<6;j++){
                    //마주보는 변이 아닐때의 최솟값 구하기
                    if(i+j == 5){
                        continue;
                    }
                    diceMin2 = min(diceMin2, dice[i]+dice[j]); // 주사위 두개에서의 최솟값

                    for(int k=j+1; k<6; k++){
                        //마주보는 변이 아닐때의 최솟값 구하기
                        if(j+k == 5 || k+i==5){
                            continue;
                        }
                        diceMin3 = min(diceMin3, dice[i]+dice[j]+dice[k]); // 주사위 세개에서의 최솟값
                    }
                }
            }

            answer = 0;
            answer += ((5*(long)N*N) - (16*N) + 12) * diceMin1 ;
            answer += ((8*N) - 12) * diceMin2 ;
            answer += 4 * diceMin3 ;
        }

        System.out.println(answer);
    }

}
