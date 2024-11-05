package pl.mechi.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class EndScreen implements Screen {

    private BitmapFont font;
    private SpriteBatch batch;

    GameScreen gs;
    public EndScreen(GameScreen gs){
        this.gs = gs;
    }
    private long startTime;
    @Override
    public void show() {

        font = new BitmapFont(Gdx.files.internal("Arial.fnt"));
        font.setUseIntegerPositions(false);
        startTime = System.currentTimeMillis();
        batch = new SpriteBatch();
    }
    @Override
    public void render(float delta) {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        GlyphLayout glyphLayout = new GlyphLayout(font,"You Ded");
        font.draw(batch,glyphLayout ,640 - glyphLayout.width / 2, 720 - (40 - glyphLayout.height / 2 ));
        GlyphLayout glyphLayout2;
        if (((System.currentTimeMillis() - startTime)) / 10 <= gs.pl.points) {
            glyphLayout2 = new GlyphLayout(font, "Points: " + ((System.currentTimeMillis() - startTime) / 10));
        }
        else {
            glyphLayout2 = new GlyphLayout(font, "Points: " + gs.pl.points);
        }
        font.draw(batch,glyphLayout2 ,640 - glyphLayout2.width / 2, 720 - (100 - glyphLayout2.height / 2 ));
        GlyphLayout glyphLayout3;
        if (((System.currentTimeMillis() - startTime)) / 10 > gs.pl.points && ((System.currentTimeMillis() - startTime)) / 100 <= gs.gameTime / 1000) {
            glyphLayout3 = new GlyphLayout(font, "Game Time: " + ((System.currentTimeMillis() - startTime) / 100) + "s");
        }
        else if (((System.currentTimeMillis() - startTime)) / 10 < gs.pl.points){
            glyphLayout3 = new GlyphLayout(font, "Game Time: ");
        }else {
            glyphLayout3 = new GlyphLayout(font, "Game Time: " + gs.gameTime / 1000 + "s");
        }
        font.draw(batch,glyphLayout3 ,640 - glyphLayout3.width / 2, 720 - (160 - glyphLayout3.height / 2 ));
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
