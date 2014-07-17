package com.mcwizard111.games.pooradventurer.input;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.mcwizard111.games.pooradventurer.player.Player;
import com.mcwizard111.games.pooradventurer.screen.ScreenWorld;

/**
 * Created by mcwizard111 on 7/17/2014.
 */
public class TileBasedMovementHandler extends InputAdapter {
    private Player player;
    private OrthographicCamera camera;

    public TileBasedMovementHandler(Player player, OrthographicCamera camera) {
        this.player = player;
        this.camera = camera;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        Vector3 mousePos = new Vector3(screenX, screenY, 0);
        camera.unproject(mousePos);

        Rectangle mouseRect = new Rectangle(mousePos.x, mousePos.y, 2, 2);

        Rectangle tileLeft = null;
        if (player.position.x-1 > 0) {
            tileLeft = new Rectangle(10 + 32 * player.position.y, 10 + 32 * (player.position.x - 1), 32, 32);
        }

        Rectangle tileRight = new Rectangle(10 + 32 * player.position.y, 10 + 32 * (player.position.x+1), 32, 32);
        Rectangle tileTop = new Rectangle(10 + 32 * (player.position.y+1), 10 + 32 * player.position.x, 32, 32);

        Rectangle tileBottom = null;
        if (player.position.y-1 > 0) {
            tileBottom = new Rectangle(10 + 32 * (player.position.y-1), 10 + 32 * player.position.x, 32, 32);
        }

        if (tileLeft != null && tileLeft.contains(mouseRect)) {
            player.position.x--;
        } else if (tileRight.contains(mouseRect)) {
            player.position.x++;
        } else if (tileTop.contains(mouseRect)) {
            player.position.y++;
        } else if (tileBottom != null && tileBottom.contains(mouseRect)) {
            player.position.y--;
        }

        return false;
    }
}
