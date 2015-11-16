package com.yogesh.ebook;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Yogesh on 11/12/2015.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CustomViewHolder> {

	private Context mContext;
	private String Books[];
	private String book = null;
	private int book_pos = 0;
	private static int NUM = 5;
	private static int[] books_icon = {R.drawable.english,R.drawable.maths,R.drawable.physics,R.drawable.chemistry,R.drawable.biology};
	
	 @Override
	    public MyAdapter.CustomViewHolder onCreateViewHolder(android.view.ViewGroup parent, int viewType) {
		    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_list_item, null);

	        CustomViewHolder viewHolder = new CustomViewHolder(view);
	        return viewHolder;
	    }
	 
	 public MyAdapter(Context context, String[] books) {
		// TODO Auto-generated constructor stub
		 mContext = context;
		 this.Books = books;
	}
	 public MyAdapter(Context context, String book, int pos) {
			// TODO Auto-generated constructor stub
			 mContext = context;
			 this.book = book;
			 book_pos = pos;
		}

	    @Override
	    public void onBindViewHolder(MyAdapter.CustomViewHolder holder, int position) {
	    	
	    	if(book == null) {
	    		holder.imageView.setImageDrawable(mContext.getResources().getDrawable(books_icon[position]));
	    		holder.textView.setText(Books[position]);
	    	}
	    	else {
	    		
	    		holder.imageView.setImageDrawable(mContext.getResources().getDrawable(books_icon[book_pos]));
	    		holder.textView.setText(book+" - "+(position+1));
	    		
	    	}
	    	
	    	holder.imageView.setOnClickListener(onclicklistener);
	    	holder.textView.setOnClickListener(onclicklistener);
	    	
	    	holder.imageView.setTag(holder);
	    	holder.textView.setTag(holder);
	    }

	    @Override
	    public int getItemCount() {
	        if(Books == null)
	        	return NUM;
	        else
	        	return Books.length;
	    }

	    public class CustomViewHolder extends RecyclerView.ViewHolder {
	        protected ImageView imageView;
	        protected TextView textView;

	        public CustomViewHolder(View view) {
	            super(view);
	            this.imageView = (ImageView) view.findViewById(R.id.book_icon);
	            this.textView = (TextView) view.findViewById(R.id.book_label);
	        }
	    }
	    
	    View.OnClickListener onclicklistener = new View.OnClickListener() {
	        @Override
	        public void onClick(View view) {
	            CustomViewHolder holder = (CustomViewHolder) view.getTag();
	            int position = holder.getPosition();
	            if(Books == null)
	            	return;
	            Toast.makeText(mContext, ""+Books[position], Toast.LENGTH_SHORT).show();
	            
	            Intent i = new Intent(mContext, BookDetail.class);
	            i.putExtra("book", Books[position]);
	            i.putExtra("position", position);
	            mContext.startActivity(i);

	            
	        }
	    };
}
