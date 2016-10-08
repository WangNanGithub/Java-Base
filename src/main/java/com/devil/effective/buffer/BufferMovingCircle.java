package com.devil.effective.buffer;

import java.awt.Color;
import java.awt.Graphics;

// 屏幕闪烁消失，画面十分流畅
public class BufferMovingCircle extends NoBufferMovingCircle {
	Graphics doubleBuffer = null;

	public void init() {
		super.init();
		doubleBuffer = screenImage.getGraphics();
	};

	@Override
	public void paint(Graphics g) {
		doubleBuffer.setColor(Color.WHITE);
		doubleBuffer.fillRect(0, 0, 200, 200);
		drawCircle(doubleBuffer);
		g.drawImage(screenImage, 0, 0, this);
	}
}
