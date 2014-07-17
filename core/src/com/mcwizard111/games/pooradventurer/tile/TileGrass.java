package com.mcwizard111.games.pooradventurer.tile;

import com.badlogic.gdx.graphics.Texture;
import com.mcwizard111.games.pooradventurer.PoorAdventurer;

public class TileGrass extends AbstractTile {
    public TileGrass() {
        super();
    }

    @Override
    public Texture getTexture() {
        return PoorAdventurer.assetManager.get("terrain/grass.png", Texture.class);
    }
}
