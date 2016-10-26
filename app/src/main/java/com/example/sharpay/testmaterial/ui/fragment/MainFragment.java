package com.example.sharpay.testmaterial.ui.fragment;

/**
 * Created by sharpay on 16-10-25.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sharpay.testmaterial.R;
import com.example.sharpay.testmaterial.ui.activity.NavigationActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 主菜单Fragment
 * Created by ljb on 2016/3/23.
 */
public class MainFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.drawer_btn)
    void drawer_btn() {
        startActivity(new Intent(MainFragment.this.getContext(), NavigationActivity.class));
    }

    @OnClick(R.id.btn_net)
    void btn_net() {
        open(new TextInputLayoutFragment());
    }

    /**
     * 开启新的Fragment
     */
    private void open(Fragment fragment) {
        final String tag = fragment.getClass().toString();
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(tag)
                .replace(R.id.main_content, fragment, tag)
                .commit();
    }

}
