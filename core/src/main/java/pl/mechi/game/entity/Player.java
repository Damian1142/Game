package pl.mechi.game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import pl.mechi.game.screens.GameScreen;
import pl.mechi.game.entity.bar.BarType;
import pl.mechi.game.entity.bar.HealthBar;
import pl.mechi.game.entity.spawner.SpawnerHandler;
import pl.mechi.game.object.GameObject;

import java.util.Iterator;

public class Player extends Entity implements InputProcessor {

    int mx = 0, my = 0;
    private TextureRegion tr;
    private SpawnerHandler sh;
    public int points;
    GameScreen gs;

    public Player( int x, int y, int w, int h, int maxV, float acceleration, SpawnerHandler sh,GameScreen gs) {
        super(x, y, w, h,x,y,w,h, maxV, acceleration, "shooter.png");
        tr = new TextureRegion(image,0,0,100,100);
        this.sh = sh;
        this.gs = gs;
        sh.players.add(this);
        points = -1;
        hp = 3;
        add(new HealthBar(860,600,this, BarType.PLAYER));
    }

    @Override
    public void render(SpriteBatch sb, ShapeRenderer sr, GameObjectInterface parent) {



        float alfa = (float)Math.toDegrees(Math.atan2((y - 720 + my + 55) , (x - mx + 49))) + 90;

        sb.draw(tr,x,y,49,55,100,100,1,1, alfa);

        //sr.rect(collideBox.x,collideBox.y,collideBox.w,collideBox.h);
        childRender(sb,sr,this);
    }
    private long tim1;
    @Override
    public void update(Iterator<? extends GameObject> it) {
        if (Gdx.input.isKeyPressed(Input.Keys.S) && Vy > -maxV){
            Vy -= acceleration * Gdx.graphics.getDeltaTime() * 100;
        }else if (Gdx.input.isKeyPressed(Input.Keys.W) && Vy < maxV){
            Vy += acceleration * Gdx.graphics.getDeltaTime() * 100;
        } else if (Vy > 0) {
            Vy -= acceleration * Gdx.graphics.getDeltaTime() * 100;
            if (Vy < 0){
                Vy = 0;
            }
        }else if (Vy != 0){
            Vy += acceleration * Gdx.graphics.getDeltaTime() * 100;
            if (Vy > 0){
                Vy = 0;
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.A) && Vx > -maxV){
            Vx -= acceleration * Gdx.graphics.getDeltaTime() * 100;
        }else if (Gdx.input.isKeyPressed(Input.Keys.D) && Vx < maxV){
            Vx += acceleration * Gdx.graphics.getDeltaTime() * 100;
        } else if (Vx > 0) {
            Vx -= acceleration * Gdx.graphics.getDeltaTime() * 100;
            if (Vx < 0){
                Vx = 0;
            }
        }else if (Vx != 0){
            Vx += acceleration * Gdx.graphics.getDeltaTime() * 100;
            if (Vx > 0){
                Vx = 0;
            }
        }
        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            sh.spawnBullet(x + 49,y + 55,Gdx.input.getX(),Gdx.graphics.getHeight() - Gdx.input.getY());
            //System.out.println(Gdx.input.getX() + " " + Gdx.input.getY());
            tim1 = System.currentTimeMillis() + 80;
        }else if (Gdx.input.isButtonPressed(Input.Buttons.LEFT) && System.currentTimeMillis() - tim1 > 200){
            tim1 = System.currentTimeMillis();
            sh.spawnBullet(x + 49,y + 55,Gdx.input.getX(),Gdx.graphics.getHeight() - Gdx.input.getY());
        }

        for (Iterator<Entity> it2 = sh.ablb.iterator(); it2.hasNext();) {
            Entity e = it2.next();
            if (e.collideBox.collide(collideBox)){
                it2.remove();
                downHp();
            }
        }
        if (hp < 1){
            gs.endOfGame();
        }

        super.update(it);
    }

    @Override
    public boolean keyDown(int i) {
        return false;
    }

    @Override
    public boolean keyUp(int i) {
        return false;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchCancelled(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        mx = i;
        my = i1;
        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        mx = i;
        my = i1;
        return false;
    }

    @Override
    public boolean scrolled(float v, float v1) {
        return false;
    }
}
