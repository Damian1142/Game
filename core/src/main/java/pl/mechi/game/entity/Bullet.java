package pl.mechi.game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import pl.mechi.game.Main;

import java.util.Iterator;

public class Bullet extends Entity implements GameObjectInterface{

    float xd, yd, ay, ax;

    double a, mW = 0;

    public Bullet(float x, float y, float xd, float yd) {
        super(x, y,0, 0, 0, 0,null);
        this.xd = xd;
        this.yd = yd;
        a = Math.abs(y - this.yd) / Math.abs(x - this.xd);
        ay = y - this.yd;
        ax = x - this.xd;
        image = new TextureRegion(new Texture("bullet.png"),0,0,32,32);
    }

    @Override
    public void render(SpriteBatch sb, ShapeRenderer sr) {

        float alfa = 0;

        if (ay < 0 && ax < 0){
            alfa = (float)Math.toDegrees(Math.atan(a)) - 90;
        } else if (ay > 0 && ax > 0) {
            alfa = (float)Math.toDegrees(Math.atan(a)) + 90;
        } else if (ay > 0 && ax < 0) {
            alfa = (float)Math.toDegrees(Math.atan(-a)) - 90;
        } else if (ay < 0 && ax > 0) {
            alfa = (float)Math.toDegrees(Math.atan(-a)) + 90;
        }

        sb.draw(image,x-16,y-16,16,16,32,32,1,1, alfa);
        //sb.draw(image,x,y,16,16,32,32,1,1,90,0,0,32,32,false,false);
        //sb.draw(tr.getTexture(),x,y);
        //sr.setColor(Color.BLUE);
        //sr.line(sx,sy,xd,yd);
    }

    @Override
    public void update(Iterator<Entity> it) {

        mW = 2000 * Gdx.graphics.getDeltaTime();
        double xt;


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
        //y += Math.sqrt(Math.pow());
        //System.out.println("X: " + x + " Y: " + y);
        if (x < 0 || x > 1280 || y < 0 || y > 720){
            it.remove();
        }

    }
}
