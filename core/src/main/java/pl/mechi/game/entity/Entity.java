package pl.mechi.game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import pl.mechi.game.colide.CollideInterface;
import pl.mechi.game.object.GameObject;

import java.util.Iterator;

public class Entity extends GameObject implements CollideInterface {

    public Entity(float x, float y,int w, int h, int maxV, float acceleration, String path){
        super(x,y,w,h);
        this.maxV = maxV;
        this.acceleration = acceleration;
        if (path != null)
            image = new TextureRegion(new Texture(path),0,0,w,h);
    }
    public float maxV;
    public float Vx = 0, Vy = 0, acceleration;
    public int hp;

    protected TextureRegion image;

    public void update(Iterator<? extends GameObject> it){


        x += Vx * Gdx.graphics.getDeltaTime();
        if (x < 0){
            x = 0;
            //Vx = -Vx;
        } else if (x > 1280 - w) {
            x = 1280 - w;
            //Vx = -Vx;
        }
        y += Vy * Gdx.graphics.getDeltaTime();
        if (y < 0){
            y = 0;
            //Vy = -Vy;
        } else if (y > 720 - h) {
            y = 720 - h;
            //Vy = -Vy;
        }
        childUpdate();
    }
    public void render(SpriteBatch sb, ShapeRenderer sr,GameObjectInterface parent){

        if (parent == null){
            parent = GameObject.zero;
        }

        sb.draw(image,x + parent.getX(),y + parent.getY(),w,h);
        //sr.setColor(1,0,0,1);
        //sr.rect(x,y,100,100);
        super.render(sb,sr,this);
    }


    @Override
    public boolean collide(CollideInterface cl) {
        //return new Rectangle((int)x,(int)y,(int)w,(int)h).contains(new Rectangle((int)cl.getX(),(int)cl.getY(),(int)cl.getW(),(int)cl.getH()));
        return x > cl.getX() && x < cl.getX() + cl.getW() && y > cl.getY() && y < cl.getY() + cl.getH();
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public float getH() {
        return w;
    }

    @Override
    public float getW() {
        return h;
    }
    public void downHp(){
        hp--;
    }
    public void upHp(int hp){
        this.hp += hp;
    }
}
