package pl.mechi.game.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public interface GameObjectInterface {

    void update();
    void render(SpriteBatch sb, ShapeRenderer sr,GameObjectInterface parent);

    float getX();
    float getY();
    float getH();
    float getW();

}
