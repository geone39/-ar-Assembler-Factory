package com.factory.game;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class Car {
    public static final Vector2 position = new Vector2();

    private final Texture texture;

    public Car() {
        texture = new Texture("car.png");
        position.set(-100, -100);
    }

    public void render(Batch batch) {
        batch.draw(texture, position.x, position.y);
    }

    public void moveTo(Vector2 deriction) {
        position.add(deriction);
    }

    public void dispose() {
        texture.dispose();
    }

}
