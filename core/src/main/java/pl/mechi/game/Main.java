package pl.mechi.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import pl.mechi.game.entity.Entity;
import pl.mechi.game.entity.Player;

import java.util.ArrayList;
import java.util.Iterator;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    private SpriteBatch batch;
    FitViewport viewport;
    private ShapeRenderer shape;
    private Texture image;
    private Player pl;
    public static ArrayList<Entity> aee;

    @Override
    public void create() {
        batch = new SpriteBatch();
        shape = new ShapeRenderer();
        viewport = new FitViewport(1280, 720);
        image = new Texture("libgdx.png");
        pl = new Player(100,100,100,100, 30, 2.5f);
        aee = new ArrayList<>();
        viewport.update(1280, 720, true);
        Gdx.input.setInputProcessor(pl);
    }

    @Override
    public void render() {
        update();

        viewport.apply();
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.setProjectionMatrix(viewport.getCamera().combined);
        shape.setProjectionMatrix(viewport.getCamera().combined);
        shape.setAutoShapeType(true);
        batch.begin();
        shape.begin();
        for (Entity e : aee){
            e.render(batch,shape);
        }
        pl.render(batch, shape);
        batch.end();
        shape.end();

    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
        shape.dispose();
    }
    public void update(){
        pl.update();
        for (Iterator<Entity> it = aee.iterator(); it.hasNext();) {
            it.next().update(it);
        }
    }
}
