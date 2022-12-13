package Pong;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class PinPong extends ApplicationAdapter {
    private Texture background;
    private Texture ball;
    private Texture rightPaddle;
    private Texture leftPaddle;
    private SpriteBatch batch;
    private Music backgroundMusic;
    public static int WIDTH_WINDOW = 1280;
    public static int HEIGHT_WINDOW = 720;

    public PinPong() {

    }

    @Override
    public void create() {
        batch = new SpriteBatch();
        background = new Texture("background3.jpg");
        ball = new Texture("ball.jpg");
        rightPaddle = new Texture("rightPaddle.jpg");
        leftPaddle = new Texture("leftPaddle.jpg");
        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("backgroundSong.mp3"));
        backgroundMusic.setLooping(true);
        backgroundMusic.play();

    }

    @Override
    public void render() {
        batch.begin();
        batch.draw(background, 0, 0, WIDTH_WINDOW, HEIGHT_WINDOW);
        batch.draw(ball, WIDTH_WINDOW / 2, (HEIGHT_WINDOW - 50) / 2, 50, 50);
        batch.draw(leftPaddle, 0, HEIGHT_WINDOW / 2, 100, 100);
        batch.draw(rightPaddle, WIDTH_WINDOW - 100, HEIGHT_WINDOW / 2, 100, 100);
        batch.end();

    }

    @Override
    public void dispose() {
        batch.dispose();
        background.dispose();
    }
}
