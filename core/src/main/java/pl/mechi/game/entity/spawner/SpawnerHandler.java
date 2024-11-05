package pl.mechi.game.entity.spawner;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import pl.mechi.game.entity.*;
import pl.mechi.game.entity.badmobs.NiggaMob;
import pl.mechi.game.entity.badmobs.PortalAfricaMob;
import pl.mechi.game.entity.badmobs.ShooterMob;
import pl.mechi.game.object.GameObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class SpawnerHandler extends GameObject {

    public final ArrayList<Entity> ase;
    public final ArrayList<Player> players;
    public final ArrayList<Entity> abl;
    public final ArrayList<Entity> ablb;
    public final ArrayList<Entity> apr;
    long time;

    public SpawnerHandler(){
        super(0,0,0,0,0,0,0,0);
        ase = new ArrayList<>();
        abl = new ArrayList<>();
        ablb = new ArrayList<>();
        apr = new ArrayList<>();
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
        for (Iterator<Entity> it = apr.iterator(); it.hasNext();) {
            it.next().update(it);
        }
        for (Iterator<Entity> it = ablb.iterator(); it.hasNext();) {
            it.next().update(it);
        }
        spawn();
    }

    @Override
    public void render(SpriteBatch sb, ShapeRenderer sr,GameObjectInterface parent) {
        abl.forEach(e -> e.render(sb,sr,null));
        ablb.forEach(e -> e.render(sb,sr,null));
        ase.forEach(e -> e.render(sb,sr,null));
        apr.forEach(e -> e.render(sb,sr,null));
    }

    public void spawnBullet(float x, float y, float xd, float yd){
        abl.add(new Bullet(x,y,xd,yd,2000));
    }
    public void spawnBadBullet(float x, float y, float xd, float yd){
        ablb.add(new Bullet(x,y,xd,yd,500));
    }
    private void spawn(){
        if (System.currentTimeMillis() - time > 100) {
            time = System.currentTimeMillis();
            Random random = new Random();
            int r = random.nextInt(100);
            if (r < 20 && !apr.isEmpty()) {
                int a;
                for (int i = 0; i < apr.size() / 2; i++) {
                    a = random.nextInt(apr.size());
                    ase.add(new NiggaMob(apr.get(a).x, apr.get(a).y, this));
                }
            }
            if (r < 2 && !apr.isEmpty() && false) {
                int a = random.nextInt(apr.size());
                ase.add(new ShooterMob(apr.get(a).x, apr.get(a).y, this));
            }
            if (r < 5){
                apr.add(new PortalAfricaMob(random.nextInt(1000), random.nextInt(600), this));
                int a = random.nextInt(apr.size());
                ase.add(new NiggaMob(apr.get(a).x, apr.get(a).y, this));
            }
        }
    }
}
