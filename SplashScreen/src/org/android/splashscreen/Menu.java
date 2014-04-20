package org.android.splashscreen;

import android.app.Activity;
import android.os.Bundle;

public class Menu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);

	}

	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}


}
