package hu.tokingame.physicscalculator.BaseClass;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;

import jdk.nashorn.internal.objects.Global;

import static hu.tokingame.physicscalculator.BaseClass.Globals.bgIndex;
import static hu.tokingame.physicscalculator.BaseClass.Globals.bgs;

/**
 * Created by M on 10/7/2016.
 */

public class Assets {

    public static AssetManager manager;

    static final FreetypeFontLoader.FreeTypeFontLoaderParameter fontParameter = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
    static {
        fontParameter.fontFileName = "calibril.ttf";
        fontParameter.fontParameters.size = 50;
        fontParameter.fontParameters.characters = Globals.CHARS;
        fontParameter.fontParameters.color = Color.WHITE;
    }

    public static final AssetDescriptor<BitmapFont> CALIBRIL_FONT
            = new AssetDescriptor<BitmapFont>("calibril.ttf", BitmapFont.class, fontParameter);

    static final FreetypeFontLoader.FreeTypeFontLoaderParameter fontParameter2 = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
    static {
        fontParameter2.fontFileName = "digital-7.ttf";
        fontParameter2.fontParameters.size = 50;
        fontParameter2.fontParameters.characters = Globals.CHARS;
    }

    public static final AssetDescriptor<BitmapFont> DIGITAL_7_FONT
            = new AssetDescriptor<BitmapFont>("digital-7.ttf", BitmapFont.class, fontParameter2);

    //<editor-fold desc="Main Assets">
    public static final AssetDescriptor<Texture> TOKIN = new AssetDescriptor<Texture>("tokin.PNG", Texture.class);
    public static final AssetDescriptor<Texture> BUTTONBG = new AssetDescriptor<Texture>("buttonbg.png", Texture.class);
    public static final AssetDescriptor<Texture> STEELBUTTON = new AssetDescriptor<Texture>("steelbutton.png", Texture.class);
    public static final AssetDescriptor<Texture> POTATO = new AssetDescriptor<Texture>("potato.png", Texture.class);
    public static final AssetDescriptor<Texture> TARGET = new AssetDescriptor<Texture>("target.png", Texture.class);
    public static final AssetDescriptor<Texture> CANNON = new AssetDescriptor<Texture>("cannon.png", Texture.class);
    public static final AssetDescriptor<Texture> MENUBACKGROUND = new AssetDescriptor<Texture>("hatter1.jpg", Texture.class);
    public static final AssetDescriptor<Texture> MENUBACKGROUND2 = new AssetDescriptor<Texture>("hatter2.png", Texture.class);
    public static final AssetDescriptor<Texture> BUTTON_INACTIVE = new AssetDescriptor<Texture>("inactivebutton.png", Texture.class);
    public static final AssetDescriptor<Texture> BUTTON_ACTIVE = new AssetDescriptor<Texture>("activebutton.png", Texture.class);
    public static final AssetDescriptor<Texture> CANNONBASE = new AssetDescriptor<Texture>("cannonbase.png", Texture.class);
    public static final AssetDescriptor<Texture> MUSIC_ON = new AssetDescriptor<Texture>("kazetta.png", Texture.class);
    public static final AssetDescriptor<Texture> MUSIC_OFF = new AssetDescriptor<Texture>("kazetta_athuz.png", Texture.class);
    public static final AssetDescriptor<Texture> FULLHATTER = new AssetDescriptor<Texture>("hatter_fullacel.png", Texture.class);
    public static final AssetDescriptor<Texture> EARTH_ICON = new AssetDescriptor<Texture>("planet_earth.png", Texture.class);
    public static final AssetDescriptor<Texture> MOON_ICON = new AssetDescriptor<Texture>("moon.png", Texture.class);
    public static final AssetDescriptor<Texture> MARS_ICON = new AssetDescriptor<Texture>("mars.png", Texture.class);
    public static final AssetDescriptor<Texture> JUPITER_ICON = new AssetDescriptor<Texture>("jupiter.png", Texture.class);
    public static final AssetDescriptor<Texture> EXITSIGN = new AssetDescriptor<Texture>("exit.png", Texture.class);
    public static final AssetDescriptor<Texture> EARTH_BG = new AssetDescriptor<Texture>("earth_bg.jpg", Texture.class);
    public static final AssetDescriptor<Texture> MOON_BG = new AssetDescriptor<Texture>("moon_bg.jpg", Texture.class);
    public static final AssetDescriptor<Texture> MARS_BG = new AssetDescriptor<Texture>("mars_bg.jpg", Texture.class);
    public static final AssetDescriptor<Texture> JUPITER_BG = new AssetDescriptor<Texture>("jupiter_bg.jpg", Texture.class);
    public static final AssetDescriptor<Texture> SPOOKY_ICON = new AssetDescriptor<Texture>("spokkky.png", Texture.class);
    public static final AssetDescriptor<Texture> SPOOKY_BG = new AssetDescriptor<Texture>("spookybg.jpg", Texture.class);
    public static final AssetDescriptor<Texture> SPOOKY_PROJ = new AssetDescriptor<Texture>("spookyproj.png", Texture.class);
    public static final AssetDescriptor<Texture> SPOOKY_TARGET = new AssetDescriptor<Texture>("spookytarget.png", Texture.class);
    public static final AssetDescriptor<Texture> SETTINGS_ICON = new AssetDescriptor<Texture>("gear_icon.png", Texture.class);
    public static final AssetDescriptor<Texture> CONSOLE_BG = new AssetDescriptor<Texture>("console.png", Texture.class);
    public static final AssetDescriptor<Texture> MONITOR = new AssetDescriptor<Texture>("monitor.png", Texture.class);
    public static final AssetDescriptor<Texture> LAUNCHBUTTON = new AssetDescriptor<Texture>("launch-button.png", Texture.class);
    public static final AssetDescriptor<Texture> LABLE_BG = new AssetDescriptor<Texture>("lablebg.png", Texture.class);
    public static final AssetDescriptor<Texture> HELP = new AssetDescriptor<Texture>("question.png", Texture.class);
    //</editor-fold>


