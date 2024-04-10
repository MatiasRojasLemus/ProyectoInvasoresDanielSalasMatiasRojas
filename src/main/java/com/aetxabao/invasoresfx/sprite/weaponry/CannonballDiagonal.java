package com.aetxabao.invasoresfx.sprite.weaponry;

import com.aetxabao.invasoresfx.util.Rect;
import javafx.scene.image.Image;

public class CannonballDiagonal extends Cannonball{
    Rect gameRect;
    public CannonballDiagonal(Rect gameRect, Image img){
        super(img);
        setXSpeed(1);
        setYSpeed(2);
        this.gameRect = gameRect;
    }

    public void update() {
        if (x > gameRect.right - width - xSpeed || x + xSpeed < gameRect.left) {
            xSpeed = -xSpeed;
        }
        x = x + xSpeed;
        y = y + ySpeed;
    }
}
