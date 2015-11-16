package com.yogesh.ebook;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyPagerAdapter extends FragmentPagerAdapter {

	private static int NUM_ITEMS = 5;
	public static String[] Books = { "English", "Math", "Physics", "Chemistry", "Biology" };
	private String mSelectedBook= null;

	public MyPagerAdapter(FragmentManager fragmentManager) {
		super(fragmentManager);
	}
	
	public MyPagerAdapter(FragmentManager fragmentManager, String book) {
		super(fragmentManager);
		mSelectedBook = book;
	}

	// Returns total number of pages
	@Override
	public int getCount() {
		return NUM_ITEMS;
	}

	// Returns the fragment to display for that page
	@Override
	public Fragment getItem(int position) {
		if(mSelectedBook == null)
			return FirstFragment.newInstance(position + 1, Books[position], true);
		else
			return FirstFragment.newInstance(position + 1, mSelectedBook, false);
	}

	// Returns the page title for the top indicator
	@Override
	public CharSequence getPageTitle(int position) {
		return "Page " + position;
	}



}
