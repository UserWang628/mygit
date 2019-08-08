package jyclass.demo;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TableGame extends JFrame {

	private static final long serialVersionUID = 1L;

	private static JFrame jf_1;
	private static JPanel jp1, jp2;
	private static JLabel jl1, jl2;
	private static JTextField jt1;
	private static JButton jb1, jb2;

	private String user, system;
	private int step = 0;

	public TableGame() {
		// 创建组件
		// JPanel布局默认是FlowLayout流布局

		system = getString();

		jf_1 = new JFrame("猜字母游戏");
		jf_1.setLayout(new GridLayout(4, 1));
		jl1 = new JLabel("请输入任意5个英文字母(不区分大小写)", JLabel.CENTER);
		jl2 = new JLabel("", JLabel.CENTER);

		jp1 = new JPanel();
		jp2 = new JPanel();

		jt1 = new JTextField(10);
		jp1.add(jt1);

		jb1 = new JButton("确认");
		jb2 = new JButton("返回");
		jb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String format_check;

				user = jt1.getText();
				format_check = formatCheck(user);
				if (!" ".equals(format_check)) {
					jl2.setText(format_check);
					jl2.setForeground(Color.RED);

				} else {
					step++;
					if ("exit".equals(user)) {
						int rel = JOptionPane.showConfirmDialog(null, "确定要中途放弃吗？", "对话框", JOptionPane.OK_CANCEL_OPTION);
						if (rel == 0) {
							jf_1.dispose();
							HomePage hp1 = new HomePage();
						}
					}
					user = user.toUpperCase();
					if (valueCheck(system, user)) {
						jl2.setText("恭喜你全都猜中了，本次共用了" + step + "步");
						jl2.setForeground(Color.GREEN);
						// System.out.println("恭喜你全都猜中了，本次共用了" + step +
						// "步");
					}
				}
			}

		});

		jb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jf_1.dispose();
				HomePage hp2 = new HomePage();
			}

		});
		// 设置布局管理器(Jpanel默认流布局)
		jp2.add(jb1);
		jp2.add(jb2);

		jf_1.add(jl1);
		jf_1.add(jp1);
		jf_1.add(jl2);
		jf_1.add(jp2);

		// 设置窗体
		// 窗体大小
		jf_1.setSize(600, 450);

		// 屏幕显示初始位置
		jf_1.setLocation(350, 150);

		// 显示
		jf_1.setVisible(true);

		// 退出窗体后将JFrame同时关闭
		jf_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public String getString() {

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

	public String formatCheck(String str) {

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

	public boolean valueCheck(String a, String b) {
		int match_num = 0;
		int correct_num = 0;

		for (int i = 0; i < 5; i++) {
			if (a.contains(b.charAt(i) + ""))
				match_num++;
			if (a.charAt(i) == b.charAt(i))
				correct_num++;
		}
		jl2.setForeground(Color.RED);
		jl2.setText("你猜对了" + match_num + "个，其中位置也正确的有" + correct_num + "个");

		if (match_num == 5 && correct_num == 5)
			return true;
		else
			return false;
	}

}
