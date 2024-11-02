package pl.mechi.game.colide;

public interface CollideInterface {

    boolean collide(CollideInterface cl);

    float getX();
    float getY();
    float getH();
    float getW();

}
