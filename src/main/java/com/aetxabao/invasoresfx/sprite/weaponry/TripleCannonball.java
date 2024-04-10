package com.aetxabao.invasoresfx.sprite.weaponry;

import com.aetxabao.invasoresfx.util.Rect;
import javafx.scene.image.Image;

public class TripleCannonball {
    private CannonballDiagonal disparoIZQ;
    private Cannonball disparoCEN;
    private CannonballDiagonal disparoDER;

    public TripleCannonball(Rect gameRect, Image img){
        this.disparoIZQ = new CannonballDiagonal(gameRect, img);
        this.disparoIZQ.setXSpeed(-disparoIZQ.getXSpeed());
        this.disparoCEN = new Cannonball(img);
        this.disparoDER = new CannonballDiagonal(gameRect, img);
    }

    public void update(){
        disparoDER.update();
        disparoCEN.update();
        disparoIZQ.update();
    }
}
