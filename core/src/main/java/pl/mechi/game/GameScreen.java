package pl.mechi.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import pl.mechi.game.entity.Entity;
import pl.mechi.game.entity.GameObjectInterface;
import pl.mechi.game.entity.Player;
import pl.mechi.game.entity.spawner.SpawnerHandler;

import java.util.ArrayList;

/** First screen of the application. Displayed after the application is created. */
public class GameScreen implements Screen {

    //public static boolean viewColliders = true;

    private SpriteBatch batch;
    private FitViewport viewport;
    private ShapeRenderer shape;
    public Player pl;
    private SpawnerHandler sh;
    public static ArrayList<Entity> aee;
    public static ArrayList<GameObjectInterface> ago;
    public long gameTime;
    private long startTime;
    private BitmapFont font;

    private Game game;
    public GameScreen(Game game){
        this.game = game;
    }

    @Override
    public void show() {
        // Prepare your screen here.
        batch = new SpriteBatch();
        shape = new ShapeRenderer();
        viewport = new FitViewport(1280, 720);
        sh = new SpawnerHandler();
        pl = new Player(100,100,100,100, 30, 2.5f, sh, this);
        aee = new ArrayList<>();
        ago = new ArrayList<>();
        viewport.update(1280, 720, true);
        Gdx.input.setInputProcessor(pl);
        font = new BitmapFont(Gdx.files.internal("Arial.fnt"));
        font.setUseIntegerPositions(false);
        font.getData().setScale(viewport.getWorldHeight() / Gdx.graphics.getHeight());
        startTime = System.currentTimeMillis();
    }

    @Override
    public void render(float delta) {
        update();
        viewport.apply();
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.setProjectionMatrix(viewport.getCamera().combined);
        shape.setProjectionMatrix(viewport.getCamera().combined);
        shape.setAutoShapeType(true);
        batch.begin();
        shape.begin();
        sh.render(batch,shape,null);
        pl.render(batch, shape, null);
        GlyphLayout glyphLayout = new GlyphLayout(font,"Points: " + pl.points);
        font.draw(batch,glyphLayout ,640 - glyphLayout.width / 2, 720 - (40 - glyphLayout.height / 2 ));
        shape.end();
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        // Resize your screen here. The parameters represent the new window size.
    }

    @Override
    public void pause() {
        // Invoked when your application is paused.
    }

    @Override
    public void resume() {
        // Invoked when your application is resumed after pause.
    }

    @Override
    public void hide() {
        // This method is called when another screen replaces this one.
    }

    @Override
    public void dispose() {
        // Destroy screen's assets here.
        batch.dispose();
        shape.dispose();
    }
    private long tim1 = 0;
    public void update(){
        gameTime = System.currentTimeMillis() - startTime;
        if (System.currentTimeMillis() - tim1 > 1000){
            tim1 = System.currentTimeMillis();
            System.out.println("FPS: " + Gdx.graphics.getFramesPerSecond());
            pl.points++;
        }
        sh.update();
        pl.update();
    }
    public void endOfGame(){
        game.setScreen(new EndScreen(this));
    }
}
