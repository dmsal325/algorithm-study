package exercise;

/** 2021.02.22 codility : CyclicRotation
 *  규칙을 찾았다면 쉽게 풀 수 있었던 문제
 *  소요시간 : 30분
 */
public class array1 {

    public static int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        int index;
        int[] result = new int[A.length];
        for(int i=0;i<A.length;i++){
            index = (i+K)%A.length;
            result[index] = A[i];
        }
        return result;



//        int rotation = K % A.length; //이 만큼만 돌면됨
//
//        if(rotation==0){
//            return A;
//        }else{
//            for(int i=0; i<rotation; i++){
//                int temp = A[A.length-1];
//                for (int k=A.length-1; k>=1; k--){
//                    A[k] = A[k-1];
//                }
//                A[0] = temp;
//            }
//
//            return A;
//        }


    }

    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
        int[] arr = {1,2,3,4};
        int K = 5;
        int[] result = solution(arr, K);

        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }

    }

}
