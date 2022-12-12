package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Pong extends ApplicationAdapter {
	public static int WIDTH = 1280;
	public static int HEIGHT = 720;
	private SpriteBatch batch;
	private Texture background;
	private Padle leftPaddle;
	private Padle rightPad;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Texture("background.jpg");
	}

	@Override
	public void render () {
		batch.begin();
		batch.draw(background, 0, 0, WIDTH, HEIGHT);

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		background.dispose();
	}
}
