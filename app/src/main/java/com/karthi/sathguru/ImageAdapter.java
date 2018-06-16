package com.karthi.sathguru;

/*
  Created by karthikeyansekar on 05/05/18.
 */

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
    private Context mContext;
    private List<Upload> mUploads;
    private OnItemClickListener mListener;

    ImageAdapter(Context context, List<Upload> uploads) {
        mContext = context;
        mUploads = uploads;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.image_item, parent, false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        Upload uploadCurrent = mUploads.get(position);
        holder.textViewName.setText(uploadCurrent.getmName());
        holder.textViewSomething.setText(uploadCurrent.getmSomething());
        holder.textViewDate.setText(uploadCurrent.getmDate());
        Picasso.get().load(uploadCurrent.getmProImg()).placeholder(R.drawable.user).into(holder.blogProfile);
        Picasso.get()
                .load(uploadCurrent.getImageUrl())
                .placeholder(R.drawable.loading)
                .fit()
                .centerCrop()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mUploads.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,
            View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {
        TextView textViewName;
        TextView textViewSomething;
        ImageView imageView;
        TextView textViewDate;
        CircleImageView blogProfile;

        ImageViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.text_view_name);
            imageView = itemView.findViewById(R.id.image_view_upload);
            textViewSomething = itemView.findViewById(R.id.text_something);
            textViewDate = itemView.findViewById(R.id.text_view_date);
            blogProfile = itemView.findViewById(R.id.blog_user_image);

            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            itemView.setOnClickListener(this);
            itemView.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mListener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    mListener.onItemClick(position);
                }
            }
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//            menu.setHeaderTitle("Confirm delete ?");
//            MenuItem doWhatever = menu.add(Menu.NONE, 1, 1, "Not now!");
//            MenuItem delete = menu.add(Menu.NONE, 2, 2, "Delete");
//
//            doWhatever.setOnMenuItemClickListener(this);
//            delete.setOnMenuItemClickListener(this);
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            if (mListener != null) {
                int position = getAdapterPosition();
//                if (position != RecyclerView.NO_POSITION) {
//
//                    switch (item.getItemId()) {
//                        case 1:
//                            mListener.onWhatEverClick(position);
//                            return true;
//                        case 2:
//                            mListener.onDeleteClick(position);
//                            return true;
//                    }
//                }
            }
            return false;
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);

        void onWhatEverClick(int position);

        void onDeleteClick(int position);
    }

    void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }
}