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
		// �������
		// JPanel����Ĭ����FlowLayout������

		jf_main = new JFrame("���˵�");

		jp1 = new JPanel();
		jp2 = new JPanel();

		jl1 = new JLabel("��Ϸ�˵�");

		jb1 = new JButton("����ĸ");
		jb2 = new JButton("����");
		jb3 = new JButton("�㽶");

		jb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jf_main.dispose();
				TableGame tbg = new TableGame();
			}

		});
		// ���ò��ֹ�����(JpanelĬ��������)
		jp1.add(jl1);

		jp2.add(jb1);
		jp2.add(jb2);
		jp2.add(jb3);

		// ��Panel����JFrame
		jf_main.add(jp1, BorderLayout.NORTH);
		jf_main.add(jp2, BorderLayout.CENTER);

		// ���ô���
		// �����С
		jf_main.setSize(600, 450);

		// ��Ļ��ʾ��ʼλ��
		jf_main.setLocation(350, 150);

		// ��ʾ
		jf_main.setVisible(true);

		// �˳������JFrameͬʱ�ر�
		jf_main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
