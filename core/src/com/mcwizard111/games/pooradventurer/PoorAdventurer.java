package com.mcwizard111.games.pooradventurer;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.mcwizard111.games.pooradventurer.screen.ScreenWorld;

public class PoorAdventurer extends Game {
    public static AssetManager assetManager = new AssetManager();

    @Override
    public void create() {
        assetManager.load("terrain/grass.png", Texture.class);
        assetManager.load("terrain/sign.png", Texture.class);
        assetManager.load("uisign.png", Texture.class);
        assetManager.load("player.png", Texture.class);
        assetManager.finishLoading();

        setScreen(new ScreenWorld(this));
    }
}
