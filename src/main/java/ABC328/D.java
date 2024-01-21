package src.main.java.ABC328;
import java.util.*;

public class D {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] S = scanner.next().toCharArray();
        int N = S.length;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            stack.push(S[i]);
            if(stack.size() < 3){
                continue;
            }
            char chr1 = stack.elementAt(stack.size()-1);
            char chr2 = stack.elementAt(stack.size()-2);
            char chr3 = stack.elementAt(stack.size()-3);
            if(chr1 == 'C'  && chr2 == 'B' && chr3 == 'A'){
                stack.pop();
                stack.pop();
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            sb.append(stack.elementAt(i));
        }
        System.out.println(sb.toString());
    }
    public static class AddressManager{
        private int nextAddress;
        private int previousAddress;
        public AddressManager(int nextAddress, int previousAddress){
            this.nextAddress = nextAddress;
            this.previousAddress = previousAddress;
        }
        public int getNextAddress(){
            return this.nextAddress;
        }
        public int getPreviousAddress(){
            return this.previousAddress;
        }
        public void setNextAddress(int nextAddress){
            this.nextAddress = nextAddress;
        }
        public void setPreviousAddress(int previousAddress){
            this.previousAddress = previousAddress;
        }

    }
}
