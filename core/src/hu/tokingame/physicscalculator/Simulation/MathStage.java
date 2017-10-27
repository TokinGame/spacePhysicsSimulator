package hu.tokingame.physicscalculator.Simulation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.FloatAction;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.physicscalculator.BaseClass.Assets;
import hu.tokingame.physicscalculator.BaseClass.Globals;
import hu.tokingame.physicscalculator.BaseClass.MyLabel;
import hu.tokingame.physicscalculator.BaseClass.MyStage;
import hu.tokingame.physicscalculator.BaseClass.MyTextButton;
import hu.tokingame.physicscalculator.BaseClass.OneSpriteStaticActor;
import hu.tokingame.physicscalculator.MyGdxGame;
import hu.tokingame.physicscalculator.Physics.Calculator;
import jdk.nashorn.internal.objects.Global;

/**
 * Created by davim on 2016. 10. 07..
 */

public class MathStage extends MyStage {

    float elapsedtime = 0;

    MyLabel szam1, szam2, szam3, eredmeny, ered;
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

    public MathStage(Viewport viewport, Batch batch, final MyGdxGame game) {

        super(viewport, batch, game);
        stage = this;

        Gdx.input.setCatchBackKey(true);

        calculator = new Calculator(){
            @Override
            protected void onChanged() {
                super.onChanged();
                //Todo frissíteni a staget
            }
        };

        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.FULLHATTER)){
            @Override
            protected void init() {
                super.init();
                setSize(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT);
            }
        });

        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.MONITOR)){
            @Override
            protected void init() {
                super.init();
                setSize(400, 400);
                setPosition(290, 330);
            }
        });

        stage.addActor(inputButtons = new InputButtons(stage));
        inputButtons.setSize(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT);
        inputButtons.setPosition(1280,0);





        addActor(new MyTextButton("Vissza"){
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
                setPosition(Globals.WORLD_WIDTH/2-this.getWidth()/2, 10);
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
        addActor(szamol = new MyTextButton("Számolás"){
            @Override
            protected void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH/2-this.getWidth()/2, 100);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        try {
                            calculator.set(Float.parseFloat(szam1.getText().toString()),Float.parseFloat(szam2.getText().toString()),Float.parseFloat(szam3.getText().toString()));
                            eredmeny.setText("\u03B1" + "\u2081" + " = " + Math.round(calculator.getAlpha()[0]*100)/100.0 + "°\n\u03B1\u2082 = " + Math.round(calculator.getAlpha()[1]*100)/100.0 + "°");
                            szimulal.setVisible(true);
                            successfulCalculation();
                            ered.setVisible(true);
                            eredmeny.setVisible(true);
                            Globals.actualValues[0] = calculator.getV0();
                            Globals.actualValues[1] = calculator.getX();
                            Globals.actualValues[2] = calculator.getY();
                        }catch (NumberFormatException e){
                            eredmeny.setText("Valamelyik mezőt nem töltötted ki!");
                            eredmeny.setVisible(true);
                        }catch (Exception e){
                            eredmeny.setText("Nem létezik ilyen szög.");
                            eredmeny.setVisible(true);
                        }
                    }
                });
                setTexture(Assets.manager.get(Assets.STEELBUTTON));
                enableTexture(true);
            }
        });




        addActor(szovegcucc = new MyTextButton("Sebesség: ", null));
        szovegcucc.setPosition(20, 600);
        szovegcucc.setSize(250, 60);
        szovegcucc.setTexture(Assets.manager.get(Assets.BUTTON_INACTIVE));
        szovegcucc.enableTexture(true);
        addActor(szovegcucc2 = new MyTextButton("Távolság: ", null));
        szovegcucc2.setPosition(20, 500);
        szovegcucc2.setSize(250, 60);
        szovegcucc2.setTexture(Assets.manager.get(Assets.BUTTON_INACTIVE));
        szovegcucc2.enableTexture(true);
        addActor(szovegcucc3 = new MyTextButton("Magasság: ", null));
        szovegcucc3.setPosition(20, 400);
        szovegcucc3.setSize(250, 60);
        szovegcucc3.setTexture(Assets.manager.get(Assets.BUTTON_INACTIVE));
        szovegcucc3.enableTexture(true);
        addActor(ered = new MyLabel("Eredmények: ", MyLabel.style));
        ered.setPosition(50, 300);
        eredmeny.setPosition(50, 200);
        ered.setVisible(false);
        eredmeny.setVisible(false);


            szam1.setPosition(350, 600);
            szam2.setPosition(350, 500);
            szam3.setPosition(350, 400);
            szam1.setSize(210, 60);
            szam2.setSize(210, 60);
            szam3.setSize(210, 60);
            addActor(new MyTextButton("m/s"){
                @Override
                protected void init() {
                    super.init();
                    setPosition(560, 600);
                }
            });
        addActor(new MyTextButton("m"){
            @Override
            protected void init() {
                super.init();
                setPosition(560, 500);
            }
        });
        addActor(new MyTextButton("m"){
            @Override
            protected void init() {
                super.init();
                setPosition(560, 400);
            }
        });
            szovegcucc.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    inputButtons.show(szam1,1);
                    szovegcucc.setTexture(Assets.manager.get(Assets.BUTTON_ACTIVE));
                    szovegcucc2.setTexture(Assets.manager.get(Assets.BUTTON_INACTIVE));
                    szovegcucc3.setTexture(Assets.manager.get(Assets.BUTTON_INACTIVE));
                }
            });
            szovegcucc2.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    inputButtons.show(szam2,2);
                    szovegcucc.setTexture(Assets.manager.get(Assets.BUTTON_INACTIVE));
                    szovegcucc2.setTexture(Assets.manager.get(Assets.BUTTON_ACTIVE));
                    szovegcucc3.setTexture(Assets.manager.get(Assets.BUTTON_INACTIVE));
                }
            });
            szovegcucc3.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    inputButtons.show(szam3,3);
                    szovegcucc.setTexture(Assets.manager.get(Assets.BUTTON_INACTIVE));
                    szovegcucc2.setTexture(Assets.manager.get(Assets.BUTTON_INACTIVE));
                    szovegcucc3.setTexture(Assets.manager.get(Assets.BUTTON_ACTIVE));
                }
            });

            szam1.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    inputButtons.show(szam1,1);
                    szovegcucc.setTexture(Assets.manager.get(Assets.BUTTON_ACTIVE));
                    szovegcucc2.setTexture(Assets.manager.get(Assets.BUTTON_INACTIVE));
                    szovegcucc3.setTexture(Assets.manager.get(Assets.BUTTON_INACTIVE));
                }
            });
            szam2.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    inputButtons.show(szam2,2);
                    szovegcucc.setTexture(Assets.manager.get(Assets.BUTTON_INACTIVE));
                    szovegcucc2.setTexture(Assets.manager.get(Assets.BUTTON_ACTIVE));
                    szovegcucc3.setTexture(Assets.manager.get(Assets.BUTTON_INACTIVE));
                }
            });
            szam3.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    inputButtons.show(szam3,3);
                    szovegcucc.setTexture(Assets.manager.get(Assets.BUTTON_INACTIVE));
                    szovegcucc2.setTexture(Assets.manager.get(Assets.BUTTON_INACTIVE));
                    szovegcucc3.setTexture(Assets.manager.get(Assets.BUTTON_ACTIVE));
                }
            });







    }


    public void setValuesBack(){
        szam1.setText((int)Globals.actualValues[0]+"");
        szam2.setText((int)Globals.actualValues[1]+"");
        szam3.setText((int)Globals.actualValues[2]+"");
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
        setDebugAll(Globals.IS_DEBUG);
    }
}

