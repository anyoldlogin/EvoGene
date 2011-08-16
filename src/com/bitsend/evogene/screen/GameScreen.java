package com.bitsend.evogene.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.bitsend.evogene.Assets;
import com.bitsend.evogene.Game;
import com.bitsend.evogene.World;
import com.bitsend.evogene.agents.Bug;
import com.bitsend.evogene.agents.Food;

public class GameScreen extends BaseScreen {
	public final static int HEIGHT = 800;
	public final static int WIDTH = 1200;
	private OrthographicCamera cam = null;
	private Rectangle glViewport = null;
	private SpriteBatch batch = null;
	private World world = null;
	private Game game = null;
	private float frameLength = 1000/20f;
	private BitmapFont font = null;
	public GameScreen(Game game) {
		this.game = game;
		create();
	}
	
	public void create() {
		Assets.load();
		world = new World();
		populate(100, 20);
		cam = new OrthographicCamera(WIDTH, HEIGHT);
		cam.position.set(WIDTH / 2, HEIGHT / 2, 0);
		glViewport = new Rectangle(0, 0, WIDTH, HEIGHT);
		font = new BitmapFont();
	}

	public void populate(int numFood, int numBugs) {

		while (numFood > 0) {
			int x = (int) (Math.random() * world.worldWidth);
			int y = (int) (Math.random() * world.worldHeight);

			if (world.getContents(x, y) == null) {
				world.addAgent(x, y, new Food((float) x, (float) y, 0f));
				numFood--;
			}
		}

		while (numBugs > 0) {
			int x = (int) (Math.random() * world.worldWidth);
			int y = (int) (Math.random() * world.worldHeight);

			if (world.getContents(x, y) == null) {
				world.addAgent(x, y, new Bug((float) x, (float) y, 0f, 1));
				numBugs--;
			}
		}
	}
	
	@Override
	public void render(float delta) {
		
		if (batch == null) {
			batch = new SpriteBatch();
		}

		Gdx.gl.glClearColor(1f, 1f, 1f, 0f);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glViewport((int) glViewport.x, (int) glViewport.y,
				(int) glViewport.width, (int) glViewport.height);
		cam.update();
		cam.apply(Gdx.graphics.getGL10());

		Gdx.gl.glEnable(GL10.GL_BLEND);
		Gdx.gl.glEnable(GL10.GL_TEXTURE_2D);
		batch.begin();
		world.update(delta);
		world.render(batch);
		font.draw(batch, "Hello World!", 0, 0);
		batch.end();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}


}
