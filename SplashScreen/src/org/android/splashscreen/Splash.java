package org.android.splashscreen;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by Juan Molero on 20/04/2014
 */
public class Splash extends Activity {
	
	/** Called when the activity is first created. */
	
	public void onAttachedToWindow() {
		super.onAttachedToWindow();
		Window window = getWindow();
		window.setFormat(PixelFormat.RGBA_8888);
	}
	
	private static String TAG = Splash.class.getName();
	private static long SLEEP_TIME = 5;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        
        StartAnimations();
        IntentLauncher launcher = new IntentLauncher();
        launcher.start();

    }
    
    private void StartAnimations() {
    	
    	Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
    	anim.reset();
    	LinearLayout l=(LinearLayout) findViewById(R.id.la_Main);
    	l.clearAnimation();
    	l.startAnimation(anim);
    	
    	anim = AnimationUtils.loadAnimation(this, R.anim.translate);
    	anim.reset();
    	ImageView iv = (ImageView) findViewById(R.id.logo);
    	iv.clearAnimation();
    	iv.startAnimation(anim);
    	
    }
    
    private class IntentLauncher extends Thread {
    	
    	@Override
    	public void run() {
    		try {
    			
    			Thread.sleep(SLEEP_TIME*1000);
    			
    		} catch (Exception e) {
    			
    			Log.e(TAG, e.getMessage());
    			
    		}
    		
    		Intent intent = new Intent(Splash.this, Menu.class);
    		Splash.this.startActivity(intent);
    		Splash.this.finish();
    	}
    }
        
}
