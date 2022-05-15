package com.factory.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;

public class CreateCar {
    private final Vector2 position = new Vector2();

    private final Texture texture;

    public CreateCar() {
        texture = new Texture("start.png");
        position.set(500, 400);
    }
    public void render(Batch batch) {
        batch.draw(texture, position.x, position.y);
    }

    public static void startCar() {
        Car.position.x = 0;
        Car.position.y = 0;
    }

    public void dispose() {
        texture.dispose();
    }
}
