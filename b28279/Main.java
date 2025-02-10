package b28279;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int value=-1;
        Node next;
        Node prev;

    }

    static class Deque{
        int size = 0;
        Node head = new Node();
        Node last;
        Node start;
        public void addFirst(int n){
            size ++;
            Node newNode = new Node();
            newNode.value = n;
            newNode.prev = head;
            if(head.next != null){
                Node nextNode = head.next;
                head.next = newNode;
                newNode.next = nextNode;
                nextNode.prev = newNode;
            }else {
                head.next = newNode;
                last = head.next;
            }
            start = head.next;

        }

        public void addLast(int n){
            size ++;
            Node newNode = new Node();
            newNode.value = n;

            if(last != null){
                last.next = newNode;
                newNode.prev = last; 
            }else { // null이면
                head.next = newNode;
                start = head.next;
                newNode.prev = head;
            }
            last = newNode;
        }

        public int pollFirst(){
            if(start == null) {
                return -1;
            }
            size --;

            Node poll = start;
            head.next = start.next;
            int v = poll.value;
            start = head.next;
            if(start != null){
                start.prev = head;
            }else {
                last = null;
            }
            
            return v;
        }

        public int pollLast(){
            if(last == null){
                return -1;
            }
            size --;
            Node poll = last;
            int value = poll.value;
            if(poll.prev == head){
                last = null;
                start = null;
                head.next = null;
            }else {
                last = poll.prev;
                last.next = null;
            }
            
            return value;
        }


        public int peekFist(){
            if(start == null){
                return -1;
            }
            return start.value;
        }

        public int peekLast(){
            if(last == null){
                return -1;
            }
            return last.value;
        }
    }
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque dq = new Deque();
        for(int i = 0; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());

            if(cmd == 1){
                int tmp = Integer.parseInt(st.nextToken());
                dq.addFirst(tmp);
            }else if(cmd == 2){
                int tmp = Integer.parseInt(st.nextToken());
                dq.addLast(tmp);
            }else if(cmd == 3){
                sb.append(dq.pollFirst());
            }else if(cmd == 4){
                sb.append(dq.pollLast());
            }else if(cmd == 5){
                sb.append(dq.size);
            }else if(cmd == 6){
                sb.append(dq.size == 0 ? 1 : 0);
            }else if(cmd == 7){
                sb.append(dq.peekFist());
            }else {
                sb.append(dq.peekLast());
            }
            
            if(!(cmd == 1 || cmd == 2)){
                sb.append("\n");
            }
        }
        System.out.print(sb.toString());
    }
}
