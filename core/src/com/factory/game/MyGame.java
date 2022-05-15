package com.factory.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MyGame extends Game {

	SpriteBatch batch;
	Texture road;
	Texture crossroadUp;
	Texture crossroadDown;
	Texture start;
	private Car car;
	private CreateCar createCar;
	private Image image;
	private MyInputAdapter inputProcessor = new MyInputAdapter();

	@Override
	public void create () {
		batch = new SpriteBatch();
		road = new Texture("road.jpg");
		crossroadUp = new Texture("crossroadUp.jpg");
		crossroadDown = new Texture("crossroadDown.jpg");
		start = new Texture("start.png");
		car = new Car();
		createCar = new CreateCar();
		image = new Image();
		Gdx.input.setInputProcessor(inputProcessor);
		image.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				System.out.println("You clicked an image...");
			}
		});
	}

	@Override
	public void render () {
		car.moveTo(inputProcessor.getDirection());
		ScreenUtils.clear(1, 0, 0, 1);

		batch.begin();
		for (int i = 0; i < 480; i+=40) {
			for (int j = 0; j < 480; j +=40) {
				batch.draw(road, i, j);
			}
		}
		for (int i = 40; i <= 360; i+=80) {
			batch.draw(crossroadDown, i, 0);
		}
		for (int i = 0; i <= 400; i+=80) {
			batch.draw(crossroadUp, i, 440);
		}
		car.render(batch);
		createCar.render(batch);
		batch.end();

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		road.dispose();
		crossroadUp.dispose();
		crossroadDown.dispose();
		car.dispose();
	}
}
