package exercise;

import static java.lang.Math.max;

/** 2021.02.22 codility : BinaryGap
 *  더 쉽고 간결하게 풀 수 있는 방법 찾기
 *  소요시간 : 30분
 */
class Iterations {
    public static int solution(int N) {
        // write your code in Java SE 8
        int maxLength = -1;
        int count = 1;
        int flag = 0;
        String temp = Integer.toBinaryString(N);
        System.out.println(temp);

        for (int i = 0; i < temp.length()-1; i++) {
            if(temp.charAt(i) == temp.charAt(i+1)){
                System.out.println("count "+i+" "+count);
                count++;
            }else{
                flag++;
                maxLength = max(maxLength, count);
                count = 1;
            }
        }

        if(flag >= 2){
            return maxLength;
        }else{
            return 0;
        }



    }

    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
        int result = solution(20);
        System.out.println(result);
    }
}
