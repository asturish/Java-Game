package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBossBullet extends BasicEnemy{

	private Handler handler;
	
	public EnemyBossBullet(float x, float y, ID id, Handler handler) {
		super(x, y, id, handler);
		
		this.handler = handler;
		Random r = new Random();
		
		velX = (r.nextInt(5 - -5) + -5);
		velY = 5;
	}

	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 5, 5);
	}
	
	public void tick() {
		x += velX;
		y += velY;
		
//		if(y <= 0 || y >= Game.HEIGHT - 48) velY *= -1;
//		if(x <= 0 || x >= Game.WIDTH - 24) velX *= -1;
		
		if(y >= Game.HEIGHT) {handler.removeObject(this);}
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.blue, 5, 5, 0.001f, handler));
			
	}

	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect((int)x, (int)y, 5, 5);
	}

}
