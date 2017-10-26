package hu.tokingame.physicscalculator.Credits;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.physicscalculator.BaseClass.Assets;
import hu.tokingame.physicscalculator.BaseClass.Globals;
import hu.tokingame.physicscalculator.BaseClass.MyLabel;
import hu.tokingame.physicscalculator.BaseClass.MyStage;
import hu.tokingame.physicscalculator.BaseClass.MyTextButton;
import hu.tokingame.physicscalculator.BaseClass.OneSpriteStaticActor;
import hu.tokingame.physicscalculator.Menu.MenuScreen;
import hu.tokingame.physicscalculator.MyGdxGame;


public class CreditsStage extends MyStage {

    float elapsedtime = 0;

    int rand(int a, int b){
        return (int)(Math.random()*(b-a+1)+a);
    }
    MyLabel uzi;

    int tRot, pRot;
    float px, py, tx, ty;

    OneSpriteStaticActor tokin, krumpli;

    public CreditsStage(Viewport viewport, Batch batch, final MyGdxGame game) {

        super(viewport, batch, game);
        Gdx.input.setCatchBackKey(true);

        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.FULLHATTER)){
            @Override
            protected void init() {
                super.init();
                setSize(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT);
                setPosition(0,0);
            }
        });

        tRot = rand(50, 200);
        pRot = rand(-50, -200);
        px = rand(-100, 100)/100f;
        py = rand(-100, 100)/100f;
        tx = rand(-100, 100)/100f;
        ty = rand(-100, 100)/100f;

        addActor(tokin = new OneSpriteStaticActor(Assets.manager.get(Assets.TOKIN)){
            @Override
            protected void init() {
                super.init();
                setSize(100, 100);
                setPosition(1080, 520);
            }
        });
        addActor(krumpli = new OneSpriteStaticActor(Assets.manager.get(Assets.POTATO)){
            @Override
            protected void init() {
                super.init();
                setSize(100, 100);
                setPosition(100, 520);
            }
        });

        String str = "Potato Launch Calculator\n"+
                "Készítette: a Tökin Game csapat\n" +
                "Tagok:\n" +
                "Bálint Dániel\n" +
                "Dávid Mátyás\n" +
                "Kovács Zoltán\n" +
                "Schuh Marcell\n\n" +
                "Zene: www.bensound.com";

        addActor(uzi=new MyLabel(str));
        uzi.setPosition(Globals.WORLD_WIDTH/2-uzi.getWidth()/2f, Globals.WORLD_HEIGHT/2-uzi.getHeight()/2f);

        addActor(new MyTextButton("Vissza"){
            @Override
            protected void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH-this.getWidth()-100, 100);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreenBackByStackPop();
                    }

                });
                setTexture(Assets.manager.get(Assets.STEELBUTTON));
            }
        });






    }


    public void refresh() {
        //backGround.setSize(getViewport().getWorldWidth(),getViewport().getWorldHeight());
    }
    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.BACK){
            game.setScreenBackByStackPop();
        }
        return false;
    }


    @Override
    public void draw() {
        super.draw();
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        elapsedtime += delta;

        krumpli.setRotation(elapsedtime*pRot);
        tokin.setRotation(elapsedtime*tRot);

        krumpli.setPosition(krumpli.getX()+px, krumpli.getY()+py);
        tokin.setPosition(tokin.getX()+tx, tokin.getY()+ty);

    }

    public void init(){














        refresh();
    }
}
