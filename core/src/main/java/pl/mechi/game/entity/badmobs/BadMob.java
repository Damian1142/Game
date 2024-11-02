package pl.mechi.game.entity.badmobs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import pl.mechi.game.Main;
import pl.mechi.game.entity.Entity;
import pl.mechi.game.entity.Player;
import pl.mechi.game.entity.spawner.SpawnerHandler;

import java.util.ArrayList;
import java.util.Iterator;

public class BadMob extends Entity {

    private ArrayList<Player> players;
    SpawnerHandler sh;

    public BadMob(float x, float y, int w, int h, int maxV, float acceleration, String path, SpawnerHandler sh) {
        super(x, y, w, h, maxV, acceleration, path);
        this.sh = sh;
        players = sh.players;
    }

    @Override
    public void update(Iterator<Entity> it) {
        for (Iterator<Entity> it2 = sh.abl.iterator(); it2.hasNext();) {
            Entity e = it2.next();
            if (e.collide(this)){
                it.remove();
                it2.remove();
                players.get(0).points++;
            }
        }

        float mW = 100 * Gdx.graphics.getDeltaTime();
        double xt;
        double ax = x - players.get(0).x;
        double ay = y - players.get(0).y;
        double a = Math.abs(ay) / Math.abs(ax);

        xt = (float)Math.sqrt((mW * mW) / ((a * a) + 1));

        if (ay >= 0) {
            y -= a * xt;
        } else {
            y += a * xt;
        }
        if (ax >= 0) {
            x -= xt;
        } else {
            x += xt;
        }
        super.update(it);
    }

    @Override
    public void render(SpriteBatch sb, ShapeRenderer sr) {
        sb.draw(image,x,y);
    }
}
