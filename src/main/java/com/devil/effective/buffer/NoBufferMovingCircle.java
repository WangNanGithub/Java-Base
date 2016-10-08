package com.devil.effective.buffer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JApplet;
/**
 * 通过右键run as applet来运行
 * 
 * 没有使用缓冲，由于每次界面刷新都涉及图片的重新绘制，这是十分费时的
 * 
 * 因此图片的抖动和白光效果明显
 *
 */
public class NoBufferMovingCircle extends JApplet implements Runnable {

	Image screenImage = null;
	Thread thread;
	int x = 5;
	int move = 1;

	public void init() {
		screenImage = createImage(230, 160);
	}

	@Override
	public void start() {
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	@Override
	public void run() {
		try {

			while (true) {
				x += move;
				if (x > 105 || x < 5)
					move *= -1;
				repaint();
				Thread.sleep(10);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void drawCircle(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, 200, 100);
		g.setColor(Color.RED);
		g.fillOval(x, 5, 90, 90);
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 200, 200);
		drawCircle(g);
	}

}
