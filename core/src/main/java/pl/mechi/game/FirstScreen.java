package pl.mechi.game;

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
public class FirstScreen implements Screen {


    private SpriteBatch batch;
    private FitViewport viewport;
    private ShapeRenderer shape;
    private Texture image;
    private Player pl;
    private SpawnerHandler sh;
    public static ArrayList<Entity> aee;
    public static ArrayList<GameObjectInterface> ago;
    public static long gameTime;
    private long startTime;
    private BitmapFont font;


    @Override
    public void show() {
        // Prepare your screen here.
        batch = new SpriteBatch();
        shape = new ShapeRenderer();
        viewport = new FitViewport(1280, 720);
        image = new Texture("libgdx.png");
        sh = new SpawnerHandler();
        pl = new Player(100,100,100,100, 30, 2.5f, sh);
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
        //shape.setProjectionMatrix(viewport.getCamera().combined);
        //shape.setAutoShapeType(true);
        batch.begin();
        //shape.begin();
        sh.render(batch,shape);
        pl.render(batch, shape);
        GlyphLayout glyphLayout = new GlyphLayout(font,"Punkty: " + (pl.points + gameTime / 1000));
        font.draw(batch,glyphLayout ,640 - glyphLayout.width / 2, 720 - (40 - glyphLayout.height / 2 ));
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
        image.dispose();
        shape.dispose();
    }

    public void update(){
        gameTime = System.currentTimeMillis() - startTime;
        sh.update();
        pl.update();
    }
}
