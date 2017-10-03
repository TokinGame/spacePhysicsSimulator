package hu.tokingame.physicscalculator.Loading;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.Stage;

import hu.tokingame.physicscalculator.BaseClass.Assets;
import hu.tokingame.physicscalculator.BaseClass.MyScreen;
import hu.tokingame.physicscalculator.BaseClass.OneSpriteStaticActor;
import hu.tokingame.physicscalculator.Menu.MenuScreen;

/**
 * Created by M on 10/7/2016.
 */

public class BetoltoScreen extends MyScreen {

    Stage stage;

    private float elapsedTime = 0;
    private OneSpriteStaticActor backGround;

    public BetoltoScreen(Game game) {
        super(game);
        setBackGroundColor(0f, 0f, 0f);
        stage = new Stage(viewport, spriteBatch);
        //stage.addActor(backGround= new OneSpriteStaticActor("wood.png"));
        //backGround.setSize(MyScreen.WORLD_WIDTH,MyScreen.WORLD_HEIGHT);
        //backGround.setPosition(0,0);
        /*stage.addActor(new OneSpriteAnimatedActor("load.txt")
        {
            @Override
            protected void init() {
                super.init();
                setFps(10);
                //setWidth(WORLD_WIDTH);
                //setHeight(WORLD_HEIGHT);
                setSize(MyScreen.WORLD_WIDTH,MyScreen.WORLD_HEIGHT);
            }
        });*/
    }

    @Override
    public void show() {
        Assets.manager.finishLoading();
        Assets.load();
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        //if (elapsedTime > 2.0 && Assets.manager.update()) {
        if (Assets.manager.update()) {
            Assets.afterLoaded();
            game.setScreen(new MenuScreen(game));
        }
        //spriteBatch.begin();
        elapsedTime += delta;
        stage.act(delta);
        stage.draw();
        //Globals.FONT_HOBO_STD.draw(spriteBatch,"Betöltés: " + Assets.manager.getLoadedAssets() + "/" + (Assets.manager.getQueuedAssets()+Assets.manager.getLoadedAssets()) + " (" + ((int)(Assets.manager.getProgress()*100f)) + "%)",0,50);
        //spriteBatch.end();
    }

    @Override
    public void hide() {

    }
}
