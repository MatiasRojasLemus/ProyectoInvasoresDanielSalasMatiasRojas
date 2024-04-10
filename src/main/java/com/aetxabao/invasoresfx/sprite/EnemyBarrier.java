package com.aetxabao.invasoresfx.sprite;

import com.aetxabao.invasoresfx.sprite.weaponry.AShot;
import com.aetxabao.invasoresfx.sprite.weaponry.Laserbeam;
import com.aetxabao.invasoresfx.util.Rect;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import static com.aetxabao.invasoresfx.game.AppConsts.*;

public class EnemyBarrier extends AEnemy implements IHaveShield{
    Rect gameRect;

    int N;//ticks para cambio de frame
    int n;
    int defensas; //Disparos aliados que puede aguantar el enemigo antes de ser destruido.


    public EnemyBarrier(Rect gameRect, Image img, int N) {
        super(img, ENEMYBARRIER_ROWS, ENEMYBARRIER_COLS);
        this.gameRect = gameRect;
        y = gameRect.top+height/2;
        this.N = N;
        this.n = 0;
        defensas = 10;
    }

    public void updateFrame(){
        if (++n==N) {
            n = 0;
            currentFrame = ++currentFrame % rows;
        }
    }

    public void update() {
        y += 1;
    }


    public Rect getRect(){
        return new Rect(x, y, (int)(x + ENEMYBARRIER_ALFA * width),(int)(y + ENEMYBARRIER_ALFA * height));
    }

    public void draw(GraphicsContext gc) {
        int srcX = currentFrame * width;
        int srcY = side*height;
        Rect src = new Rect(srcX, srcY, srcX + width, srcY + height);
        Rect dst = new Rect(x, y, x+width, y+height);
        gc.drawImage(img, src.left, src.top, src.width(), src.height(),
                dst.left, dst.top, dst.width(), dst.height());
    }

    @Override
    public boolean impact(AShot disparo) {
        if (disparo.getClass() == Laserbeam.class){
            this.defensas--;
            if (defensas == 0){
                return true;
            }
        }
        return false;
    }
}
