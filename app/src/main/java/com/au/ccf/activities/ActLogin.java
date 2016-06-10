package com.au.ccf.activities;

import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.au.ccf.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActLogin extends ActBase {

    private BottomSheetBehavior mBottomSheetBehavior;

    @BindView(R.id.bottom_sheet)
    View mBottomSheet;

    @BindView(R.id.input_user_name)
    EditText mInputUserName;

    @BindView(R.id.input_password)
    EditText mInputPassword;

    @BindView(R.id.input_role)
    EditText mInputRole;

    @BindView(R.id.button_submit)
    EditText mButtonSubmit;

    @BindView(R.id.text_forgot_password)
    TextView mTextForgotPassword;

    @BindView(R.id.text_sign_up)
    TextView mTextSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_login);
        ButterKnife.bind(this);

        mBottomSheetBehavior = BottomSheetBehavior.from(mBottomSheet);
    }

    @OnClick({ R.id.input_role, R.id.button_submit, R.id.text_forgot_password })
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.input_role:
                break;
            case R.id.button_submit:
                break;
            case R.id.text_forgot_password:
                break;
            case R.id.text_sign_up:
                break;
        }
    }

}
