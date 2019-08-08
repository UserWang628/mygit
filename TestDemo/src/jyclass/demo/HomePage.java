package jyclass.demo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomePage extends JFrame {

	private static final long serialVersionUID = 1L;

	private static JFrame jf_main;
	private static JPanel jp1, jp2;
	private static JLabel jl1;
	private static JButton jb1, jb2, jb3;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HomePage hp = new HomePage();
	}

	public HomePage() {
		// 创建组件
		// JPanel布局默认是FlowLayout流布局

		jf_main = new JFrame("主菜单");

		jp1 = new JPanel();
		jp2 = new JPanel();

		jl1 = new JLabel("游戏菜单");

		jb1 = new JButton("猜字母");
		jb2 = new JButton("桔子");
		jb3 = new JButton("香蕉");

		jb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jf_main.dispose();
				TableGame tbg = new TableGame();
			}

		});
		// 设置布局管理器(Jpanel默认流布局)
		jp1.add(jl1);

		jp2.add(jb1);
		jp2.add(jb2);
		jp2.add(jb3);

		// 把Panel加入JFrame
		jf_main.add(jp1, BorderLayout.NORTH);
		jf_main.add(jp2, BorderLayout.CENTER);

		// 设置窗体
		// 窗体大小
		jf_main.setSize(600, 450);

		// 屏幕显示初始位置
		jf_main.setLocation(350, 150);

		// 显示
		jf_main.setVisible(true);

		// 退出窗体后将JFrame同时关闭
		jf_main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
