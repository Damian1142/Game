package pl.mechi.game.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Entity {

    Entity(Texture tx, int x, int y,int w, int h){
        image = tx;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    public int x, y, w, h;
    public float Vx, Vy;

    private Texture image;

    public void update(){

    }
    public void render(SpriteBatch sb){

        sb.draw(image,x,y,w,h);
    }

}