    public static final AssetDescriptor<Music> MAIN_MUSIC = new AssetDescriptor<Music>("bensound-scifi.mp3", Music.class);
    public static final AssetDescriptor<Music> SPOOKY_MUSIC = new AssetDescriptor<Music>("bensound-creepy.mp3", Music.class);




    public static void prepare() {
        manager = new AssetManager();
        Texture.setAssetManager(manager);
    }

    public static void load(){
        FileHandleResolver resolver = new InternalFileHandleResolver();
        //FileHandleResolver resolver = manager.getFileHandleResolver();
        manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
        manager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));
        manager.setLoader(BitmapFont.class, ".otf", new FreetypeFontLoader(resolver));




        manager.load(CALIBRIL_FONT);
        manager.load(DIGITAL_7_FONT);

        manager.load(TOKIN);
        manager.load(BUTTONBG);
        manager.load(STEELBUTTON);
        manager.load(POTATO);
        manager.load(TARGET);
        manager.load(CANNON);
        manager.load(MENUBACKGROUND);
        manager.load(MENUBACKGROUND2);
        manager.load(BUTTON_ACTIVE);
        manager.load(BUTTON_INACTIVE);
        manager.load(CANNONBASE);
        manager.load(MUSIC_OFF);
        manager.load(MUSIC_ON);
        manager.load(FULLHATTER);
        manager.load(EARTH_ICON);
        manager.load(MOON_ICON);
        manager.load(MARS_ICON);
        manager.load(JUPITER_ICON);
        manager.load(EXITSIGN);
        manager.load(EARTH_BG);
        manager.load(MOON_BG);
        manager.load(MARS_BG);
        manager.load(JUPITER_BG);
        manager.load(SPOOKY_BG);
        manager.load(SPOOKY_ICON);
        manager.load(SPOOKY_PROJ);
        manager.load(SPOOKY_TARGET);
        manager.load(SETTINGS_ICON);
        manager.load(CONSOLE_BG);
        manager.load(MONITOR);
        manager.load(LAUNCHBUTTON);
        manager.load(LABLE_BG);
        manager.load(HELP);

        manager.load(MAIN_MUSIC);
        manager.load(SPOOKY_MUSIC);


    }

    public static void afterLoaded(){

        manager.get(MAIN_MUSIC).setLooping(true);
        manager.get(SPOOKY_MUSIC).setLooping(true);
        if(Globals.sounds){
            if(bgs[bgIndex] == SPOOKY_BG) {
                manager.get(SPOOKY_MUSIC).play();
            }else{
                manager.get(MAIN_MUSIC).play();
            }
        }
    }

    public static void unload(){
        manager.dispose();
    }

}
