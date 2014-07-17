package com.mcwizard111.games.pooradventurer.tile;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.mcwizard111.games.pooradventurer.PoorAdventurer;
import com.mcwizard111.games.pooradventurer.screen.ScreenWorld;

/**
 * Created by mcwizard111 on 7/16/2014.
 */
public class TileSign extends Tile {
    private String text;
    private BitmapFont font;
    private Texture uisign;

    public TileSign(String text) {
        super();
        font = new BitmapFont();
        font.setColor(Color.GREEN);
        this.text = text;
        uisign = PoorAdventurer.assetManager.get("uisign.png");
    }

    @Override
    public void render(Batch batch, int x, int y) {
        batch.draw(getTexture(), x, y, 32, 32);
    }

    @Override
    public Texture getTexture() {
        return PoorAdventurer.assetManager.get("terrain/sign.png");
    }

    public void activate(SpriteBatch batch, int x, int y) {
        ScreenWorld.table.add(text).row().uniform().align(Align.left);
    }
}
