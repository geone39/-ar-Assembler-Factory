package com.factory.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;

public class MyInputAdapter extends InputAdapter {

    public static boolean flagStart = false;
    public static boolean fisrtStart = true;
    public static int count_road = 0;
    private boolean KeyCreateCarPressed;
    private final Vector2 direction = new Vector2();
    int k = 0;
    int count = 0;
    int[][] roadCar = new int[1500][1500];

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        System.out.println(screenX);
        System.out.println(screenY);
        if ((screenX > 500) && (screenY < 80) && (!flagStart) && (fisrtStart)) {
            roadCar[0][k] = 5;
            roadCar[k][0] = 0;
            k++;
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 88; j++) {
                    roadCar[0][k] = 5;
                    roadCar[k][0] = 0;
                    k++;
                }
                for (int j = 0; j < 8; j++) {
                    roadCar[k][0] = 5;
                    roadCar[0][k] = 0;
                    k++;
                }
                for (int j = 0; j < 88; j++) {
                    roadCar[0][k] = -5;
                    roadCar[k][0] = 0;
                    k++;
                }
                for (int j = 0; j < 8; j++) {
                    roadCar[k][0] = 5;
                    roadCar[0][k] = 0;
                    k++;
                }
            }
            CreateCar.startCar();
            flagStart = true;
            fisrtStart = false;
            KeyCreateCarPressed = true;
        }
        if ((screenX > 500) && (screenY < 80) && (!flagStart) && (!fisrtStart)) {
            CreateCar.startCar();
            flagStart = true;
            KeyCreateCarPressed = true;
        }
        if (count >= 1144) {
            flagStart = false;
            count = 0;
        }


        return false;
    }


    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        KeyCreateCarPressed = false;
        return false;
    }
    public Vector2 getDirection() {
        direction.set(0, 0);
        if ((flagStart) && (count < 1144)) {
            direction.add(roadCar[count][0], roadCar[0][count]);
            count++;
        }

        return direction;
    }
}