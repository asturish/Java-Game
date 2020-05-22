package com.tutorial.main;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class Player extends GameObject {

	Random r = new Random();
	Handler handler;

	public Player(float x, float y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;

	}

	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 32, 32);
	}

	public void tick() {
		x += velX;
		y += velY;

		x = Game.clamp((int)x, 0, Game.WIDTH - 46);
		y = Game.clamp((int)y, 0, Game.HEIGHT - 68);
		
		collision();
	}
	
	public void collision() {
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempGameObject = handler.object.get(i);
			if(tempGameObject.getId() == ID.BasicEnemy || tempGameObject.getId() == ID.FastEnemy || tempGameObject.getId() == ID.SmartEnemy ) {

				if(getBounds().intersects(tempGameObject.getBounds())) {
					// collision code
					OnScreenDisplay.HEALTH -= 2;
					
				}

			}
		}
	}

	public void render(Graphics g) {
		
//		Graphics2D g2d = (Graphics2D) g;
//		g2d.setColor(Color.red);
//		g2d.draw(getBounds());
		
		g.setColor(Color.white);
		g.fillRect((int)x, (int)y, 32, 32);
	}

}