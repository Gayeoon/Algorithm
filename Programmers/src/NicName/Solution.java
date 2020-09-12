package NicName;

class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();

		StringBuilder answer = new StringBuilder();

		boolean flag = true;
		for (int i = 0; i < new_id.length(); i++) {
			char tmp = new_id.charAt(i);
			if (tmp >= 'a' && tmp <= 'z') {
				answer.append(tmp);
				flag = true;
			}
			else if (tmp >= '0' && tmp <= '9') {
				answer.append(tmp);
				flag = true;
			}
			else if (tmp == '-' || tmp == '_') {
				answer.append(tmp);
				flag = true;
			}
			else if (flag && tmp == '.') {
				answer.append(tmp);
				flag = false;
			}
		}

		while (true) {
			if (answer.length() == 0)
				break;
			if (answer.charAt(0) == '.')
				answer.deleteCharAt(0);
			else
				break;
		}
		while (true) {
			if (answer.length() == 0)
				break;
			if (answer.charAt(answer.length() - 1) == '.')
				answer.deleteCharAt(answer.length() - 1);
			else
				break;
		}

		if (answer.length() == 0)
			answer.append("a");

		if (answer.length() >= 16) {
			answer.delete(15, answer.length());
			while (true) {
				if (answer.length() == 0)
					break;
				if (answer.charAt(answer.length() - 1) == '.')
					answer.deleteCharAt(answer.length() - 1);
				else
					break;
			}
		} else if (answer.length() <= 2) {
			char tmp = answer.charAt(answer.length() - 1);
			while (true) {
				if (answer.length() >= 3)
					break;
				answer.append(tmp);
			}
		}
        return answer.toString();
    }
}