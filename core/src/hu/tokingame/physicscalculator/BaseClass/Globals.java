package hu.tokingame.physicscalculator.BaseClass;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by M on 10/14/2016.
 */


public class Globals {
    public static final String CHARS = "0123456789öüóqwertzuiopőúasdfghjkléáűíyxcvbnm'+!%/=()ÖÜÓQWERTZUIOPŐÚASDFGHJKLÉÁŰÍYXCVBNM?:_*<>#&@{}[],-.°";
   // public static final BitmapFont FONT_HOBO_STD;
   // public static final BitmapFont FONT_DIGITAL_7;

    public static final int WORLD_WIDTH = 1280;
    public static final int WORLD_HEIGHT = 720;

    public static final int maximumInputLength = 8;

    public static final boolean IS_DEBUG = true;

    public static final AssetDescriptor<Texture>[] bgs = new AssetDescriptor[]{Assets.POTATO, Assets.STEELBUTTON, Assets.CANNONBASE};
    public static int bgIndex = 0;

    public static boolean sounds = true;

}
