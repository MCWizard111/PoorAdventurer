package com.mcwizard111.games.pooradventurer.player;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mcwizard111.games.pooradventurer.PoorAdventurer;
import com.mcwizard111.games.pooradventurer.screen.ScreenWorld;
import com.mcwizard111.games.pooradventurer.tile.TileSign;

/**
 * Created by mcwizard111 on 7/16/2014.
 */
public class Player extends InputAdapter {
    public Vector2 position = new Vector2();
    private SpriteBatch batch;

    public Player(int x, int y) {
        this.position.set(x, y);
    }

    public void render(int x, int y) {
        if (batch.isDrawing())
            batch.draw(getTexture(), x, y, 32, 32);
    }

    private Texture getTexture() {
        return PoorAdventurer.assetManager.get("player.png");
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.A:
                if (position.x > 1 && ScreenWorld.tiles[(int) position.y][(int) position.x-1].isReachable()) {
                    position.x--;
                    checkTile();
                }
                return false;
            case Input.Keys.D:
                if (position.x < ScreenWorld.tiles[(int) position.y].length-1 && ScreenWorld.tiles[(int) position.y][(int) position.x+1].isReachable()) {
                    position.x++;
                    checkTile();
                }
                return false;
            case Input.Keys.W:
                if (position.y < ScreenWorld.tiles[(int) position.y].length-1 && ScreenWorld.tiles[(int) position.y+1][(int) position.x].isReachable()) {
                    position.y++;
                    checkTile();
                }
                return false;
            case Input.Keys.S:
                if (position.y > 1 && ScreenWorld.tiles[(int) position.y-1][(int) position.x].isReachable()) {
                    position.y--;
                    checkTile();
                }
                return false;
            default:
                return false;
        }
    }

    public void checkTile() {
        if (ScreenWorld.tiles[(int) position.y][(int) position.x] instanceof TileSign) {
            ((TileSign)ScreenWorld.tiles[(int) position.y][(int) position.x]).activate(batch, (int) position.x, (int) position.y);
        }
    }

    public void setBatch(SpriteBatch batch) {
        this.batch = batch;
    }
}
