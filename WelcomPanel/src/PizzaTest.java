import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class MyFrame extends JFrame implements ActionListener {
	private int sum, temp1, temp2, temp3;// �׼� ������ ����
	private JButton order_button, cancle_button;// ������Ʈ�� �����̳� ��������
	private JPanel down_panel;
	private JTextField text;

	WelcomePanel welcom_panel = new WelcomePanel();
	// ����, Ÿ��, ����, ũ�� �г� ����
	TypePanel TypePanel = new TypePanel();
	ToppingPanel TopptingPanel = new ToppingPanel();
	SizePanel SizePanel = new SizePanel();
	private Component ToppingPanel;

	public void MyFrame() {// ������ ����
		this.setSize(500, 200);// ������ ũ�� ����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ���� ����
		this.setTitle("���� �ֹ�");// Ÿ��Ʋ �ʱ�ȭ

		this.order_button = new JButton("�ֹ�"); // �ֹ� ��ư ����
		this.order_button.addActionListener(this); // �̺�Ʈ ó�� ���
		this.cancle_button = new JButton("���"); // ��ҹ��v ����
		this.cancle_button.addActionListener(this); // �̺�Ʈ ó�� ���

		this.text = new JTextField(); // �ؽ�Ʈ �ʵ� ����
		text.setEditable(false); // ���� �Ұ�
		text.setColumns(6); // ���� 6ĭ

		down_panel = new JPanel(); // �г� ����
		down_panel.add(this.order_button); // �ֹ� ��ư ��� ��ư �߰�
		down_panel.add(this.cancle_button);
		down_panel.add(this.text); // �ؽ�Ʈ �ʵ� �߰�

		this.setLayout(new BorderLayout()); // ������ ��ġ������ ����

		this.add(welcom_panel, BorderLayout.NORTH); // welcom_panel ����
		this.add(down_panel, BorderLayout.SOUTH);
		this.add(SizePanel, BorderLayout.EAST);
		this.add(TypePanel, BorderLayout.WEST);
		this.add(ToppingPanel, BorderLayout.CENTER);

		this.setVisible(true);// ������ ȭ�� ǥ��
	}

	public void actionPerformed(ActionEvent e) { // �׼� �̺�Ʈ ó��
		if (e.getSource() == this.order_button) { // �׼Ǽҽ� ���� �ֹ� ��ư��
			this.text.setText(" " + 20000); // �ؽ�Ʈ �ʵ� ���
		}
		if (e.getSource() == this.cancle_button) { // �׼� �ҽ��� ��� ��ư�� ���
			temp1 = 0;
			temp2 = 0;
			temp3 = 0;
			sum = 0;
			this.text.setText(" " + sum); // ���� �ʱ�ȭ �� �ʱⰪ ���
		}
	}

	class WelcomePanel extends JPanel { // ��÷ �г� Ŭ���� ���� JPanel ���
		private JLabel message; // �޼��� �� ���� ����

		public WelcomePanel() {// ������
			message = new JLabel("Welcom");
			add(message); // ���� ������ ��ü�� �߰�
		}
	}

	class TypePanel extends JPanel { // Ÿ�� �г� ���� JPanel ���
		private JRadioButton combo, potato, bulgogi;// ���� ��ư ����
		private ButtonGroup bg; // ��ư �׷� ����

		public TypePanel() { // ������
			setLayout(new GridLayout(3, 1)); // ��ġ�������� ����

			combo = new JRadioButton("�޺�", true); // ���� ��ư ����
			potato = new JRadioButton("��������");
			bulgogi = new JRadioButton("�Ұ���");

			bg = new ButtonGroup(); // ��ư �׷� ������ ����
			bg.add(combo);
			bg.add(potato);
			bg.add(bulgogi);

			setBorder(BorderFactory.createTitledBorder("����"));// ��ư �׷� ����

			add(combo); // ��ü�� ���� ��ư �߰�
			add(potato);
			add(bulgogi);
		}
	}

	class ToppingPanel extends JPanel {
		private JRadioButton pepper, cheese, peperoni, bacon; // ���� ��ư ��������
		private ButtonGroup bg; // ��ư �׷� ���� ����

		public ToppingPanel() { // ������
			setLayout(new GridLayout(4, 1)); // ��ġ������ �Ϸ�

			pepper = new JRadioButton("�Ǹ�", true);	//���� ��ư ����
			cheese = new JRadioButton("ġ��");
			peperoni = new JRadioButton("����δ�");
			bacon = new JRadioButton("������");

			bg = new ButtonGroup();		//��ư �׷� ���� �Ķ��� ��ư ����
			bg.add(pepper);
			bg.add(cheese);
			bg.add(peperoni);
			bg.add(bacon);

			setBorder(BorderFactory.createTitledBorder("�߰�����"));

			add(pepper);	//��ü�� ���� ��ư �߰�
			add(cheese);
			add(peperoni);
			add(bacon);
		}
	}

	class SizePanel extends JPanel {		//������ �г� ���� JPanel���
		private JRadioButton small, medium, large;	//���� ��ư ��������
		private ButtonGroup bg;						//��ư �׷� ��������

		public SizePanel() {	//������
			setLayout(new GridLayout(3, 1));	//��ġ������

			small = new JRadioButton("Small", true);	//���� ��ư ����
			medium = new JRadioButton("Medium");
			large = new JRadioButton("Large");

			bg = new ButtonGroup();		//��ư �׷� ����
			bg.add(small);
			bg.add(medium);
			bg.add(large);
			//��ư �׷� ����
			setBorder(BorderFactory.createTitledBorder("ũ��"));

			add(small);	//��ü�� ���� ��ư �߰�
			add(medium);
			add(large);
		}
	}
}

public class PizzaTest {	//����̹� Ŭ����
	public static void main(String[] args) {
		new MyFrame();
	}
}