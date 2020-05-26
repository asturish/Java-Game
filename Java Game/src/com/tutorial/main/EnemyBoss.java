package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBoss extends BasicEnemy {

	private Handler handler;
	private float totalTimer = 260;
	

	public EnemyBoss(float x, float y, ID id, Handler handler) {
		super(x, y, id, handler);

		this.handler = handler;

		velX = 0;
		velY = 2;
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 96, 36);
	}

	public void tick() {
		x += velX;
		y += velY;

		
//		totalTimer--;
		if (totalTimer == 0){
			handler.removeObject(this);
		} else if(totalTimer == 180) {
			velX += 6;
			velY -= 2;
			for(int i = 0; i <= 5; i++) {
				handler.addObject(new EnemyBossBullet((int)x, (int)y, ID.BasicEnemy, handler));
			}
			totalTimer--;
			} else if (totalTimer == 110 || totalTimer == 70){
				for(int i = 0; i <= 5; i++) {
					handler.addObject(new EnemyBossBullet((int)x, (int)y, ID.BasicEnemy, handler));
				}
				totalTimer--;				
			} else{
				totalTimer--;
			}
		
		

//		
		if(x <= 0 || x >= Game.WIDTH - 100) velX *= -1;


	}

	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int) x, (int) y, 96, 36);
	}

}
