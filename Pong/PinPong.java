package Pong;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.reflect.Field;
import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import org.lwjgl.system.MathUtil;

import java.util.Random;

public class PinPong extends ApplicationAdapter {
    private Texture background;
    private Texture imageBall;
    private Texture imageRightPaddle;
    private Texture imageLeftPaddle;
    private SpriteBatch batch;
    //private Music backgroundMusic;
    private OrthographicCamera camera;
    private Rectangle ball;
    private Rectangle leftPaddle;
    private Rectangle rightPaddle;
    public static int WIDTH_WINDOW = 1280;
    public static int HEIGHT_WINDOW = 720;
    public static int WIDTH_BALL = 25;
    public static int HEIGHT_BALL = 25;
    public static int WIDTH_PADDLE = 100;
    public static int HEIGHT_PADDLE = 100;
    public int STEPx;
    public int STEPy;


    public PinPong() {

    }

    @Override
    public void create() {
        background = new Texture("background3.jpg");
        imageBall = new Texture("ball.jpg");
        imageRightPaddle = new Texture("rightPaddle.jpg");
        imageLeftPaddle = new Texture("leftPaddle.jpg");

        camera = new OrthographicCamera();
        camera.setToOrtho(false, WIDTH_WINDOW, HEIGHT_WINDOW);

        batch = new SpriteBatch();

        ball = new Rectangle();
        ball.setPosition((WIDTH_WINDOW - WIDTH_BALL) / 2, (HEIGHT_WINDOW - HEIGHT_BALL) / 2);

        rightPaddle = new Rectangle();
        rightPaddle.setPosition(WIDTH_WINDOW - WIDTH_PADDLE, (HEIGHT_WINDOW - HEIGHT_PADDLE) / 2);

        leftPaddle = new Rectangle();
        leftPaddle.setPosition(0, (HEIGHT_WINDOW - HEIGHT_PADDLE) / 2);


//        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("backgroundSong.mp3"));
//        backgroundMusic.setLooping(true);
//        backgroundMusic.play();

    }

    @Override
    public void render() {
        camera.update();

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(background, 0, 0, WIDTH_WINDOW, HEIGHT_WINDOW);
        batch.draw(imageBall, ball.getX(), ball.getY());
        batch.draw(imageLeftPaddle, leftPaddle.getX(), leftPaddle.getY());
        batch.draw(imageRightPaddle, rightPaddle.getX(), rightPaddle.getY());
        batch.end();
        Random random = new Random();
        STEPx = random.nextInt(50)+ (-50);
        STEPy = random.nextInt(50) + (-50);
        ball.setPosition(ball.getX(), ball.getY());

            ball.x += 200 * Gdx.graphics.getDeltaTime();
            ball.y += 200 * Gdx.graphics.getDeltaTime();
        STEPx *= 0.15;
        STEPy *= 0.15;




        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            leftPaddle.setY(leftPaddle.getY() + 200 * Gdx.graphics.getDeltaTime());
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            leftPaddle.setY(leftPaddle.getY() - 200 * Gdx.graphics.getDeltaTime());
        }
        if (Gdx.input.isKeyPressed(Input.Keys.PAGE_UP)) {
            rightPaddle.setY(rightPaddle.getY() + 200 * Gdx.graphics.getDeltaTime());
        }
        if (Gdx.input.isKeyPressed(Input.Keys.PAGE_DOWN)) {
            rightPaddle.setY(rightPaddle.getY() - 200 * Gdx.graphics.getDeltaTime());
        }
        if (leftPaddle.getY() > HEIGHT_WINDOW - HEIGHT_PADDLE) {
            leftPaddle.setY(HEIGHT_WINDOW - HEIGHT_PADDLE);
        }
        if (leftPaddle.getY() < 0) {
            leftPaddle.setY(0);
        }
        if (rightPaddle.getY() > HEIGHT_WINDOW - HEIGHT_PADDLE) {
            rightPaddle.setY(HEIGHT_WINDOW - HEIGHT_PADDLE);
        }
        if (rightPaddle.getY() < 0) {
            rightPaddle.setY(0);
        }

    }

    @Override
    public void dispose() {
        batch.dispose();
        background.dispose();
        imageBall.dispose();
        imageLeftPaddle.dispose();
        imageRightPaddle.dispose();
        leftPaddle = null;
        rightPaddle = null;
//        backgroundMusic.dispose();
    }
}
