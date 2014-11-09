/**
 * 
 */
package pHW02_SwingComponents_T136868;

import javax.swing.JFrame;
import java.awt.Graphics;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

/**
 * @author Luu Quang Minh - T136868
 *
 */
public class cAnalogClockMain_T136868 extends JFrame {
	double r = (Math.PI / 30);
	double a, sin, cos;
	int R = 50, n, c, s1, x, y, gx, gy, s, gio, phut, giay, ho, pi;
	Timer t;

	/**
	 * n rong c cao
	 */
	public cAnalogClockMain_T136868() {
		setTitle(" T136868-Analog Clock ");
		setSize(300, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		t = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				getTime();
				repaint();
			}
		});
		t.start();
	}

	public void drawClockFace(Graphics g, int d, int s) {
		g.drawOval(d, d, s, s);
		int v = 0;
		for (int i = 1; i <= 60; i++) {
			if (i % 5 == 0) {
				v++;
				double x1 = 3 * Math.PI - (i * r);
				double sinx = Math.sin(x1);
				int nx = (int) (x + s / 2 * sinx);
				double cosx = Math.cos(x1);
				int ny = (int) (y + s / 2 * cosx);
				g.drawString("" + v, nx - 2, ny);
			}
		}
	}

	public void drawClock(Graphics g, int x, int y, double r1, double p) {
		a = 3 * Math.PI - (p * r);
		cos = Math.cos(a);
		sin = Math.sin(a);
		gx = (int) (x + r1 * sin);
		gy = (int) (y + r1 * cos);
		g.drawLine(x, y, gx, gy);
	}

	public void paint(final Graphics f) {
		super.paint(f);
		n = getWidth();
		c = getHeight();
		ho = s / 2;
		pi = s * 3 / 4;
		s1 = 200;
		s = s1 / 2;
		x = s1 / 2 + R;
		y = s1 / 2 + R;
		drawClockFace(f, R, s1);
		drawClock(f, x, y, s, giay);
		drawClock(f, x, y, ho, phut);
		drawClock(f, x, y, pi, gio);

	}

	public void getTime() {
		Calendar t = Calendar.getInstance();
		giay = t.get(Calendar.SECOND);
		phut = t.get(Calendar.MINUTE) + giay / 60;
		gio = t.get(Calendar.HOUR) * 5 + phut / 60;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cAnalogClockMain_T136868 main = new cAnalogClockMain_T136868();
		main.setDefaultCloseOperation(EXIT_ON_CLOSE);
		main.setVisible(true);
	}

}