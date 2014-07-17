package com.mcwizard111.games.pooradventurer.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.mcwizard111.games.pooradventurer.PoorAdventurer;
import com.mcwizard111.games.pooradventurer.input.TileBasedMovementHandler;
import com.mcwizard111.games.pooradventurer.player.Player;
import com.mcwizard111.games.pooradventurer.tile.Tile;
import com.mcwizard111.games.pooradventurer.tile.TileGrass;
import com.mcwizard111.games.pooradventurer.tile.TileSign;

/**
 * Created by mcwizard111 on 7/16/2014.
 */
public class ScreenWorld extends AbstractScreen {
    public static Tile[][] tiles = new Tile[20][20];
    private Player player;
    public static Table table;
    public static ScrollPane scrollPane;

    public ScreenWorld(PoorAdventurer game) {
        super(game);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        camera.position.set(10 + 40 * player.position.x, 10 + 40 * (int) player.position.y, 0);
        camera.update();

        batch.begin();
        for (int y = 1; y < tiles.length; y++) {
            for (int x = 1; x < tiles[y].length; x++) {
                if (tiles[y][x] != null) {
                    tiles[y][x].render(batch, 10 + 32 * x, 10  + 32 * y);
                }
            }
        }

        player.render(10 + 32 * (int) player.position.x, 10 + 32 * (int) player.position.y);
        batch.end();

        stage.act(delta);
        stage.draw();
    }

    @Override
    public void show() {
        super.show();

        for (int y = 1; y < tiles.length; y++) {
            for (int x = 1; x < tiles[y].length; x++) {
                tiles[y][x] = new TileGrass();
            }
        }

        player = new Player(1, 1);
        player.setBatch(batch);
        inputMultiplexer.addProcessor(new TileBasedMovementHandler(player, camera));

        //setup set info tile
        tiles[1][1] = new TileSign("Welcome to Poor Adventurer.\nYou are THE hero of this story, and like most heroes\nYou start with nothing but your trusty...STICK");
        tiles[1][5] = new TileSign("This is my second test sign :D");
        tiles[2][2] = new TileGrass().unreachable();

        Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));

        table = new Table(skin);
        table.setFillParent(false);
        table.align(Align.left);

        scrollPane = new ScrollPane(table, skin);
        scrollPane.setPosition(10, 10);
        scrollPane.setHeight(80);
        scrollPane.setWidth(400);

        stage.addActor(scrollPane);
    }
}
