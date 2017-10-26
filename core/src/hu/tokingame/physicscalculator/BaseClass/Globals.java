package hu.tokingame.physicscalculator.BaseClass;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by M on 10/14/2016.
 */


public class Globals {
    public static final String CHARS = "0123456789öüóqwertzuiopőúasdfghjkléáűíyxcvbnm'+!%/=()ÖÜÓQWERTZUIOPŐÚASDFGHJKLÉÁŰÍYXCVBNM?:_*<>#&@{}[],-.°α₁₂²";
   // public static final BitmapFont FONT_HOBO_STD;
   // public static final BitmapFont FONT_DIGITAL_7;

    public static final int WORLD_WIDTH = 1280;
    public static final int WORLD_HEIGHT = 720;

    public static final int maximumInputLength = 8;

    public static final Preferences prefs = Gdx.app.getPreferences("mainPrefs");
    
    //// TODO: 10/26/2017 Állítsd át false-ra
    public static final boolean IS_DEBUG = true;

    public static final AssetDescriptor<Texture>[] bgs = new AssetDescriptor[]{Assets.EARTH_BG, Assets.MOON_BG, Assets.MARS_BG, Assets.JUPITER_BG, Assets.SPOOKY_BG};
    public static final AssetDescriptor<Texture>[] bgIcons = new AssetDescriptor[]{Assets.EARTH_ICON, Assets.MOON_ICON, Assets.MARS_ICON, Assets.JUPITER_ICON, Assets.SPOOKY_ICON};
    public static int bgIndex = prefs.getInteger("bgIndex", 0);

    public static final float[] gForces = {9.81f, 1.62f, 3.71f, 24.79f, 666f};
    public static final String[] planets = {"Föld", "Hold", "Mars", "Jupiter", "Halloween"};

    public static boolean sounds = prefs.getBoolean("sounds", true);

}
