package pl.mechi.game.colide;

public class CollideBox {

    public float x,y,w,h;

    public CollideBox(float x, float y, int w, int h) {
        this.x = x;
        this.h = h;
        this.y = y;
        this.w = w;
    }
    public boolean collide(CollideBox box){
        return x < box.x + box.w && y < box.y + box.h && x + w > box.x && y + h > box.y;
    }
    public void setXY(float x,float y){
        this.x = x;
        this.y = y;
    }
}
