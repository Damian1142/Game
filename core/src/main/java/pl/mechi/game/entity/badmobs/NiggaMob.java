package pl.mechi.game.entity.badmobs;

import pl.mechi.game.entity.Entity;
import pl.mechi.game.entity.spawner.SpawnerHandler;

import java.util.Iterator;

public class NiggaMob extends BadMob{
    public NiggaMob(float x, float y, SpawnerHandler sh) {
        super(x, y, 100, 100, 25, 2.5f, "nigger.png", sh);
    }

    @Override
    public void update(Iterator<Entity> it) {
        super.update(it);

    }
}
