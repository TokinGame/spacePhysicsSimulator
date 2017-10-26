package hu.tokingame.physicscalculator;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;

import java.lang.reflect.InvocationTargetException;
import java.util.Stack;

import hu.tokingame.physicscalculator.BaseClass.Assets;
import hu.tokingame.physicscalculator.BaseClass.Globals;
import hu.tokingame.physicscalculator.BaseClass.MyScreen;
import hu.tokingame.physicscalculator.Loading.BetoltoScreen;

public class MyGdxGame extends Game {

	// TODO: 10/19/2017 Meg kell keresni hogy mért dobja ezt a hibát:  AL lib: (EE) alc_cleanup: 1 device not closed

	public final Stack<Class> backButtonStack = new Stack();

	@Override
	public void create () {
		Assets.prepare();
		setScreen(new BetoltoScreen(this));
	}

	@Override
	public void resume() {
		super.resume();
		Assets.manager.update();
	}

	@Override
	public void dispose () {
		Globals.prefs.flush();
		super.dispose();
		Assets.unload();
	}

	@Override
	public void pause() {
		super.pause();
	}

	public void setScreen(Screen screen){setScreen(screen, true);}


	public void setScreen(Screen screen, boolean pushToStack) {
		Screen prevScreen = getScreen();
		if (prevScreen != null) {
			if (pushToStack) {
				backButtonStack.push(prevScreen.getClass());
			}
			prevScreen.dispose();
		}
		super.setScreen(screen);
	}

	public void setScreenBackByStackPop() {
		if (backButtonStack.size() > 1) {
			try {
				MyScreen myScreen;
				setScreen(myScreen = (MyScreen)backButtonStack.pop().getConstructor(MyGdxGame.class).newInstance(this), false);
				myScreen.backFromStack();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		} else {
			Gdx.app.exit();
		}
	}
}
