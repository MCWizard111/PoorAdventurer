package com.mcwizard111.games.pooradventurer.tile;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public abstract class Tile {
    public Tile() {

    }

    public abstract void render(Batch batch, int x, int y);

    public abstract Texture getTexture();
}
