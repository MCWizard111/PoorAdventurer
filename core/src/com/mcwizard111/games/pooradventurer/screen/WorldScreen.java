package com.mcwizard111.games.pooradventurer.screen;

import com.mcwizard111.games.pooradventurer.PoorAdventurer;
import com.mcwizard111.games.pooradventurer.tile.Tile;
import com.mcwizard111.games.pooradventurer.tile.TileGrass;

public class WorldScreen extends AbstractScreen {
    private Tile[][] tiles = new Tile[100][100];

    public WorldScreen(PoorAdventurer game) {
        super(game);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        batch.begin();
        for (int y = 1; y < tiles.length; y++) {
            for (int x = 1; x < tiles[y].length; x++) {
                tiles[y][x].render(batch, 100 + 35 * x, 100 + 35 * y);
            }
        }
        batch.end();
    }

    @Override
    public void show() {
        super.show();

        tiles[1][1] = new TileGrass();
    }
}