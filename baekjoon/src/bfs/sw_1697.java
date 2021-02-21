package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/** 2021.02.21 백준 1697 : 숨바꼭질
 *  1. 필요한 자료형 선정
 *      : value, depth 값을 가진 Pair 클래스, Pair 자료형을 가진 순회할 큐, 방문여부를 사진 불린 배열
 *  2. 처음, 큐에 언니의 위치을 넣고 bfs 함수 호출
 *  3. 맨 앞의 값을 꺼내면서 갈 수 있는 곳을 넣어주기 (깊이와 함께)
 *      이때, 큐에 넣어줄 값이 유효한 값인지 체크
 *      또,  넣어준 값은 visited 배열에 true로 세팅 (중복체크를 위함)
 *  4. 꺼낸 값이 동생의 위치라면 깊이를 반환
 *      아니라면 큐에 담긴 값이 없어질때까지 진행
 *
 *  소요시간 : 20분
 */

public class sw_1697 {

    static Queue<Pair> q;
    static boolean[] visited;
    static int N,K;
    static int value, depth, result;

    public static void main(String[] args){
        q = new LinkedList<>();
        visited = new boolean[100001];

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        q.add(new Pair(N,0));
        visited[N] = true;
        bfs();

        System.out.println(result);

    }

    public static boolean valid(int n){
        if(n<0 || n> 100000 || visited[n]){
            return false;
        }
        return true;
    }

    public static void bfs(){

        while (!q.isEmpty()){
            value = q.peek().getValue();
            depth = q.peek().getDepth();
            q.remove();

            if(value == K){
                result = depth;
                break;
            }

            if(valid(value-1)){
                visited[value-1] = true;
                q.add(new Pair(value-1, depth+1));
            }

            if(valid(value+1)){
                visited[value+1] = true;
                q.add(new Pair(value+1, depth+1));
            }

            if(valid(value*2)){
                visited[value*2] = true;
                q.add(new Pair(value*2, depth+1));
            }



        }

    }

}

class Pair {
    int value;
    int depth;

    public Pair(int value, int depth){
        this.value = value;
        this.depth = depth;
    }
    public int getValue(){
        return value;
    }
    public int getDepth(){
        return depth;
    }
}
