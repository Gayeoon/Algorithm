package Tuple;
import java.util.Stack;
import java.util.HashMap;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
        int[] answer;
        HashMap<String, Integer> hash = new HashMap<>();
        Stack<String> stack = new Stack<>();
        int cnt = 0;
        boolean flag = false;
        boolean next = false;
        for(int i=0; i<s.length(); i++){
            char tchar = s.charAt(i);
            if(tchar == ',') {
                if(flag) cnt++;
                next = false;
                continue;
            }
            else if(tchar == '{'){
                flag = true;
                stack.push(tchar+"");
            }            
            else if(tchar == '}'){
                flag = false;
                while(true){
                    if(stack.peek().equals("{")){
                        stack.pop();
                        break;
                    }else{                        
                        if(hash.containsKey(stack.peek())){
                            if(hash.get(stack.peek()) > cnt)
                                hash.put(stack.peek(), cnt);
                        }else {
                        	 hash.put(stack.peek(), cnt);
                        }
                        
                        stack.pop();
                    }
                }
                cnt = 0;
            }
            else{
                if(next){
                    String num = stack.pop();
                    num += tchar;
                    stack.push(num);
                }else{
                    stack.push(tchar+"");
                    next = true;
                }
            }
        }
        List<String> keySetList = new ArrayList<>(hash.keySet());		
        Collections.sort(keySetList, (o1, o2) -> (hash.get(o1).compareTo(hash.get(o2))));
        answer = new int[keySetList.size()];
        int idx = 0;
        for(String key : keySetList) {
            answer[idx] = Integer.parseInt(key);
            System.out.print(answer[idx]+" ");
            idx++;
        }

        System.out.println(answer);
    }
}