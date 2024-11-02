package pl.mechi.game.entity.badmobs;

import pl.mechi.game.entity.Entity;
import pl.mechi.game.entity.spawner.SpawnerHandler;

public class PortalAfricaMob extends BadMob {
    public PortalAfricaMob(float x, float y,SpawnerHandler sh) {
        super(x, y, 128, 128, x, y, 128, 128, 0, 0, "afpo.png", sh,4);
    }
}
