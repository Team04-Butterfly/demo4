/**
 * 
 */
package pHW02_SwingComponents_T136868;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * @author LUUQUANGMINH-T136868
 *
 */
public class cMenuViewer_T136868 extends JFrame {
	private static String[] arrayString = { "hinh/04001-bun-bo-hue-nho.png",
			"hinh/04003-banh-canh-ca-loc.png",
			"hinh/04004-banh-canh-nam-pho.png",
			"hinh/04005-bun-bo-hue-duoi-bo.png", "hinh/04006-bun-bo-gio-nac.png",
			"hinh/04007-bun-cha-cua.png", "hinh/04009-bun-ngheu-hen.png",
			"hinh/04010-bun-hen.png", "hinh/04011-bun-nem-nuong.png",
			"hinh/04012-bun-bap-bo.png", "hinh/04013-bun-bo-gio-gan.png",
			"hinh/04014-bun-thit-nuong.png", };
	private static JRadioButton optbun01 = new JRadioButton("bun bo hue nho",
			true);
	private static JRadioButton optbun02 = new JRadioButton("banh canh ca loc");
	private static JRadioButton optbun03 = new JRadioButton(
			"banh canh nam pho");
	private static JRadioButton optbun04 = new JRadioButton(
			"bun bo hue duoi bo");
	private static JRadioButton optbun05 = new JRadioButton("bun bo gio nac");
	private static JRadioButton optbun06 = new JRadioButton("bun cha cua");
	private static JRadioButton optbun07 = new JRadioButton("bun ngheu hen");
	private static JRadioButton optbun08 = new JRadioButton("bun hen");
	private static JRadioButton optbun09 = new JRadioButton("bun nem nuong");
	private static JRadioButton optbun10 = new JRadioButton("bun bap bo");
	private static JRadioButton optbun11 = new JRadioButton("bun bo gio gan");
	private static JRadioButton optbun12 = new JRadioButton("bun chả");
	private static ButtonGroup groupButton = new ButtonGroup();
	private static ImageIcon[] arrayhinh = new ImageIcon[12];
	private static JLabel lblhinh = new JLabel();
	private static int iCount = 0;
	private static final int max = 12;

	private static void setCount(int count) {
		iCount = count;
	}

	private static int getCount() {
		return iCount;
	}

	private static void increateCount() {
		setCount(getCount() + 1);
		if (getCount() > max)
			setCount(0);
	}

	public cMenuViewer_T136868() {
		super("T136868-Menu");
		setSize(700, 430);
		setLayout(null);
		add(optbun01);
		add(optbun02);
		add(optbun03);
		add(optbun04);
		add(optbun05);
		add(optbun06);
		add(optbun07);
		add(optbun08);
		add(optbun09);
		add(optbun10);
		add(optbun11);
		add(optbun12);
		add(lblhinh);
		setCount(0);
		arrayhinh = getArrayImageIcon(arrayString);
		changeIcon(lblhinh, arrayhinh[getCount()]);

		groupButton.add(optbun01);
		groupButton.add(optbun02);
		groupButton.add(optbun03);
		groupButton.add(optbun04);
		groupButton.add(optbun05);
		groupButton.add(optbun06);
		groupButton.add(optbun07);
		groupButton.add(optbun08);
		groupButton.add(optbun09);
		groupButton.add(optbun10);
		groupButton.add(optbun11);
		groupButton.add(optbun12);

		lblhinh.setBounds(200, 5, 600, 390);
		optbun01.setBounds(5, 5, 200, 25);
		optbun02.setBounds(5, optbun01.getY() + 30, 190, 25);
		optbun03.setBounds(5, optbun02.getY() + 30, 190, 25);
		optbun04.setBounds(5, optbun03.getY() + 30, 190, 25);
		optbun05.setBounds(5, optbun04.getY() + 30, 190, 25);
		optbun06.setBounds(5, optbun05.getY() + 30, 190, 25);
		optbun07.setBounds(5, optbun06.getY() + 30, 190, 25);
		optbun08.setBounds(5, optbun07.getY() + 30, 190, 25);
		optbun09.setBounds(5, optbun08.getY() + 30, 190, 25);
		optbun10.setBounds(5, optbun09.getY() + 30, 190, 25);
		optbun11.setBounds(5, optbun10.getY() + 30, 190, 25);
		optbun12.setBounds(5, optbun11.getY() + 30, 190, 25);
		optbun01.addActionListener(action);
		optbun02.addActionListener(action);
		optbun03.addActionListener(action);
		optbun04.addActionListener(action);
		optbun05.addActionListener(action);
		optbun06.addActionListener(action);
		optbun07.addActionListener(action);
		optbun08.addActionListener(action);
		optbun09.addActionListener(action);
		optbun10.addActionListener(action);
		optbun11.addActionListener(action);
		optbun12.addActionListener(action);
	}

	public static void main(String[] args) {
		cMenuViewer_T136868 main = new cMenuViewer_T136868();
		main.setDefaultCloseOperation(EXIT_ON_CLOSE);
		main.setVisible(true);
	}

	public static ImageIcon[] getArrayImageIcon(String[] arrayString) {
		int iEndFor = arrayString.length;
		ImageIcon[] imageIcon = new ImageIcon[iEndFor];
		for (int i = 0; i < iEndFor; i++) {
			imageIcon[i] = new ImageIcon(arrayString[i]);
		}
		return imageIcon;
	}

	public static ActionListener action = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent g) {
			JRadioButton optRaidoAction = (JRadioButton) g.getSource();
			if (optRaidoAction == optbun01)
				setCount(0);
			else if (optRaidoAction == optbun02)
				setCount(1);
			else if (optRaidoAction == optbun03)
				setCount(2);
			else if (optRaidoAction == optbun04)
				setCount(3);
			else if (optRaidoAction == optbun05)
				setCount(4);
			else if (optRaidoAction == optbun06)
				setCount(5);
			else if (optRaidoAction == optbun07)
				setCount(6);
			else if (optRaidoAction == optbun08)
				setCount(7);
			else if (optRaidoAction == optbun09)
				setCount(8);
			else if (optRaidoAction == optbun10)
				setCount(9);
			else if (optRaidoAction == optbun11)
				setCount(10);
			else if (optRaidoAction == optbun12)
				setCount(11);
			changeIcon(lblhinh, arrayhinh[getCount()]);
		}
	};

	public static void changeIcon(JLabel label, ImageIcon arrayIcon) {
		label.setIcon(arrayIcon);
	}
}
