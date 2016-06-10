package com.au.ccf.activities;

import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.au.ccf.R;
import com.au.ccf.adapters.RoleAdapter;
import com.au.ccf.global.CCFApplication;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActLogin extends ActBase {

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

//        BottomSheetBehavior mBottomSheetBehavior = BottomSheetBehavior.from(mBottomSheet);
    }

    @OnClick({ R.id.input_role, R.id.button_submit, R.id.text_forgot_password })
    void onActionClick(View view) {
        switch (view.getId()) {
            case R.id.input_role:
                showRoleList();
                break;
            case R.id.button_submit:
                break;
            case R.id.text_forgot_password:
                break;
            case R.id.text_sign_up:
                break;
        }
    }

    private void showRoleList() {
        RoleAdapter roleAdapter = new RoleAdapter(CCFApplication.getInstance().getRoleList());
        roleAdapter.setOnItemClickListener(new RoleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(RoleAdapter.RoleHolder item, int position) {

            }
        });

        RecyclerView recyclerView = (RecyclerView) mBottomSheet.findViewById(R.id.list_role);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(roleAdapter);

        BottomSheetDialog dialog = new BottomSheetDialog(this);
        dialog.setContentView(mBottomSheet);
        dialog.show();
    }

}
