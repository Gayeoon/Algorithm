package Test1;

public class Main {

	public static void main(String[] args) {
		int n = 6; // ������ ũ��
		String text = "hi bye"; // ��� ����
		int time = 6; // ���� �ð�
		
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
