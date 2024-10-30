package pl.mechi.game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Bullet extends Entity{

    float xd, yd, a, sx, sy, xt = 0, yt = 0;


    public Bullet(float x, float y, int xd, int yd) {
        super((int)x, (int)y,0, 0, 0, 0,null);
        this.xd = xd;
        this.yd = yd;
        a = (x - xd) / (y - yd);
        sx = x;
        sy = y;

    }

    @Override
    public void render(SpriteBatch sb, ShapeRenderer sr) {
        sr.setColor(0.8f, 0.8f,0,1);
        sr.circle(x,y,20);
    }

    @Override
    public void update() {
        y = a * xt + sy;
        x = xt + sx;

        xt += 10 * Gdx.graphics.getDeltaTime();

    }
}
