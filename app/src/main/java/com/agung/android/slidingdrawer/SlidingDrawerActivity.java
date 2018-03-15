package com.agung.android.slidingdrawer;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Button;

import com.github.ali.android.client.customview.view.SlidingDrawer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.agung.android.slidingdrawer.SlidingDrawerFragment.ARG_STICK_TO;

public class SlidingDrawerActivity extends AppCompatActivity {

    private static final String TAG = "SlidingDrawerActivity";
    @BindView(R.id.btn_tekan_aku)
    Button mTekanAku;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_drawer);
        ButterKnife.bind(this);
        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            final int stickTo = getIntent().getIntExtra(ARG_STICK_TO, 0);
            SlidingDrawerFragment fragment = SlidingDrawerFragment.newInstance(stickTo);
            fragmentManager.beginTransaction().replace(
                    R.id.content_fragment,
                    fragment,
                    SlidingDrawerFragment.TAG)
                    .commit();
        }
    }

    @OnClick(R.id.btn_tekan_aku)
    public void setbutton() {
        final SlidingDrawerFragment fragment = (SlidingDrawerFragment)
                getSupportFragmentManager().findFragmentByTag(SlidingDrawerFragment.TAG);
        final SlidingDrawer slidingDrawer = fragment.getSlidingDrawer();
        if (slidingDrawer.isClosed()) {
            slidingDrawer.openDrawer();
        }else {
            slidingDrawer.closeDrawer();
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                final SlidingDrawerFragment fragment = (SlidingDrawerFragment)
                        getSupportFragmentManager().findFragmentByTag(SlidingDrawerFragment.TAG);
                final SlidingDrawer slidingDrawer = fragment.getSlidingDrawer();
                if (slidingDrawer.isOpened()) {
                    slidingDrawer.closeDrawer();
                    return true;
                }

            default:
                return super.onKeyDown(keyCode, event);
        }
    }
}

//
//}
