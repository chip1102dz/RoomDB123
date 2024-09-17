package com.example.roomdb;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InforActivity extends AppCompatActivity {
    Activity activity;
    TextView tv_Name;
    TextView tv_Phone;
    TextView tv_NgaySinh;
    TextView tv_ChucVu;
    TextView tv_TinhNguyen;
    Button btn_Back;
    private User mUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_infor);
        initUI();

        mUser = (User) getIntent().getExtras().get("info_user");
        if(mUser != null){
            tv_Name.setText(mUser.getName());
            tv_Phone.setText(mUser.getPhone());
            tv_NgaySinh.setText(mUser.getNgaysinh());
            tv_ChucVu.setText(mUser.getChucvu());
            tv_TinhNguyen.setText(mUser.getTinhnguyen());
        }

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

    public void initUI(){
        tv_Name = findViewById(R.id.tv_name);
        tv_Phone = findViewById(R.id.tv_phone);
        tv_NgaySinh = findViewById(R.id.tv_ngaysinh);
        tv_ChucVu = findViewById(R.id.tv_chucvu);
        tv_TinhNguyen = findViewById(R.id.tv_tinhnguyen);
        btn_Back = findViewById(R.id.btn_back);
    }
    public void buttonBack(){
        activity.onBackPressed();
    }

}