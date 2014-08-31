package de.mmssb.androidtbsgame.andengine;

import org.andengine.engine.camera.SmoothCamera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.andengine.entity.scene.Scene;
import org.andengine.entity.util.FPSLogger;
import org.andengine.ui.activity.SimpleBaseGameActivity;

import android.util.DisplayMetrics;
import de.mmssb.androidtbsgame.andengine.hud.ModelHUD;
import de.mmssb.androidtbsgame.andengine.managers.SceneManager.SceneType;

/**
 * @author Manu
 * 
 */
public class MainActivity extends SimpleBaseGameActivity {
	private Model model;
	private SmoothCamera camera;

	@Override
	public EngineOptions onCreateEngineOptions() {
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		int deviceWidth = metrics.heightPixels;
		int deviceHeight = metrics.widthPixels;
		camera = new SmoothCamera(0, 0, deviceHeight, deviceWidth,
				deviceWidth / 2, deviceWidth / 2, 1);
		camera.setBoundsEnabled(true);
		return new EngineOptions(true, ScreenOrientation.LANDSCAPE_FIXED,
				new RatioResolutionPolicy(deviceHeight, deviceWidth), camera);
	}

	@Override
	protected void onCreateResources() {
		model = new Model(this);
		camera.setHUD(new ModelHUD(model));
		model.getSceneManager().setActualSceneType(SceneType.GAME);
	}

	@Override
	protected Scene onCreateScene() {
		this.mEngine.registerUpdateHandler(new FPSLogger());
		return model.getSceneManager().getActualScene();
	}

	public SmoothCamera getSmoothCamera() {
		return camera;
	}
}
