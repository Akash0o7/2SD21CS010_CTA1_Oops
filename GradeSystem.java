package Project;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class Form extends JFrame implements ActionListener {

	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
	JTextField t1, t2, t3, t4, t5;
	JButton b1;

	Form(String title) {
		super(title);

		l1 = new JLabel("Grade Calculator");
		l2 = new JLabel("Enter IA-1 Marks");
		l3 = new JLabel("Enter IA-2 Marks");
		l4 = new JLabel("Enter IA-3 Marks");
		l5 = new JLabel("Enter CTA Marks");
		l6 = new JLabel("Enter SEE Marks");
		l7 = new JLabel();
		l8 = new JLabel();
		l9 = new JLabel();
		t1 = new JTextField(5);
		t2 = new JTextField(5);
		t3 = new JTextField(5);
		t4 = new JTextField(5);
		t5 = new JTextField(5);
		b1 = new JButton("Calculate");

		add(l1);
		add(l2);
		add(t1);
		add(l3);
		add(t2);
		add(l4);
		add(t3);
		add(l5);
		add(t4);
		add(l6);
		add(t5);
		add(b1);
		add(l7);
		add(l8);
		add(l9);

		setLayout(null);

		l1.setBounds(100, 50, 100, 50);
		l2.setBounds(50, 100, 100, 50);
		t1.setBounds(150, 110, 100, 30);
		l3.setBounds(50, 150, 100, 50);
		t2.setBounds(150, 160, 100, 30);
		l4.setBounds(50, 200, 100, 50);
		t3.setBounds(150, 210, 100, 30);
		l5.setBounds(50, 250, 100, 50);
		t4.setBounds(150, 260, 100, 30);
		l6.setBounds(50, 300, 100, 50);
		t5.setBounds(150, 310, 100, 30);
		b1.setBounds(100, 350, 100, 50);
		l7.setBounds(35, 420, 500, 50);
		l8.setBounds(180, 420, 100, 50);
		l9.setBounds(35, 420, 500, 50);
		b1.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int ia1, ia2, ia3, cta, see, cie = 0, total, temp1;
		float temp;
		char g;
		ia1 = Integer.parseInt(t1.getText());
		ia2 = Integer.parseInt(t2.getText());
		ia3 = Integer.parseInt(t3.getText());
		cta = Integer.parseInt(t4.getText());
		see = Integer.parseInt(t5.getText());

		try {
			if (cta < 0 || cta > 10) {
				throw new IllegalArgumentException("CTA marks should be between 0 – 10");

			}
			if (ia1 < 0 || ia1 > 20 || ia2 < 0 || ia2 > 20 || ia3 < 0 || ia3 > 20) {
				throw new IllegalArgumentException("IA marks should be between 0 – 20");
			} else {
				if (ia1 <= ia2 && ia1 <= ia3) {
					cie = ia2 + ia3 + cta;
				} else if (ia2 <= ia3 && ia2 <= ia1) {
					cie = ia1 + ia3 + cta;
				} else if (ia3 <= ia2 && ia3 <= ia1) {
					cie = ia1 + ia2 + cta;
				}
			}

			if (cie < 20) {
				l9.setText("Student is detained from taking SEE ");
			}

			if (see < 0 || see > 100) {
				throw new IllegalArgumentException("SEE marks should be between 0 – 100");
			} else {
				if (see == 39 || see == 38) {
					see = 40;
				}
				temp = see / 2f;

				if (temp > (int) temp) {
					temp++;
				}
			}
			total = cie + (int) temp;
			if (total >= 90 && total <= 100)
				g = 'S';
			else if (total >= 80 && total <= 89)
				g = 'A';
			else if (total >= 70 && total <= 79)
				g = 'B';
			else if (total >= 60 && total <= 69)
				g = 'C';
			else if (total >= 50 && total <= 59)
				g = 'D';
			else if (total >= 40 && total <= 49)
				g = 'E';
			else
				g = 'F';

			if (cie >= 20) {
				l7.setText("Total Marks:" + total);
				l8.setText("Grade:" + g);
			}
		} catch (Exception e1) {

			l7.setText("Error: " + e1.getMessage());

		}
	}
}

public class GradeSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new Form("Student Grading System");

		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(100, 100, 320, 500);
	}

}