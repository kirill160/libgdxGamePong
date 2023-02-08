package com.mygdx.pong;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Random;

public class Pong extends ApplicationAdapter {
    public static final int widthWindow = 800;
    public static final int heightWindow = 600;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Texture photoBall;
    private Sprite ball;
    private Sprite leftPaddle;
    private Sprite rightPaddle;
    private Texture photoLeftPaddle;
    private Texture photoRightPaddle;
    private int randomNumber;
    public static int speedXBall = 1;
    public static int speedYBall = 1;
    public static int speedLeftPaddle = 1;
    public static int spedRightPaddle = 1;


    @Override
    public void create() {
        photoBall = new Texture(Gdx.files.internal("ball.jpg"));
        photoLeftPaddle = new Texture(Gdx.files.internal("leftPaddle.jpg"));
        photoRightPaddle = new Texture(Gdx.files.internal("rightPaddle.jpg"));

        camera = new OrthographicCamera();
        batch = new SpriteBatch();
        camera.setToOrtho(false, widthWindow, heightWindow);

        leftPaddle = new Sprite(photoLeftPaddle);
        rightPaddle = new Sprite(photoRightPaddle);

        ball = new Sprite(photoBall);
        ball.setCenter((widthWindow + ball.getWidth()) / 2, (heightWindow + ball.getHeight()) / 2);

        leftPaddle.setCenter(leftPaddle.getWidth() / 2, (heightWindow + leftPaddle.getHeight()) / 2);
        rightPaddle.setCenter(widthWindow - rightPaddle.getWidth() / 2, (heightWindow + rightPaddle.getHeight()) / 2);
        randomNumber = new Random().nextInt(4) + 1;
        System.out.println(randomNumber);
        //System.out.println(leftPaddle.getY() + " " + ball.getY());


    }

    @Override
    public void render() {
        ScreenUtils.clear(Color.BLUE);

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        batch.draw(ball, ball.getX(), ball.getY());
        batch.draw(leftPaddle, leftPaddle.getX(), leftPaddle.getY());
        batch.draw(rightPaddle, rightPaddle.getX(), rightPaddle.getY());
        // System.out.println(rightPaddle.getY() + " " + rightPaddle.getX() + " " + ball.getY() + " " + ball.getX());
        System.out.println(randomNumber);
        batch.end();

        choiceOfDirectionBall();

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            leftPaddle.setY(leftPaddle.getY() + speedLeftPaddle);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            leftPaddle.setY(leftPaddle.getY() - speedLeftPaddle);
        }
        if (leftPaddle.getY() > heightWindow - leftPaddle.getHeight()) {
            leftPaddle.setY(heightWindow - leftPaddle.getHeight());
        }
        if (leftPaddle.getY() <= 0) {
            leftPaddle.setY(0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.PAGE_UP)) {
            rightPaddle.setY(rightPaddle.getY() + spedRightPaddle);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.PAGE_DOWN)) {
            rightPaddle.setY(rightPaddle.getY() - spedRightPaddle);
        }
        if (rightPaddle.getY() <= 0) {
            rightPaddle.setY(0);
        }
        if (rightPaddle.getY() > heightWindow - rightPaddle.getHeight()) {
            rightPaddle.setY(heightWindow - rightPaddle.getHeight());
        }


        if (ball.getY() <= leftPaddle.getY() + leftPaddle.getWidth() && ball.getY() >= leftPaddle.getY() - leftPaddle.getWidth() && ball.getX() == leftPaddle.getX() + leftPaddle.getWidth()) {
            speedXBall = -speedXBall;
            speedYBall = -speedYBall;
        }
        if (ball.getY() <= rightPaddle.getY() + rightPaddle.getWidth() && ball.getY() >= rightPaddle.getY() - rightPaddle.getWidth() && ball.getX() == widthWindow - rightPaddle.getHeight() - ball.getWidth()) {

            speedXBall = -speedXBall;
            speedYBall = -speedYBall;
        }

        if (ball.getY() >= heightWindow - ball.getHeight() || ball.getY() <= 0) {
            speedYBall = -speedYBall;
        }

        if (ball.getX() >= widthWindow || ball.getX() <= 0) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                ball.setCenter((widthWindow + ball.getWidth()) / 2, (heightWindow + ball.getHeight()) / 2);
                changeChoiceOfDirectionBall();
            }


        }

    }

    private void choiceOfDirectionBall() {
        switch (randomNumber) {
            case 1:
                ball.setX(ball.getX() + speedXBall);
                ball.setY(ball.getY() + speedYBall);
                break;
            case 2:
                ball.setX(ball.getX() + speedXBall * -1);
                ball.setY(ball.getY() + speedYBall);
                break;
            case 3:
                ball.setX(ball.getX() + speedXBall);
                ball.setY(ball.getY() + speedYBall * -1);
                break;
            case 4:
                ball.setX(ball.getX() + speedXBall * -1);
                ball.setY(ball.getY() + speedYBall * -1);
                break;
        }
    }

    private void changeChoiceOfDirectionBall() {
        randomNumber = new Random().nextInt(4) + 1;
        switch (randomNumber) {
            case 1:
                ball.setX(ball.getX() + speedXBall);
                ball.setY(ball.getY() + speedYBall);
                break;
            case 2:
                ball.setX(ball.getX() + speedXBall * -1);
                ball.setY(ball.getY() + speedYBall);
                break;
            case 3:
                ball.setX(ball.getX() + speedXBall);
                ball.setY(ball.getY() + speedYBall * -1);
                break;
            case 4:
                ball.setX(ball.getX() + speedXBall * -1);
                ball.setY(ball.getY() + speedYBall * -1);
                break;

        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        photoBall.dispose();
        photoLeftPaddle.dispose();
        photoRightPaddle.dispose();


    }
}
