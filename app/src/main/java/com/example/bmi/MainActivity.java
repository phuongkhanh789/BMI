package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {
    EditText ehoten, ecannang, echieucao;
    Button btnKT, btnTiep, btnThoat;
    TextView txtKq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Truy xuất View
        ConnectView();
        //AddEvents cho View
        AddEvents();
    }
    //Gán sự kiện cho View
    void AddEvents() {
        btnKT.setOnClickListener(this);
        btnTiep.setOnClickListener(this);
        btnThoat.setOnClickListener(this);
    }
    //Hàm kết nối đến các View
    private void ConnectView() {
        ehoten = (EditText) findViewById(R.id.edithotenid);
        ecannang = (EditText) findViewById(R.id.editcannangid);
        echieucao = (EditText) findViewById(R.id.editchieucaoid);

        btnKT = (Button) findViewById(R.id.btnkiemtraid);
        btnTiep = (Button) findViewById(R.id.btntiepid);
        btnThoat = (Button) findViewById(R.id.btnthoatid);

        txtKq = (TextView) findViewById(R.id.txtkqid);
    }

    @Override
    public void onClick(View v) {
        String ht,kq;
        double cannang, chieucao;
        double BMI;
        if(v.equals(btnKT)){
            //Xử lý btn kiểm tra
            ht = ehoten.getText().toString();
            cannang = Double.parseDouble(ecannang.getText().toString());
            chieucao = Double.parseDouble(ecannang.getText().toString());
            BMI = cannang/(chieucao*chieucao);
            if(BMI<18){
                txtKq.setText("Kết quả : Bạn " + ht + " gầy quá");
            } else if (BMI<24.9){
                txtKq.setText("Kết quả : Bạn " + ht + " bình thường");
            } else if (BMI<29.9){
                txtKq.setText("Kết quả : Bạn " + ht + " bạn đang bị béo phì độ I");
            } else if (BMI<34.9){
                txtKq.setText("Kết quả : Bạn " + ht + " bạn đang bị béo phì độ II");
            } else {
                txtKq.setText("Kết quả : Bạn " + ht + " bạn đang bị béo phì độ III");
            }
        } else if(v.equals(btnTiep)){
            //Xử lý btn tiếp, xoá trắng nội dung
            ehoten.setText(" ");
            ecannang.setText(" ");
            echieucao.setText(" ");
        }else if(v.equals(btnThoat)){
            //Xử lý sự kiện thoát
            finish();
        }
    }
}