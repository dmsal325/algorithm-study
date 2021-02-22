package exercise;

import java.util.*;

/** 2021.02.22 codility : OddOccurrencesInArray
 *  set사용방법 익히기
 *  소요시간 : 20분
 */
public class array2 {
    public static int solution(int[] A) {

        HashSet<Integer> set = new HashSet<>();
        for (int i=0; i<A.length;i++){
            if(set.contains(A[i])){
                set.remove(A[i]);
            }else {
                set.add(A[i]);
            }
        }
        return set.iterator().next();


//        HashMap<Integer,Integer> hm = new HashMap<>();
//
//        for (int i=0; i<A.length;i++){ hm.put(A[i], hm.getOrDefault(A[i], 0)+1); }
//
//        List<Integer> keySetList = new ArrayList<>(hm.keySet());
//        Collections.sort(keySetList, (o1, o2) -> (hm.get(o1).compareTo(hm.get(o2))));
//
//        return keySetList.get(0);
    }

    public static void main(String[] args){
        int[] A = {9,3,9,3,9,7,9};
        System.out.println(solution(A));
    }
}
