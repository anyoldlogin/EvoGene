package com.bitsend.evogene;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.bitsend.evogene.screen.GameScreen;

public class Game implements ApplicationListener {
	public final static int HEIGHT = 800;
	public final static int WIDTH = 1200;
	Screen screen;

    public Screen getStartScreen() {
        return new GameScreen(this);
    }
    
	public void setScreen (Screen sc) {
		screen.pause();
		screen.dispose();
		screen = sc;
	}
	
	public void create() {
		Assets.load();
		
		screen = getStartScreen();
	}

	public Game() {

	}

	public void resize(int width, int height) {
	}

	public void pause() {
		screen.pause();
	}

	public void resume() {
		screen.resume();
	}

	public void dispose() {
		screen.dispose();
	}

	@Override
	public void render() {
		screen.render(Gdx.graphics.getDeltaTime());
	}
}