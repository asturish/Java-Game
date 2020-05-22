package com.tutorial.main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends GameObject {
	
	private float alpha = 1f;
	private Handler handler;
	private Color color;
	private float width;
	private float height;
	private float life;
	private float tickTimer = 0;
	
	// life = 0.001 - 0.1

	public Trail(float x, float y, ID id, Color color, float width, float height, float life, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		this.color = color;
		this.width = width;
		this.height = height;
		this.life = life;
	}

	public void tick() {
		alpha -= 0.03;
		if(alpha > life) {
			alpha -= (life + 0.0001f);
		} else handler.removeObject(this);
		tickTimer++;
	}

	public void render(Graphics g) {
		Graphics g2d = (Graphics2D) g;
		((Graphics2D) g2d).setComposite(makeTransparent(alpha));
		g.setColor(color);
		g.fillRect((int)x, (int)y, (int)width, (int)height);
		
		((Graphics2D) g2d).setComposite(makeTransparent(1));
	}

	
	private AlphaComposite makeTransparent(float alpha) {
		float type = AlphaComposite.SRC_OVER;
		return(AlphaComposite.getInstance((int)type, alpha));
	}
	public Rectangle getBounds() {
		return null;
	}

}
