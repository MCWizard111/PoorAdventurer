package com.mcwizard111.games.pooradventurer.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mcwizard111.games.pooradventurer.PoorAdventurer;

/**
 * Created by mcwizard111 on 7/16/2014.
 */
public class AbstractScreen extends ScreenAdapter {
    protected PoorAdventurer game;
    protected OrthographicCamera camera;
    protected InputMultiplexer inputMultiplexer;
    protected SpriteBatch batch;
    protected Stage stage;

    public AbstractScreen(PoorAdventurer game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false);
        camera.update();
        stage = new Stage();
        inputMultiplexer = new InputMultiplexer();

        batch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
        camera.update();
        batch.setProjectionMatrix(camera.combined);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(inputMultiplexer);
        inputMultiplexer.addProcessor(stage);
    }
}
