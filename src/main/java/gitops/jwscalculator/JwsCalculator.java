package gitops.jwscalculator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class JwsCalculator {

	public static void main(String[] args) {
		CalculatorUI ui=new CalculatorUI("ѧ����������ʼ��Ŀ");
		ui.setVisible(true);
		ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class CalculatorUI extends JFrame
{
	private JTextField textField=new JTextField("��ӭ���μӡ����ù�������Ŀ���𡷿��ԣ�");
	
	public CalculatorUI(String title)
	{
		super(title);
		this.ComponentInit();
		this.setLocation(300, 200);
		this.setSize(600, 450);
	}
	
	private void ComponentInit()
	{
		this.add(textField,BorderLayout.NORTH);
		textField.setPreferredSize(new Dimension(300,80));
		textField.setHorizontalAlignment(JTextField.RIGHT);
		textField.setFont(new Font("����",Font.PLAIN,32));
		textField.setEditable(false);
	}
	
}
