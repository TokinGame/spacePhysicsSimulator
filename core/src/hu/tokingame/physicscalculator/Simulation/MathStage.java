package hu.tokingame.physicscalculator.Simulation;

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
import hu.tokingame.physicscalculator.MyGdxGame;
import hu.tokingame.physicscalculator.Physics.Calculator;

/**
 * Created by davim on 2016. 10. 07..
 */

public class MathStage extends MyStage {

    float elapsedtime = 0;

    MyLabel szam1, szam2, szam3, eredmeny;
    MyTextButton szovegcucc, szovegcucc2, szovegcucc3, szamol, szimulal;
    InputButtons inputButtons;

    float var1 = 0, var2 = 0, var3 = 0, var4 = 0;

    int rand(int a, int b){
        return (int)(Math.random()*(b-a+1)+a);
    }

    int mode;

    float[] vegeredmeny = new float[2];

    Calculator calculator;


    MathStage stage;

    public MathStage(Viewport viewport, Batch batch, final MyGdxGame game, int mode) {

        super(viewport, batch, game);
        stage = this;
        this.mode = mode;
        Gdx.input.setCatchBackKey(true);

        calculator = new Calculator(){
            @Override
            protected void onChanged() {
                super.onChanged();
                //Todo frissíteni a staget
            }
        };

        stage.addActor(inputButtons = new InputButtons(stage));
        inputButtons.setSize(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT);
        inputButtons.setPosition(1280,0);


        addActor(new MyTextButton("nem"){
            @Override
            protected void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH-this.getWidth()-10, 10);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreenBackByStackPop();
                    }
                });
                setTexture(Assets.manager.get(Assets.STEELBUTTON));
                enableTexture(true);
            }
        });
        addActor(szam1 = new MyLabel("", MyLabel.style));
        addActor(szam2 = new MyLabel("", MyLabel.style));
        addActor(szam3 = new MyLabel("", MyLabel.style));
        addActor(eredmeny = new MyLabel("Szög: "+var4+" °", MyLabel.style));


        addActor(szimulal = new MyTextButton("Szimuláció"){
            @Override
            protected void init() {
                super.init();
                setPosition(500, 10);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new SimulationScreen(game, calculator));
                    }
                });
                setVisible(false);
                setTexture(Assets.manager.get(Assets.STEELBUTTON));
                enableTexture(true);
            }
        });
        addActor(szamol = new MyTextButton("Számolaáss"){
            @Override
            protected void init() {
                super.init();
                setPosition(500, 100);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        try {
                            //float[] nem = Calculator.calcAlpha(Float.parseFloat(szam1.getText().toString()), Float.parseFloat(szam2.getText().toString()), Float.parseFloat(szam3.getText().toString()));
                            calculator.set(Float.parseFloat(szam1.getText().toString()), Float.parseFloat(szam2.getText().toString()), Float.parseFloat(szam3.getText().toString()));
                            /*if (nem[0] == (float)-666.0) {
                                eredmeny.setText("Látom te is annyira értesz a fizikához mint mi.");
                                return;
                            }else{
                                eredmeny.setText(nem[0] + " koz " + nem[1]);
                            }*/
                            eredmeny.setText(calculator.getAlpha()[0] + " koz " + calculator.getAlpha()[1]);
                            szimulal.setVisible(true);
                            successfulCalculation();
                        }catch (NumberFormatException e){
                            eredmeny.setText("Spanish inquisition");
                        }catch (Exception e){
                            eredmeny.setText("Hibás adat, 666");
                        }
                    }
                });
                setTexture(Assets.manager.get(Assets.STEELBUTTON));
                enableTexture(true);
            }
        });




        addActor(szovegcucc = new MyTextButton("Sebesség: ", null));
        szovegcucc.setPosition(50, 600);
        szovegcucc.setTexture(Assets.manager.get(Assets.BUTTON_INACTIVE));
        szovegcucc.enableTexture(true);
        addActor(szovegcucc2 = new MyTextButton("Távolság: ", null));
        szovegcucc2.setPosition(50, 500);
        szovegcucc2.setTexture(Assets.manager.get(Assets.BUTTON_INACTIVE));
        szovegcucc2.enableTexture(true);
        addActor(szovegcucc3 = new MyTextButton("Magasság: ", null));
        szovegcucc3.setPosition(50, 400);
        szovegcucc3.setTexture(Assets.manager.get(Assets.BUTTON_INACTIVE));
        szovegcucc3.enableTexture(true);
        MyLabel ered;
        addActor(ered = new MyLabel("Eredmények: ", MyLabel.style));
        ered.setPosition(50, 300);



        if(mode == 1){
            szam1.setPosition(300, 600);
            szam2.setPosition(300, 500);
            szam3.setPosition(300, 400);
            szam1.setSize(210, 60);
            szam2.setSize(210, 60);
            szam3.setSize(210, 60);
            eredmeny.setPosition(100, 200);
            szovegcucc.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    inputButtons.show(szam1);
                    szovegcucc.setTexture(Assets.manager.get(Assets.BUTTON_ACTIVE));
                    szovegcucc2.setTexture(Assets.manager.get(Assets.BUTTON_INACTIVE));
                    szovegcucc3.setTexture(Assets.manager.get(Assets.BUTTON_INACTIVE));
                }
            });
            szovegcucc2.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    inputButtons.show(szam2);
                    szovegcucc.setTexture(Assets.manager.get(Assets.BUTTON_INACTIVE));
                    szovegcucc2.setTexture(Assets.manager.get(Assets.BUTTON_ACTIVE));
                    szovegcucc3.setTexture(Assets.manager.get(Assets.BUTTON_INACTIVE));
                }
            });
            szovegcucc3.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    inputButtons.show(szam3);
                    szovegcucc.setTexture(Assets.manager.get(Assets.BUTTON_INACTIVE));
                    szovegcucc2.setTexture(Assets.manager.get(Assets.BUTTON_INACTIVE));
                    szovegcucc3.setTexture(Assets.manager.get(Assets.BUTTON_ACTIVE));
                }
            });

            szam1.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    inputButtons.show(szam1);
                    szovegcucc.setTexture(Assets.manager.get(Assets.BUTTON_ACTIVE));
                    szovegcucc2.setTexture(Assets.manager.get(Assets.BUTTON_INACTIVE));
                    szovegcucc3.setTexture(Assets.manager.get(Assets.BUTTON_INACTIVE));
                }
            });
            szam2.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    inputButtons.show(szam2);
                    szovegcucc.setTexture(Assets.manager.get(Assets.BUTTON_INACTIVE));
                    szovegcucc2.setTexture(Assets.manager.get(Assets.BUTTON_ACTIVE));
                    szovegcucc3.setTexture(Assets.manager.get(Assets.BUTTON_INACTIVE));
                }
            });
            szam3.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    inputButtons.show(szam3);
                    szovegcucc.setTexture(Assets.manager.get(Assets.BUTTON_INACTIVE));
                    szovegcucc2.setTexture(Assets.manager.get(Assets.BUTTON_INACTIVE));
                    szovegcucc3.setTexture(Assets.manager.get(Assets.BUTTON_ACTIVE));
                }
            });
        }else{

        }






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

    }

    public void disableButtons(){
        szovegcucc.setTexture(Assets.manager.get(Assets.BUTTON_INACTIVE));
        szovegcucc2.setTexture(Assets.manager.get(Assets.BUTTON_INACTIVE));
        szovegcucc3.setTexture(Assets.manager.get(Assets.BUTTON_INACTIVE));
    }

    public void successfulCalculation(){
        inputButtons.hide();
        disableButtons();
    }

    public void init(){



        refresh();
        setDebugAll(true);
    }
}

