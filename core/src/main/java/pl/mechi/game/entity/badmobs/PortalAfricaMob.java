package pl.mechi.game.entity.badmobs;

import pl.mechi.game.entity.Entity;
import pl.mechi.game.entity.spawner.SpawnerHandler;
import pl.mechi.game.object.GameObject;

import java.util.Iterator;

public class PortalAfricaMob extends BadMob {
    public PortalAfricaMob(float x, float y,SpawnerHandler sh) {
        super(x, y, 128, 128, x, y, 128, 128, 0, 0, "afpo.png", sh,4,4);
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
        get(0).x = x;
        get(0).y = y + 10;
    }
}
