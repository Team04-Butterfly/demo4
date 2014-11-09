/**
 * 
 */
package pHW02_SwingComponents_T136868;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.*;

/**
 * @author Luu Quang Minh - T136868
 *
 */
public class cComputingCosinFunction_T136868 extends JFrame {

	private static JLabel lblnhap = new JLabel("Nhap so :");
	private static JLabel lblSaiSo = new JLabel("Chon sai so :");
	private static JTextArea txtAreaResult = new JTextArea();
	private static JButton btntinh = new JButton("Tinh"), btnxoa = new JButton(
			"Xoa"), btnxoahet = new JButton("Xoa het");
	private static JTextField txtInput = new JTextField();
	private static JScrollPane scrollResult = new JScrollPane(txtAreaResult);
	private static String[] sListNUmber = { "1", "2", "3", "4", "5", "6", "7",
			"8" };
	private static JComboBox cmbNumber = new JComboBox<String>(sListNUmber);
	private static int iSaiSo = 1;

	private static void setSaiSo(int SaiSo) {
		iSaiSo = SaiSo;
	}

	private static int getSaiSo() {
		return iSaiSo;
	}

	public cComputingCosinFunction_T136868() {
		super("T136868- Cosin Function");
		setSize(420, 450);
		setLayout(null);
		add(lblnhap);
		add(txtInput);
		add(btntinh);
		add(btnxoa);

		add(lblSaiSo);
		add(btnxoahet);
		add(cmbNumber);
		cmbNumber.setSelectedIndex(1);
		setSaiSo(2);

		add(scrollResult);
		lblnhap.setBounds(10, 30, 70, 25);
		txtInput.setBounds(100, 30, 290, 25);

		lblSaiSo.setBounds(150, 75, 100, 25);
		cmbNumber.setBounds(240, 75, 150, 25);

		btnxoahet.setBounds(295, 140, 90, 25);

		scrollResult.setBounds(10, 185, 380, 200);

		btntinh.setBounds(75, 140, 90, 25);
		btnxoa.setBounds(185, 140, 90, 25);
		btnxoa.addActionListener(actionButton);
		btnxoahet.addActionListener(actionButton);
		cmbNumber.addActionListener(actionCombobox);
		btntinh.addActionListener(actionButton);
	}

	public static void main(String[] args) {
		cComputingCosinFunction_T136868 main = new cComputingCosinFunction_T136868();
		main.setDefaultCloseOperation(EXIT_ON_CLOSE);
		main.setVisible(true);
	}

	public static boolean isInput(String sValue) {
		return isStringIsDoubleNumber(sValue);
	}

	public static boolean isStringIsDoubleNumber(String str) {
		int endFor = str.length() - 1;
		for (int i = 0; i <= endFor; i++) {
			if (!isStringHaveInString("0123456789.", str.substring(i, i + 1)))
				return false;
		}
		int iPoint = 0;
		for (int i = 0; i <= endFor; i++) {
			if (str.substring(i, i + 1).equals(".")) {
				iPoint++;
			}
		}
		if (iPoint <= 1)
			return true;
		else
			return false;
	}

	public static boolean isStringHaveInString(String sString, String sValue) {
		int iEndFor = sString.length() - 1;
		for (int i = 0; i <= iEndFor; i++) {
			if (sString.substring(i, i + 1).equals(sValue))
				return true;
		}
		return false;
	}

	public static double cos(double dValue, int iSaiSo) {
		if (dValue > 2 * 3.1416)
			dValue = dValue % (2 * 3.1416);

		int iNegative = -1;
		double dCos = 1;
		double dCosBefore = 1;
		dCos += iNegative * pow(dValue, 2 * 1) / factorial(2 * 1);
		double dE = pow(10, -iSaiSo);
		int iCount = 2;
		while (abs(dCos - dCosBefore) > dE) {
			dCosBefore = dCos;
			iNegative = negative(iNegative);
			dCos += iNegative * pow(dValue, 2 * iCount) / factorial(2 * iCount);
			iCount++;
		}
		return dCos;
	}

	public static double abs(double number) {
		if (number >= 0)
			return number;
		else
			return -number;
	}

	public static int negative(int iValue) {
		return -iValue;
	}

	public static double pow(double b, int a) {
		if (a == 0)
			return 1;
		double dResult = b;
		if (a > 1) {
			for (int i = 2; i <= a; i++) {
				dResult *= b;
			}
		} else if (a <= -1) {
			dResult = 1 / b;
			for (int i = 2; i <= -a; i++) {
				dResult /= b;
			}
		}
		return dResult;
	}

	public static double factorial(int iValue) {
		double dFactorial = 1;
		for (int i = 1; i <= iValue; i++) {
			dFactorial = dFactorial * i;
		}
		return dFactorial;
	}

	public static String computer(String sValue, String sResult) {
		return "Cos(" + sValue + ")=" + sResult;
	}

	private static ActionListener actionButton = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnxoa) {
				txtInput.setText("");
			} else if (e.getSource() == btnxoahet) {
				txtInput.setText("");
				txtAreaResult.setText("");
				cmbNumber.setSelectedIndex(1);
				setSaiSo(2);
			} else if (e.getSource() == btntinh) {
				String sValue = txtInput.getText();
				String sResult = "";
				if (sValue.equals(""))
					return;
				if (isInput(sValue)) {
					sResult = computer(sValue,
							"" + cos(Double.parseDouble(sValue), getSaiSo()));
				} else {
					sResult = "Invalid Input";
				}
				txtAreaResult.append(sResult + "\n");
			}
		}
	};

	private static ActionListener actionCombobox = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == cmbNumber) {
				setSaiSo(cmbNumber.getSelectedIndex() + 1);
			}
		}
	};
}
