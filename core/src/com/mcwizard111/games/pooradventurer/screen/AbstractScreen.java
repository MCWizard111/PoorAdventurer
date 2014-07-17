package com.mcwizard111.games.pooradventurer.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mcwizard111.games.pooradventurer.PoorAdventurer;

public class AbstractScreen extends ScreenAdapter {
    protected PoorAdventurer game;
    protected OrthographicCamera camera;
    protected SpriteBatch batch;

    public AbstractScreen(PoorAdventurer game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false);

        batch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
        camera.update();
        batch.setProjectionMatrix(camera.combined);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
}
