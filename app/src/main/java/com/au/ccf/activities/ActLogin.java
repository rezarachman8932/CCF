package com.au.ccf.activities;

import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.au.ccf.R;
import com.au.ccf.adapters.RoleAdapter;
import com.au.ccf.global.CCFApplication;
import com.au.ccf.utils.ActivityUtil;

public class ActLogin extends ActBase implements View.OnClickListener {

    private EditText vInputUserName;
    private EditText vInputPassword;
    private EditText vInputRole;
    private Button vButtonSubmit;
    private TextView vTextForgotPassword;
    private TextView vTextSignUp;
    private BottomSheetDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_login);

        initView();
        initListener();
    }

    private void initView() {
        mDialog = new BottomSheetDialog(this);
        vInputUserName = (EditText) findViewById(R.id.input_user_name);
        vInputPassword = (EditText) findViewById(R.id.input_password);
        vInputRole = (EditText) findViewById(R.id.input_role);
        if (vInputRole != null) {
            vInputRole.setInputType(InputType.TYPE_NULL);
        }
        vButtonSubmit = (Button) findViewById(R.id. button_submit);
        vTextForgotPassword = (TextView) findViewById(R.id.text_forgot_password);
        vTextSignUp = (TextView) findViewById(R.id.text_sign_up);
    }

    private void initListener() {
        vTextSignUp.setOnClickListener(this);
        vTextForgotPassword.setOnClickListener(this);
        vButtonSubmit.setOnClickListener(this);
        vInputRole.setOnClickListener(this);
    }

    private void submit() {
        String username = vInputUserName.getText().toString();
        String password = vInputPassword.getText().toString();
        String role = vInputRole.getText().toString();

        if (username.equalsIgnoreCase("member")) {
            ActivityUtil.startActivity(this, ActLandingMember.class, null, 0);
        } else {
            ActivityUtil.startActivity(this, ActLandingProvider.class, null, 0);
        }
    }

    private void signUp() {

    }

    private void forgotPassword() {

    }

    private void showRoleList() {
        RoleAdapter roleAdapter = new RoleAdapter(CCFApplication.getInstance().getRoleList());
        roleAdapter.setOnItemClickListener(new RoleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(RoleAdapter.RoleHolder item, int position) {
                String selectedRole = CCFApplication.getInstance().getRoleList().get(position);
                vInputRole.setText(selectedRole);
                mDialog.dismiss();
            }
        });

        View view = getLayoutInflater().inflate(R.layout.bottom_sheet_list, null);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list_role);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(roleAdapter);

        mDialog.setContentView(view);
        mDialog.show();
    }

    @Override
    public void onClick(View v) {
        if (v.equals(vButtonSubmit)) {
            submit();
        } else if (v.equals(vTextForgotPassword)) {
            forgotPassword();
        } else if (v.equals(vTextSignUp)) {
            signUp();
        } else {
            showRoleList();
        }
    }

}
