//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.*;
// mrt coding test 211015
//public class Main {
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String input = br.readLine();
//
//        Map<Character, Integer> charMap = new HashMap<>();
//        charMap.put('(', 0);
//        charMap.put('{', 1);
//        charMap.put('[', 2);
//
//        charMap.put(')', 0);
//        charMap.put('}', 1);
//        charMap.put(']', 2);
//
//        boolean result = true;
//
//        Stack<Character> stack = new Stack<>();
//        for(int i = 0; i < input.length(); i ++) {
//            char currentChar = input.charAt(i);
//
//            if(currentChar == '(' || currentChar == '{' || currentChar == '[') {
//                stack.push(currentChar);
//            } else {
//                if(stack.isEmpty()) {
//                    result = false;
//                    break;
//                }
//
//                int openCharInt = charMap.get(stack.pop());
//                int closeCharInt = charMap.get(currentChar);
//                if(openCharInt != closeCharInt) {
//                    result = false;
//                    break;
//                }
//            }
//        }
//
//
//        if(result) {
//            System.out.println("True");
//        } else {
//            System.out.println("False");
//        }
//    }
//}
//
//import java.util.*;
//public class test1 {
//    static int N = 10;
//    static String arr[] = new String[]{
//            "SMS 010-1234-5678",
//            "CALL 010-1234-5678",
//            "CALL 010-1234-5678",
//            "SMS 010-1111-1111",
//            "SMS 010-5555-5555",
//            "CALL 010-5555-5555",
//            "CALL 010-5555-5555",
//            "CALL 010-4444-4444",
//            "SMS 010-5555-5555",
//            "CALL 010-5555-5555"
//    };
//    public static void main(String args[]){
//        String str = arr[0];
//        int cnt = 1;
//        ArrayList<String> list = new ArrayList<String>();
//        for(int i=1; i<N; i++){
//            if(str.equals(arr[i])){
//                cnt++;
//            }else{
//                str = cnt >= 2? str + " (" + cnt + ")": str;
//                list.add(str);
//                str = arr[i];
//                cnt = 1;
//            }
//        }
//        str = cnt >= 2? str + " (" + cnt + ")": str;
//        list.add(str);
//
//        System.out.println(list.size());
//        for(int i=0; i<list.size(); i++){
//            System.out.println(list.get(i));
//        }
//    }
//}