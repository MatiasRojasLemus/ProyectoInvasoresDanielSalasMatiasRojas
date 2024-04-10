package com.aetxabao.invasoresfx.sprite;

import com.aetxabao.invasoresfx.util.Rect;
import javafx.scene.image.Image;

import static com.aetxabao.invasoresfx.game.AppConsts.*;

public class EnemyTower extends AEnemy{
    Rect gameRect;

    public EnemyTower(Rect gameRect, Image img){
        super(img,ENEMYTOWER_ROWS,ENEMYTOWER_COLS);
        this.gameRect = gameRect;
        xSpeed = ENEMYTOWER_MAX_SPEED;
    }

    @Override
    public void update() {
        if (x > gameRect.right - width - xSpeed || x + xSpeed < gameRect.left) {
            xSpeed = -xSpeed;
        }
    }
}
