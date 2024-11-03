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
    private TextureRegion[] tr;
    BarType type;


    public HealthBar(float x, float y, Entity parent, BarType type) {
        super(x, y, 0, 0,0,0,0,0);
        if (type == BarType.PLAYER) {
            tr1 = new TextureRegion(new Texture("heart_filled.png"), 0, 0, 128, 128);
            tr2 = new TextureRegion(new Texture("heart_empty.png"), 0, 0, 128, 128);
        }else{
            tr = new TextureRegion[13];
            for (int i = 0; i < 11; i++){
                tr[i] = new TextureRegion(new Texture("hbar" + i + ".png"));
            }
            tr[11] = new TextureRegion(new Texture("hbar2.5.png"));
            tr[12] = new TextureRegion(new Texture("hbar7.5.png"));
        }
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
        }else {
            x = this.parent.x + 14;
            y = this.parent.y + this.parent.h + 10;
            if (this.parent.maxHp != this.parent.hp){
                switch (this.parent.maxHp){
                    case 10:{
                        break;
                    }
                    case 5:{
                        break;
                    }
                    case 4:{
                        switch (this.parent.hp){
                            case 3:{
                                sb.draw(tr[12],x,y);
                                break;
                            }
                            case 2:{
                                sb.draw(tr[6],x,y);
                                break;
                            }
                            case 1:{
                                sb.draw(tr[11],x,y);
                                break;
                            }
                        }
                        break;
                    }
                    case 2:{
                        break;
                    }
                }
            }
        }
    }
}
