package com.example.panguangyi.imageloader;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.panguangyi.imageloader.imageloader.ImageLoader;

import java.util.List;

/**
 * ************************
 * $claass
 * <p>
 * ${date} $Created by panguangyi on 2017/7/7.
 */

public class ImageAdapter extends BaseAdapter {
    private Activity mContext;
    private List<String> mUrlList;
    private boolean mIsGridViewIdle = true,mIsWifi = true;
    private Drawable mDefaultDrawable;
    private ImageLoader mImageLoader;
    private int mImageWidth;

    public ImageAdapter(Activity context, List<String> list, boolean isGridViewIdle, boolean isWifi, ImageLoader imageLoader, int imageWidth) {
        this.mContext = context;
        this.mUrlList = list;
        this.mIsGridViewIdle = isGridViewIdle;
        this.mIsWifi = isWifi;
        this.mDefaultDrawable = context.getResources().getDrawable(R.drawable.ic_launcher);
        this.mImageLoader = imageLoader;
        this.mImageWidth = imageWidth;
    }
    @Override
    public int getCount() {
        return mUrlList.size();
    }

    @Override
    public String getItem(int i) {
        return mUrlList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.gridview_item,parent,false);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.iv_item);
//            holder.draweeView = convertView.findViewById(R.id.iv_item);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        ImageView imageView = holder.imageView;
        final String tag = (String) imageView.getTag();
//        SimpleDraweeView draweeView = holder.draweeView;
        String uri = getItem(position);
//        RequestOptions options = new RequestOptions().centerCrop().placeholder(R.drawable.ic_launcher);
//        Glide.with(mContext).load(uri).apply(options).into(imageView);
//        draweeView.setImageURI(uri);

        if (!uri.equals(tag)) {
            imageView.setImageDrawable(mDefaultDrawable);
        }
        if (mIsGridViewIdle && mIsWifi) {
            imageView.setTag(uri);
            mImageLoader.bindBitmap(uri,imageView,mImageWidth,mImageWidth);
        }

        return convertView;
    }

    static class ViewHolder {
        ImageView imageView;
//        SimpleDraweeView draweeView;
    }
}
