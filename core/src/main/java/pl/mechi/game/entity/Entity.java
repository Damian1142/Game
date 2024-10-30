package pl.mechi.game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Entity {

    Entity(int x, int y,int w, int h, int maxV, float acceleration, String path){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.maxV = maxV;
        this.acceleration = acceleration;
        if (path != null)
            image = new Texture(path);
    }
    public float x, y, w, h, maxV;
    public float Vx = 0, Vy = 0, acceleration;

    private Texture image;

    public void update(){


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

    }
    public void render(SpriteBatch sb, ShapeRenderer sr){

        sb.draw(image,x,y,w,h);
        sr.setColor(1,0,0,1);
        sr.rect(x,y,100,100);
    }

}
