package Test_2;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String[] str = {"abc", "bca", "dbe"};
		//String[] str = {"zzzz", "ferz", "zdsr", "fgtd"};
		//String[] str = {"gr", "sd", "rg"};
		String[] str = {"aaaz", "bbbb", "cccc", "dddd", "eeez", "fffz", "gggz", "hhhz", "iiiz", "jjjz", "kkkz", "lllz", "mmmz", "nnnz", "oooz", "pppz", "qqqz", "rrrz", "sssz", "tttz", "uuuz", "vvvz", "wwwz", "xxxz", "yyyz", "zzzz"};
		int[] result = solution(str);
		
		for(int i=0; i<result.length; i++)
			System.out.print(result[i]+" ");
	}

	public static int[] solution(String[] S) {
        // write your code in Java SE 11
        int len = S[0].length();
        
        for(int i=0; i<len; i++){
            int check[] = new int[27];
            for(int j=0; j<S.length; j++){
                if(check[S[j].charAt(i) - 96] != 0){
                    int[] result = {check[S[j].charAt(i) - 96]-1, j, i};
                    return result;
                }
                check[S[j].charAt(i) - 96] = j+1;
            }
        }
        int[] result = new int[0];
        return result;
    }
}
