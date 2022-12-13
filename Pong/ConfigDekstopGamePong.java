package Pong;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.game.Pong;

import static Pong.PinPong.HEIGHT_WINDOW;
import static Pong.PinPong.WIDTH_WINDOW;

public class ConfigDekstopGamePong {


    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setWindowedMode(WIDTH_WINDOW, HEIGHT_WINDOW);
        config.useVsync(true);
        config.setTitle("Pong");
        config.setForegroundFPS(60);

        new Lwjgl3Application(new PinPong(), config);
    }
}
