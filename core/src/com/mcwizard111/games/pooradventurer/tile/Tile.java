package com.mcwizard111.games.pooradventurer.tile;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

/**
 * Created by mcwizard111 on 7/16/2014.
 */
public abstract class Tile {
    protected boolean reachable = true;

    public abstract void render(Batch batch, int x, int y);
    public abstract Texture getTexture();

    public Tile unreachable() {
        this.reachable = false;
        return this;
    }

    public boolean isReachable() {
        return reachable;
    }
}
