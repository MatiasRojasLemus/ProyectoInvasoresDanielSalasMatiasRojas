package com.aetxabao.invasoresfx.sprite;

import com.aetxabao.invasoresfx.util.Rect;
import javafx.scene.image.Image;

import static com.aetxabao.invasoresfx.game.AppConsts.*;

public class EnemyTower extends AEnemy{
    int N;//ticks para cambio de frame
    int n;
    Rect gameRect;

    public EnemyTower(Rect gameRect, Image img, int N){
        super(img,ENEMYTOWER_ROWS,ENEMYTOWER_COLS);
        this.gameRect = gameRect;
        xSpeed = ENEMYTOWER_MAX_SPEED;
        this.N = N;
        this.n = 0;
    }

    public void updateFrame(){
        if (++n==N) {
            n = 0;
            currentFrame = ++currentFrame % cols;
        }
    }

    @Override
    public Rect getRect(){
        return new Rect(x, y, (int)(x + ENEMYBARRIER_ALFA * width),(int)(y + ENEMYBARRIER_ALFA * height));
    }

    @Override
    public void update() {
        if (x > gameRect.right - width - xSpeed || x + xSpeed < gameRect.left) {
            xSpeed = -xSpeed;
        }
        x = x + xSpeed;
        this.updateFrame();
    }
}
