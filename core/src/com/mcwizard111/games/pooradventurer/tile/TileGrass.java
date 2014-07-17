package com.mcwizard111.games.pooradventurer.tile;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.mcwizard111.games.pooradventurer.PoorAdventurer;

/**
 * Created by mcwizard111 on 7/16/2014.
 */
public class TileGrass extends Tile {
    @Override
    public void render(Batch batch, int x, int y) {
        batch.draw(getTexture(), x, y, 32, 32);
    }

    @Override
    public Texture getTexture() {
        return PoorAdventurer.assetManager.get("terrain/grass.png");
    }
}
