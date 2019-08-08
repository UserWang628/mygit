package backup.demo;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TableCheck {
	public static void main(String args[]) {
		String str_a, str_b;
		str_a = getString();

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		System.out.println("����������5����ͬ����ĸ(�����ִ�Сд)��");

		String format_check;
		int step = 0;
		while (true) {
			str_b = sc.nextLine();
			format_check = formatCheck(str_b);
			if (!" ".equals(format_check)) {
				System.out.println(format_check);

			} else {
				step++;
				if ("exit".equals(str_b)) {
					System.out.println("ȷ�������˳���(y/n)");
					Scanner sc_exit = new Scanner(new BufferedInputStream(System.in));
					String str_exit = sc_exit.nextLine();
					if (str_exit.equals("y"))
						break;
					else
						continue;
				}
				str_b = str_b.toUpperCase();
				if (valueCheck(str_a, str_b)) {
					System.out.println("��ϲ��ȫ�������ˣ����ι�����" + step + "��");
					break;
				}
			}
		}
		System.out.println("ϵͳ�������ĸ�ǣ�" + str_a);
	}

	public static String getString() {

		String random_table = "";
		String str = "";
		for (int i = 0; i < 5; i++) {
			while (str.contains(random_table)) {
				random_table = (char) (Math.random() * 26 + 'A') + "";
			}
			str = str + random_table;
		}
		return str;
	}

	public static String formatCheck(String str) {

		String check_result = " ";
		// ��鳤���Ƿ�Ϊ5
		if (str.length() != 5) {
			if (str.length() == 4 && "exit".equals(str)) {
				return check_result;
			}
			check_result = "�����볤��Ϊ5���ַ�����";
			return check_result;
		}

		// ����Ƿ�ȫΪ��ĸ
		Pattern pattern = Pattern.compile("[a-zA-Z]+");
		if (!pattern.matcher(str).matches()) {
			check_result = "�ַ�������ȫΪ��ĸ��";
			return check_result;
		}

		// �����ĸ�Ƿ����ظ�
		char[] charset = (str.toCharArray());
		Arrays.sort(charset);
		for (int i = 0; i < 4; i++) {
			if (charset[i] == charset[i + 1]) {
				check_result = "�ַ��������ظ��ַ���";
				return check_result;
			}
		}
		return check_result;
	}

	public static boolean valueCheck(String a, String b) {
		int match_num = 0;
		int correct_num = 0;

		for (int i = 0; i < 5; i++) {
			if (a.contains(b.charAt(i) + ""))
				match_num++;
			if (a.charAt(i) == b.charAt(i))
				correct_num++;
		}

		System.out.println("��¶���" + match_num + "��������λ��Ҳ��ȷ����" + correct_num + "��");
		if (match_num == 5 && correct_num == 5)
			return true;
		else
			return false;
	}
}
