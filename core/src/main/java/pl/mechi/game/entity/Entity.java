package pl.mechi.game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import pl.mechi.game.colide.CollideBox;
import pl.mechi.game.object.GameObject;

import java.util.Iterator;

public class Entity extends GameObject {

    public Entity(float x, float y,int w, int h,float cx, float cy,int cw, int ch, int maxV, float acceleration, String path){
        super(x,y,w,h,cx,cy,cw,ch);
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
        collideBox.setXY(x,y);
        childUpdate();
    }
    public void render(SpriteBatch sb, ShapeRenderer sr,GameObjectInterface parent){

        if (parent == null){
            parent = GameObject.zero;
        }

        sb.draw(image,x + parent.getX(),y + parent.getY(),w,h);
        //sr.setColor(1,0,0,1);
        //sr.rect(collideBox.x,collideBox.y,collideBox.w,collideBox.h);
        super.render(sb,sr,this);
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
        return h;
    }

    @Override
    public float getW() {
        return w;
    }
    public void downHp(){
        hp--;
    }
    public void upHp(int hp){
        this.hp += hp;
    }
}
