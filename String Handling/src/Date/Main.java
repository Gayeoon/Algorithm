package Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		String minsik = input.next();
		int ml = 0, mo = 0, mv = 0, me = 0;
		for (int i = 0; i < minsik.length(); i++) {
			char tmp = minsik.charAt(i);
			switch (tmp) {
			case 'L':
				ml++;
				break;
			case 'O':
				mo++;
				break;
			case 'V':
				mv++;
				break;
			case 'E':
				me++;
				break;
			default:
				break;
			}
		}

		HashMap<String, Integer> hash = new HashMap<>();
		int n = input.nextInt();
		int l = 0, o = 0, v = 0, e = 0;
		for (int k = 0; k < n; k++) {
			String str = input.next();
			l = ml;
			o = mo;
			v = mv;
			e = me;
			for (int i = 0; i < str.length(); i++) {
				char tmp = str.charAt(i);
				switch (tmp) {
					case 'L':
						l++;
						break;
					case 'O':
						o++;
						break;
					case 'V':
						v++;
						break;
					case 'E':
						e++;
						break;
					default:
						break;
				}
			}
			int sum = ((l + o) * (l + v) * (l + e) * (o + v) * (o + e) * (v + e)) % 100;
			hash.put(str, sum);
		}

		ArrayList<String> keyset = new ArrayList<String>(hash.keySet());

		Collections.sort(keyset, new Comparator<String>() {
			public int compare(String a, String b) {
				if(hash.get(a) > hash.get(b))
					return -1;
				else if(hash.get(a) == hash.get(b))
					return a.compareTo(b);
				else
					return 1;
			}
		});
		System.out.println(keyset.get(0));
	}

}
