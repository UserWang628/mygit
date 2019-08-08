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
		System.out.println("请输入任意5个不同的字母(不区分大小写)：");

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
					System.out.println("确认现在退出吗(y/n)");
					Scanner sc_exit = new Scanner(new BufferedInputStream(System.in));
					String str_exit = sc_exit.nextLine();
					if (str_exit.equals("y"))
						break;
					else
						continue;
				}
				str_b = str_b.toUpperCase();
				if (valueCheck(str_a, str_b)) {
					System.out.println("恭喜你全都猜中了，本次共用了" + step + "步");
					break;
				}
			}
		}
		System.out.println("系统随机的字母是：" + str_a);
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
		// 检查长度是否为5
		if (str.length() != 5) {
			if (str.length() == 4 && "exit".equals(str)) {
				return check_result;
			}
			check_result = "请输入长度为5的字符串！";
			return check_result;
		}

		// 检查是否全为字母
		Pattern pattern = Pattern.compile("[a-zA-Z]+");
		if (!pattern.matcher(str).matches()) {
			check_result = "字符串必须全为字母！";
			return check_result;
		}

		// 检查字母是否有重复
		char[] charset = (str.toCharArray());
		Arrays.sort(charset);
		for (int i = 0; i < 4; i++) {
			if (charset[i] == charset[i + 1]) {
				check_result = "字符串中有重复字符！";
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

		System.out.println("你猜对了" + match_num + "个，其中位置也正确的有" + correct_num + "个");
		if (match_num == 5 && correct_num == 5)
			return true;
		else
			return false;
	}
}
