package pl.mechi.game.entity.spawner;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import pl.mechi.game.entity.*;
import pl.mechi.game.entity.badmobs.NiggaMob;
import pl.mechi.game.object.GameObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class SpawnerHandler extends GameObject {

    public final ArrayList<Entity> ase;
    public final ArrayList<Player> players;
    public final ArrayList<Entity> abl;
    long time;

    public SpawnerHandler(){
        super(0,0,0,0,0,0,0,0);
        ase = new ArrayList<>();
        abl = new ArrayList<>();
        players = new ArrayList<>();
        time = System.currentTimeMillis();
    }

    @Override
    public void update() {
        for (Iterator<Entity> it = abl.iterator(); it.hasNext();) {
            it.next().update(it);
        }
        for (Iterator<Entity> it = ase.iterator(); it.hasNext();) {
            it.next().update(it);
        }
        spawn();
    }

    @Override
    public void render(SpriteBatch sb, ShapeRenderer sr,GameObjectInterface parent) {
        abl.forEach(e -> e.render(sb,sr,null));
        ase.forEach(e -> e.render(sb,sr,null));
    }

    public void spawnBullet(float x, float y, float xd, float yd){
        abl.add(new Bullet(x,y,xd,yd));
    }
    private void spawn(){
        if (System.currentTimeMillis() - time > 100) {
            time = System.currentTimeMillis();
            Random random = new Random();
            int r = random.nextInt(100);
            if (r < 20) {
                ase.add(new NiggaMob(random.nextInt(1000), random.nextInt(600), this));
            }
        }
    }
}
