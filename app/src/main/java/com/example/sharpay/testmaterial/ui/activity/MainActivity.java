package com.example.sharpay.testmaterial.ui.activity;

import android.os.Bundle;

import com.example.sharpay.testmaterial.R;
import com.example.sharpay.testmaterial.ui.fragment.MainFragment;
import com.example.sharpay.testmaterial.rxbus.RxBus;
import com.trello.rxlifecycle.components.support.RxFragmentActivity;

public class MainActivity extends RxFragmentActivity {

    private RxBus _rxBus;

    /**获取RxBus对象*/
    public RxBus getRxBusSingleton() {
        if (_rxBus == null) {
            _rxBus = new RxBus();
        }
        return _rxBus;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
    }

    private void initFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_content, new MainFragment(), MainFragment.class.getName())
                .commit();
    }
}
