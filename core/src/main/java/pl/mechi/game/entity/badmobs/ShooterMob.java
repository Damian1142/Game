package pl.mechi.game.entity.badmobs;

import pl.mechi.game.entity.spawner.SpawnerHandler;
import pl.mechi.game.object.GameObject;

import java.util.Iterator;

public class ShooterMob extends BadMob{
    public ShooterMob(float x, float y,SpawnerHandler sh) {
        super(x, y, 100, 100, x, y, 100,100 , 10,0, "badShooter.png", sh, 1, 1);
        tim1 = System.currentTimeMillis();
    }
    private long tim1;
    @Override
    public void update(Iterator<? extends GameObject> it) {
        super.update(it);
        if (System.currentTimeMillis() - tim1 > 5000){
            tim1 = System.currentTimeMillis();
            sh.spawnBadBullet(x,y,players.get(0).x + 50,players.get(0).y + 50);
        }
    }
}
