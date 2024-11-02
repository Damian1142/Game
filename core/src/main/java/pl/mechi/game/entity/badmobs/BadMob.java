package pl.mechi.game.entity.badmobs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import pl.mechi.game.Main;
import pl.mechi.game.entity.Entity;
import pl.mechi.game.entity.GameObjectInterface;
import pl.mechi.game.entity.Player;
import pl.mechi.game.entity.spawner.SpawnerHandler;
import pl.mechi.game.object.GameObject;

import java.util.ArrayList;
import java.util.Iterator;

public class BadMob extends Entity {

    private ArrayList<Player> players;
    SpawnerHandler sh;

    public BadMob(float x, float y, int w, int h,float cx, float cy,int cw, int ch, int maxV, float acceleration, String path, SpawnerHandler sh, int hp) {
        super(x, y, w, h,cx,cy,cw,ch, maxV, acceleration, path);
        this.sh = sh;
        players = sh.players;
        this.hp = hp;
    }

    @Override
    public void update(Iterator<? extends GameObject> it) {
        for (Iterator<Entity> it2 = sh.abl.iterator(); it2.hasNext();) {
            Entity e = it2.next();
            if (e.collideBox.collide(collideBox)){
                it2.remove();
                downHp();
                if(hp < 1) {
                    it.remove();
                    players.get(0).points++;
                }
            }
        }
        if (players.get(0).collideBox.collide(collideBox)){
            players.get(0).downHp();
            it.remove();
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
}
