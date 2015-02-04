package com.example.apptest.test;

import android.test.ActivityInstrumentationTestCase2;

import com.example.apptest.MainActivity;
import com.robotium.solo.Solo;

import junit.framework.TestCase;

public class UITestApp extends ActivityInstrumentationTestCase2<MainActivity> {

	public UITestApp() {
		super(MainActivity.class);
	}

	private Solo solo;

	protected void setUp() throws Exception {
		// setUp() is run before a test case is started.
		// This is where the solo object is created.
		solo = new Solo(getInstrumentation(), getActivity());
	}

	protected void tearDown() throws Exception {
		// tearDown() is run after a test case has finished.
		// finishOpenedActivities() will finish all the activities that have
		// been opened during the test execution.
		solo.finishOpenedActivities();
	}

	public void testUIEnter() throws Exception {
		// Unlock the lock screen
		solo.unlockScreen();
		// Assert that NoteEditor activity is opened
		solo.assertCurrentActivity("Expected MainActivity activity",
				"MainActivity");
		// Change orientation of activity
		solo.setActivityOrientation(Solo.LANDSCAPE);
		solo.setActivityOrientation(Solo.PORTRAIT);
		// Takes a screenshot and saves it in "/sdcard/Robotium-Screenshots/".
		solo.takeScreenshot();
		boolean testSuccess = true;
		assertTrue("Test Success", testSuccess);

	}
	
	public void testUIClick() throws Exception {
		// Unlock the lock screen
		solo.unlockScreen();
		// Assert that NoteEditor activity is opened
		solo.assertCurrentActivity("Expected MainActivity activity",
				"MainActivity");
		// Change orientation of activity
		solo.clickOnButton(0);
		boolean testSuccess = true;
		assertTrue("Test Success", testSuccess);

	}

}
