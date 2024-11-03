package pl.mechi.game.object;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import pl.mechi.game.colide.CollideBox;
import pl.mechi.game.entity.GameObjectInterface;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class GameObject extends ArrayList<GameObject> implements GameObjectInterface {

    public static GameObjectInterface zero;
    public float x, y, w, h;
    public CollideBox collideBox;


    public GameObject(float x, float y,int w, int h,float cx, float cy,int cw, int ch){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        collideBox = new CollideBox(cx,cy,cw,ch);
    }

    protected void childUpdate(){
        for (Iterator<GameObject> it = this.iterator(); it.hasNext();) {
            it.next().update(it);
        }
    }
    protected void childRender(SpriteBatch sb, ShapeRenderer sr, GameObjectInterface parent){
        this.forEach(g -> g.render(sb,sr,parent));
    }

    @Override
    public float getW() {
        return 0;
    }

    @Override
    public float getH() {
        return 0;
    }

    @Override
    public float getY() {
        return 0;
    }

    @Override
    public float getX() {
        return 0;
    }

    public void update(){update(null);}

    public void update(Iterator<? extends GameObject> it){
        childUpdate();
    }
    public void render(SpriteBatch sb, ShapeRenderer sr,GameObjectInterface parent){
        childRender(sb,sr,parent);
    }

    static {
        zero = new GameObjectInterface() {
            @Override
            public void update() {

            }

            @Override
            public void render(SpriteBatch sb, ShapeRenderer sr, GameObjectInterface parent) {

            }

            @Override
            public float getX() {
                return 0;
            }

            @Override
            public float getY() {
                return 0;
            }

            @Override
            public float getH() {
                return 0;
            }

            @Override
            public float getW() {
                return 0;
            }
        };
    }
}
