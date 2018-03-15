package com.agung.android.slidingdrawer;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.github.ali.android.client.customview.view.SlidingDrawer;

import static com.github.ali.android.client.customview.view.SlidingDrawer.STICK_TO_BOTTOM;
import static com.github.ali.android.client.customview.view.SlidingDrawer.STICK_TO_LEFT;
import static com.github.ali.android.client.customview.view.SlidingDrawer.STICK_TO_RIGHT;
import static com.github.ali.android.client.customview.view.SlidingDrawer.STICK_TO_TOP;

/**
 * Created by agung on 13/03/18.
 */

public class SlidingDrawerFragment extends Fragment implements SlidingDrawer.OnInteractListener{

    public static final String TAG = "SlidingDrawerFragment";
    public static final String ARG_STICK_TO = "stickTo";

    private ImageView mImageView;
    private SlidingDrawer mSlidingDrawer;

    public static SlidingDrawerFragment newInstance(int stickTo){
        SlidingDrawerFragment fragment = new SlidingDrawerFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_STICK_TO, stickTo);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView()");
        final Bundle args = getArguments();
        int resource = 0;
        switch (args.getInt(ARG_STICK_TO)){
            case STICK_TO_BOTTOM:
                resource = R.layout.fragment_sliding_drawer_bottom;
                break;
            case STICK_TO_LEFT:
                resource = R.layout.fragment_sliding_drawer_left;
                break;
            case STICK_TO_RIGHT:
                resource = R.layout.fragment_sliding_drawer_right;
                break;
            case STICK_TO_TOP:
                resource = R.layout.fragment_sliding_drawer_top;
                break;
        }
        return inflater.inflate(resource, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Log.d(TAG, "onViewCreated()");
        super.onViewCreated(view, savedInstanceState);
        mImageView = (ImageView)view.findViewById(R.id.slidingImage);
        mSlidingDrawer = (SlidingDrawer)view.findViewById(R.id.slidingDrawer);
        mSlidingDrawer.setOnInteractListener(this);
    }

    @Override
    public void onOpened() {
        if (SlidingDrawer.DEBUG) Log.d(TAG, "onOpened()");
        mImageView.setImageResource(R.drawable.ic_arrow_down);
    }

    @Override
    public void onClosed() {
        if (SlidingDrawer.DEBUG) Log.d(TAG, "onClosed()");
        mImageView.setImageResource(R.drawable.ic_arrow_up);
    }

    public SlidingDrawer getSlidingDrawer(){
        return mSlidingDrawer;
    }
}
