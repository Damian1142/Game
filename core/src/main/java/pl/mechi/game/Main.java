package pl.mechi.game;

import com.badlogic.gdx.Game;
import pl.mechi.game.screens.ClickToPlayScreen;
import pl.mechi.game.screens.GameScreen;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {


    @Override
    public void create() {
        setScreen(new ClickToPlayScreen(this));

    }
}
