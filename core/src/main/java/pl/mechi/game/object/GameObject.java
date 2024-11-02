package pl.mechi.game.object;

import pl.mechi.game.entity.GameObjectInterface;

import java.util.ArrayList;

public abstract class GameObject extends ArrayList<GameObjectInterface> implements GameObjectInterface {


    public float x, y, w, h;

    protected void childUpdate(){

    }
    protected void childRender(){

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
}
