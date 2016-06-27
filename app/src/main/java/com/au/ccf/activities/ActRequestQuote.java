package com.au.ccf.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.au.ccf.R;
import com.au.ccf.global.CCFApplication;
import com.au.ccf.utils.ActivityUtil;

import java.util.List;


/**
 * Created by rezarachman on 6/18/16.
 */
public class ActRequestQuote extends ActBase implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    public static final String JOB_TYPE = "JOB_TYPE";
    public static final String EQUIPMENT_TYPE = "EQUIPMENT_TYPE";
    public static final String QUANTITY = "QUANTITY";

    private EditText vInputOrganization;
    private EditText vInputContactPerson;
    private EditText vInputEmail;
    private EditText vInputTelephone;
    private EditText vInputQuantity;
    private Spinner vInputJobType;
    private Spinner vInputEquipmentType;
    private Button vOKButton;
    private String mSelectedJobType;
    private String mSelectedEquipmentType;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_request_quote);
        setHeaderTitle(getString(R.string.header_quote_request), true);
        initView();
        initListener();
        populateJobType();
        populateEquipmentType();
    }

    private void initView() {
        vInputOrganization = (EditText) findViewById(R.id.input_organization);
        vInputContactPerson = (EditText) findViewById(R.id.input_contact_person);
        vInputEmail = (EditText) findViewById(R.id.input_email);
        vInputTelephone = (EditText) findViewById(R.id.input_telephone);
        vInputQuantity = (EditText) findViewById(R.id.input_quantity);
        vInputJobType = (Spinner) findViewById(R.id.input_job_type);
        vInputEquipmentType = (Spinner) findViewById(R.id.input_equipment_type);
        vOKButton = (Button) findViewById(R.id.button_request_quote);
    }

    private void initListener() {
        vOKButton.setOnClickListener(this);
        vInputJobType.setOnItemSelectedListener(this);
        vInputEquipmentType.setOnItemSelectedListener(this);
    }

    private void populateJobType() {
        List<String> jobTypes = CCFApplication.getInstance().getJobTypeList();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, jobTypes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vInputJobType.setAdapter(adapter);
    }

    private void populateEquipmentType() {
        List<String> equipmentTypes = CCFApplication.getInstance().getEquipmentTypeList();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, equipmentTypes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vInputEquipmentType.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        if (vOKButton.equals(v)) {
            String quantity = vInputQuantity.getText().toString();
            Bundle bundle = new Bundle();
            bundle.putString(JOB_TYPE, mSelectedJobType);
            bundle.putString(EQUIPMENT_TYPE, mSelectedEquipmentType);
            bundle.putString(QUANTITY, quantity);
            ActivityUtil.startActivity(this, ActRequestQuoteConfirmation.class, bundle, 0);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.input_job_type) {
            mSelectedJobType = CCFApplication.getInstance().getJobTypeList().get(position);
        } else if (parent.getId() == R.id.input_equipment_type) {
            mSelectedEquipmentType = CCFApplication.getInstance().getEquipmentTypeList().get(position);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
