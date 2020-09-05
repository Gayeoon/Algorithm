package Test1;

public class Main {

	public static void main(String[] args) {
		int n = 6; // 전광판 크기
		String text = "hi bye"; // 출력 문자
		int time = 6; // 지난 시간
		
		for(int i=0; i<n; i++)
			text = "_"+ text;
		
		int num = time % text.length();
		int cnt = 0;
		String result = "";
		while(true) {
			if(cnt >= n)
				break;
			if(text.charAt(num) == ' ')
				result += "_";
			else
				result += text.charAt(num);
			
			num++;
			
			if(num >= text.length())
				num = 0;
			cnt++;
		}
		
		System.out.println(result);
	}

}
