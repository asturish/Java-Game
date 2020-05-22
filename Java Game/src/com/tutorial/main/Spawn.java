package com.tutorial.main;

import java.util.Random;

public class Spawn {
	
	Handler handler;
	private int keepScore = 0;
	private OnScreenDisplay onScreenDisplay;
	private Random r = new Random();
	
	public Spawn(Handler handler, OnScreenDisplay onScreenDisplay) {
		this.handler = handler;
		this.onScreenDisplay = onScreenDisplay;
	}
	
	public void tick() {
		keepScore++;
		
		if(keepScore >= 100) {
			
			onScreenDisplay.setLevel(onScreenDisplay.getLevel() + 1);
			
			if((onScreenDisplay.getLevel() % 2) == 0) {
				handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
				keepScore = 0;
				onScreenDisplay.setScore(keepScore);
			} else if(onScreenDisplay.getLevel() == 3) {
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
				keepScore = 0;
				onScreenDisplay.setScore(keepScore);
			} else if(onScreenDisplay.getLevel() == 5) {
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH), r.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
				keepScore = 0;
				onScreenDisplay.setScore(keepScore);
			} else if(onScreenDisplay.getLevel() == 7) {
				handler.addObject(new EnemyBoss((Game.WIDTH) / 2 - 60, -100, ID.EnemyBoss, handler));
				keepScore = 0;
				onScreenDisplay.setScore(keepScore);
			}
		}

		
	}

}