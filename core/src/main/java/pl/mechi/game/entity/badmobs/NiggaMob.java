package pl.mechi.game.entity.badmobs;

import pl.mechi.game.entity.Entity;
import pl.mechi.game.entity.spawner.SpawnerHandler;
import pl.mechi.game.object.GameObject;

import java.util.Iterator;

public class NiggaMob extends BadMob{
    public NiggaMob(float x, float y, SpawnerHandler sh) {
        super(x, y, 100, 100,x,y,90,100, 100, 2.5f, "nigger.png", sh,1,1);
    }

    @Override
    public void update(Iterator<? extends GameObject> it) {
        super.update(it);
    }
}
