package pl.mechi.game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import pl.mechi.game.Main;
import pl.mechi.game.entity.spawner.SpawnerHandler;

import java.util.Iterator;

public class Player extends Entity implements InputProcessor {

    int mx = 0, my = 0;
    private TextureRegion tr;
    private SpawnerHandler sh;
    public int points;

    public Player( int x, int y, int w, int h, int maxV, float acceleration, SpawnerHandler sh) {
        super(x, y, w, h, maxV, acceleration, "shooter.png");
        tr = new TextureRegion(image,0,0,100,100);
        this.sh = sh;
        sh.players.add(this);
        points = 0;
    }

    @Override
    public void render(SpriteBatch sb, ShapeRenderer sr) {

        float alfa = (float)Math.toDegrees(Math.atan2((y - 720 + my + 55) , (x - mx + 49))) + 90;

        sb.draw(tr,x,y,49,55,100,100,1,1, alfa);
    }

    @Override
    public void update(Iterator<Entity> it) {
        if (Gdx.input.isKeyPressed(Input.Keys.S) && Vy > -maxV){
            Vy -= acceleration * Gdx.graphics.getDeltaTime() * 10000;
        }else if (Gdx.input.isKeyPressed(Input.Keys.W) && Vy < maxV){
            Vy += acceleration * Gdx.graphics.getDeltaTime() * 10000;
        } else if (Vy > 0) {
            Vy -= acceleration * Gdx.graphics.getDeltaTime() * 10000;
            if (Vy < 0){
                Vy = 0;
            }
        }else if (Vy != 0){
            Vy += acceleration * Gdx.graphics.getDeltaTime() * 10000;
            if (Vy > 0){
                Vy = 0;
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.A) && Vx > -maxV){
            Vx -= acceleration * Gdx.graphics.getDeltaTime() * 10000;
        }else if (Gdx.input.isKeyPressed(Input.Keys.D) && Vx < maxV){
            Vx += acceleration * Gdx.graphics.getDeltaTime() * 10000;
        } else if (Vx > 0) {
            Vx -= acceleration * Gdx.graphics.getDeltaTime() * 10000;
            if (Vx < 0){
                Vx = 0;
            }
        }else if (Vx != 0){
            Vx += acceleration * Gdx.graphics.getDeltaTime() * 10000;
            if (Vx < 0){
                Vx = 0;
            }
        }

        if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
            sh.spawnBullet(x + 49,y + 55,Gdx.input.getX(),720 - Gdx.input.getY());
            //System.out.println(Gdx.input.getX() + " " + Gdx.input.getY());
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
