package com.example.roomdb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class UpdateActivity extends AppCompatActivity {
    Activity activity;
    EditText edt_Name;
    EditText edt_Phone;
    EditText edt_NgaySinh;
    EditText edt_Chucvu;
    EditText edt_TinhNguyen;
    Button btn_Back;
    Button btn_UpdateUser;
    RadioButton rdb_Yes;
    private User mUser;
    private List<User> mList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update);

        initUI();
        mUser = (User) getIntent().getExtras().get("object_user");
        if(mUser != null){
            edt_Name.setText(mUser.getName());
            edt_Phone.setText(mUser.getPhone());
            edt_NgaySinh.setText(mUser.getNgaysinh());
            edt_Chucvu.setText(mUser.getChucvu());
            edt_TinhNguyen.setText(mUser.getTinhnguyen());
        }

        btn_UpdateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateUser();
            }
        });
        btn_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonBack();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void updateUser() {
        String name = edt_Name.getText().toString();
        String phone = edt_Phone.getText().toString();
        String ngaysinh = edt_NgaySinh.getText().toString();
        String chucvu = edt_Chucvu.getText().toString();
        String tinhnguyen = edt_TinhNguyen.getText().toString();

        if(TextUtils.isEmpty(name) || TextUtils.isEmpty(phone) || TextUtils.isEmpty(ngaysinh) || TextUtils.isEmpty(chucvu)|| TextUtils.isEmpty(tinhnguyen)){
            Toast.makeText(this,"Hãy nhập đủ thông tin", Toast.LENGTH_SHORT).show();
            return;
        } else if (rdb_Yes.isChecked()) {
            mUser.setName(name);
            mUser.setPhone(phone);
            mUser.setNgaysinh(ngaysinh);
            mUser.setChucvu(chucvu);
            mUser.setTinhnguyen(tinhnguyen);

            //UserDataBase.getInstance(this).userDAO().UpdateUser(mUser);
            Toast.makeText(this, "Upate User Thành Công !", Toast.LENGTH_SHORT).show();

            Intent intentResult = new Intent();
            setResult(Activity.RESULT_OK, intentResult);
            finish();
        }
    }

    public void buttonBack(){
        activity.onBackPressed();
    }
    private void initUI() {
        btn_Back = findViewById(R.id.btn_back);
        edt_Name = findViewById(R.id.edt_name);
        edt_Phone = findViewById(R.id.edt_phone);
        edt_NgaySinh = findViewById(R.id.edt_ngaysinh);
        edt_Chucvu = findViewById(R.id.edt_chucvu);
        edt_TinhNguyen = findViewById(R.id.edt_tinhnguyen);
        btn_UpdateUser = findViewById(R.id.btn_updateuser);
        rdb_Yes = findViewById(R.id.btn_yes);
    }
}