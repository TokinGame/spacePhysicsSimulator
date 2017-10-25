package hu.tokingame.physicscalculator.BaseClass;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by tuskeb on 2016. 09. 30..
 */
abstract public class OneSpriteActor extends MyActor {
    protected Sprite sprite;

    public OneSpriteActor(Sprite sprite) {
        if (sprite!=null) {
            this.sprite = sprite;
            init();
        }
    }

    protected void init()
    {
        setSize(sprite.getWidth(), sprite.getHeight());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        sprite.draw(batch);
    }


    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }


    @Override
    protected void positionChanged() {
        super.positionChanged();
        sprite.setPosition(getX(), getY());
    }

    @Override
    protected void rotationChanged() {
        super.rotationChanged();
        sprite.setRotation(getRotation());

    }

    @Override
    public void setRotation(float degrees) {
        super.setRotation(degrees);
        sprite.setRotation(degrees);
    }

    @Override
    public void setOrigin(float originX, float originY) {
        super.setOrigin(originX, originY);
        sprite.setOrigin(originX, originY);
    }

    @Override
    protected void sizeChanged() {
        super.sizeChanged();
        sprite.setSize(getWidth(), getHeight());
        sprite.setOrigin(getWidth()/2, getHeight()/2);
    }
}
