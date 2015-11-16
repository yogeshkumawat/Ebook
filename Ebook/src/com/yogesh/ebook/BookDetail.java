package com.yogesh.ebook;

import com.viewpagerindicator.CirclePageIndicator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

public class BookDetail extends FragmentActivity {

	
	private ViewPager vpPager;
    private MyPagerAdapter adapterViewPager;
    private RecyclerView mRecyclerView;
    private Context mContext;
    private MyAdapter mAdapter;
    private CirclePageIndicator mCirclePageIndicator;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_book_detail);
		
		mContext = this;
		Intent intent = getIntent();
		String book = intent.getStringExtra("book");
		int book_pos = intent.getIntExtra("position", 0);
		
		mRecyclerView = (RecyclerView) findViewById(R.id.page_recyclerview);
		LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
		mCirclePageIndicator = (CirclePageIndicator) findViewById(R.id.indicator);

		mRecyclerView.setLayoutManager(layoutManager);
		mRecyclerView.setLayoutDirection(RecyclerView.HORIZONTAL);

		vpPager = (ViewPager) findViewById(R.id.book_pager);
		adapterViewPager = new MyPagerAdapter(getSupportFragmentManager(),book);
		vpPager.setAdapter(adapterViewPager);
		mCirclePageIndicator.setViewPager(vpPager);

		mAdapter = new MyAdapter(mContext, book, book_pos);
		mRecyclerView.setAdapter(mAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		return super.onOptionsItemSelected(item);
	}
}
