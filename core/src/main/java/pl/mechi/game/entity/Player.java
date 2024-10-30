package pl.mechi.game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import pl.mechi.game.Main;

public class Player extends Entity{

    public Player( int x, int y, int w, int h, int maxV, float acceleration) {
        super(x, y, w, h, maxV, acceleration, "shooter.png");
    }

    @Override
    public void update() {
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

        if (Gdx.input.isKeyPressed(Input.Keys.ENTER)){
            Main.aee.add(new Bullet(x,y, 1280,720));
        }

        super.update();
    }
}
