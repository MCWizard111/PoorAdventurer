package com.mcwizard111.games.pooradventurer;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.mcwizard111.games.pooradventurer.screen.WorldScreen;

public class PoorAdventurer extends Game {
    public static AssetManager assetManager = new AssetManager();

    @Override
    public void create() {
        setScreen(new WorldScreen(this));
    }
}
