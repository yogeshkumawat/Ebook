package com.yogesh.ebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Yogesh on 11/8/2015.
 */
public class FirstFragment extends Fragment {
    // Store instance variables
    private String title;
    private int page;
    private boolean isCover;
    private static int Book_Cover[] = {R.drawable.english_cover, R.drawable.math_cover, R.drawable.physics_cover, R.drawable.chemistry_cover, R.drawable.biology_cover};

    // newInstance constructor for creating fragment with arguments
    public static FirstFragment newInstance(int page, String title, boolean isCover) {
        FirstFragment fragmentFirst = new FirstFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        args.putBoolean("isCover",isCover);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
        isCover = getArguments().getBoolean("isCover");
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        TextView tvLabel = (TextView) view.findViewById(R.id.section_label);
        TextView tvPageNo = (TextView) view.findViewById(R.id.subject_page);
        ImageView ivSubject = (ImageView) view.findViewById(R.id.subject_icon);
        tvLabel.setText("Subject : " + title);
        tvPageNo.setText("Page No. - "+page);
        if(isCover) {
        	tvPageNo.setText(""+page);
        	ivSubject.setImageDrawable(getActivity().getResources().getDrawable(Book_Cover[page-1]));
        	ivSubject.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent i = new Intent(getActivity(), BookDetail.class);
		            i.putExtra("book", title);
		            i.putExtra("position", page-1);
		            getActivity().startActivity(i);
				}
			});
        }
        
        return view;
    }
}
