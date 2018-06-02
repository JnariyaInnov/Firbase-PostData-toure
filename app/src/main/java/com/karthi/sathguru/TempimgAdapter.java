package com.karthi.sathguru;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by karthikeyansekar on 02/06/18.
 */

public class TempimgAdapter extends RecyclerView.Adapter<TempimgAdapter.ImageViewHolder> {
    private Context mContext;
    private List<TempUp> mTempup;
    private TempimgAdapter.OnItemClickListener tListener;

    TempimgAdapter(Context context, List<TempUp> temples) {
        mContext = context;
        mTempup = temples;
    }

    @Override
    public TempimgAdapter.ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.image_item, parent, false);
        return new TempimgAdapter.ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TempimgAdapter.ImageViewHolder holder, int position) {
        TempUp temple = mTempup.get(position);
        holder.textViewName.setText(temple.getmName());
        holder.textViewSomething.setText(temple.getmSomething());
        holder.textViewDate.setText(temple.getmDate());
        Picasso.get()
                .load(temple.getImageUrl())
                .placeholder(R.mipmap.ic_launcher)
                .fit()
                .centerCrop()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mTempup.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,
            View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {
        TextView textViewName;
        TextView textViewSomething;
        ImageView imageView;
        TextView textViewDate;

        ImageViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.text_view_name);
            imageView = itemView.findViewById(R.id.image_view_upload);
            textViewSomething = itemView.findViewById(R.id.text_something);
            textViewDate = itemView.findViewById(R.id.text_view_date);

            itemView.setOnClickListener(this);
            itemView.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onClick(View v) {
            if (tListener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    tListener.onItemClick(position);
                }
            }
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.setHeaderTitle("Confirm delete ?");
            MenuItem doWhatever = menu.add(Menu.NONE, 1, 1, "Not now!");
            MenuItem delete = menu.add(Menu.NONE, 2, 2, "Delete");

            doWhatever.setOnMenuItemClickListener(this);
            delete.setOnMenuItemClickListener(this);
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            if (tListener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {

                    switch (item.getItemId()) {
                        case 1:
                            tListener.onWhatEverClick(position);
                            return true;
                        case 2:
                            tListener.onDeleteClick(position);
                            return true;
                    }
                }
            }
            return false;
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);

        void onWhatEverClick(int position);

        void onDeleteClick(int position);
    }

    void setOnItemClickListener(TempimgAdapter.OnItemClickListener listener) {
        tListener = listener;
    }
}