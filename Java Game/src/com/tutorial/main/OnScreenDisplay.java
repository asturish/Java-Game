package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;

public class OnScreenDisplay {
	
	public static float HEALTH = 100;
	private int score = 0;
	private int level = 1;

	public void tick() {
		HEALTH = Game.clamp(HEALTH, 0, 100);
		score++;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 32);
		
		if(HEALTH > 75) {
		g.setColor(Color.green);
		} else if(HEALTH > 60){
			g.setColor(Color.yellow);	
		} else if(HEALTH > 40) {
			g.setColor(Color.orange);
		}
		else{g.setColor(Color.red);}
		
		g.fillRect(15, 15, (int)(HEALTH *2), 32);
		g.setColor(Color.gray);
		g.drawRect(15, 15, 200, 32);
		
		g.drawString("Score: " + score + "  Level: " + level, 500, 32);
	}
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
}