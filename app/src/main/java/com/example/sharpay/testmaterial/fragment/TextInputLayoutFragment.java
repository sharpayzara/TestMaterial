package com.example.sharpay.testmaterial.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.example.sharpay.testmaterial.R;
import com.example.sharpay.testmaterial.util.ValidateUtil;
import com.example.sharpay.testmaterial.widget.CommonOption;
import com.trello.rxlifecycle.components.support.RxFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by sharpay on 16-10-25.
 */
public class TextInputLayoutFragment extends RxFragment {
    View view;
    TextInputLayout usernameWrapper,passwordWrapper;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_textinputlayout, null);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        usernameWrapper = (TextInputLayout) view.findViewById(R.id.usernameWrapper);
        passwordWrapper = (TextInputLayout) view.findViewById(R.id.passwordWrapper);
        usernameWrapper.setHint("Username");
        passwordWrapper.setHint("Password");
    }
    @OnClick(R.id.btn)
    void login(){
        usernameWrapper.setErrorEnabled(false);
        passwordWrapper.setErrorEnabled(false);
        CommonOption.hideKeyboard(this.getActivity());
        if(!ValidateUtil.validateEmail(usernameWrapper.getEditText().getText().toString())){
            usernameWrapper.setError("Not a valid email address!");
        }else if (!ValidateUtil.validatePassword(passwordWrapper.getEditText().getText().toString())){
            passwordWrapper.setError("Not a valid password!");
        }else{
            Toast.makeText(getActivity(),"正在登陆，请稍后。。",Toast.LENGTH_SHORT).show();
        }
    }

}
