package pl.mechi.game.entity.bar;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import pl.mechi.game.entity.Entity;
import pl.mechi.game.entity.GameObjectInterface;
import pl.mechi.game.object.GameObject;

public class HealthBar extends GameObject {

    private TextureRegion tr1;
    private TextureRegion tr2;
    private Entity parent;
    BarType type;


    public HealthBar(float x, float y, Entity parent, BarType type) {
        super(x, y, 0, 0);
        tr1 = new TextureRegion(new Texture("heart_filled.png"),0,0,128,128);
        tr2 = new TextureRegion(new Texture("heart_empty.png"),0,0,128,128);
        this.parent = parent;
        this.type = type;
    }


    @Override
    public void update() {

    }

    @Override
    public void render(SpriteBatch sb, ShapeRenderer sr,GameObjectInterface parent) {
        if (type == BarType.PLAYER){
            switch (this.parent.hp){
                case 3: {
                    sb.draw(tr1,x,y);
                    sb.draw(tr1, x + 128,y);
                    sb.draw(tr1, x + 256,y);

                    break;
                }
                case 2:{
                    sb.draw(tr1,x,y);
                    sb.draw(tr1, x + 128,y);
                    sb.draw(tr2, x + 256,y);
                    break;
                }
                case 1:{
                    sb.draw(tr1,x,y);
                    sb.draw(tr2, x + 128,y);
                    sb.draw(tr2, x + 256,y);
                    break;
                }
                case 0: {
                    sb.draw(tr2,x,y);
                    sb.draw(tr2, x + 128,y);
                    sb.draw(tr2, x + 256,y);
                    break;
                }
            }
        }
    }
}
