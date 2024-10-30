package pl.mechi.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import pl.mechi.game.entity.Entity;
import pl.mechi.game.entity.Player;

import java.util.ArrayList;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    private SpriteBatch batch;
    private ShapeRenderer shape;
    private Texture image;
    private Player pl;
    public static ArrayList<Entity> aee;

    @Override
    public void create() {
        batch = new SpriteBatch();
        shape = new ShapeRenderer();
        image = new Texture("libgdx.png");
        pl = new Player(100,100,100,100, 30, 2.5f);
        aee = new ArrayList<>();
    }

    @Override
    public void render() {
        update();


        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        shape.setAutoShapeType(true);
        shape.begin();
        pl.render(batch, shape);
        for (Entity e : aee){
            e.render(batch,shape);
        }
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
        for (Entity e : aee){
            e.update();
        }
    }
}
