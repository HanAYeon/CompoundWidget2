package com.example.ccei.practicecompound;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageBtnTextCompoundWidget cpWidget;
    boolean flag = true;
    Button backBtn;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cpWidget = (ImageBtnTextCompoundWidget)findViewById(R.id.compound_widget);
        cpWidget.setOnImageBtnClickListener(new ImageBtnTextCompoundWidget.OnCompoundNewListener(){
            @Override
            public void onImageBtnClick(ImageBtnTextCompoundWidget compoundWidget, ImageTextData data) {
                if(data != null) {
                    Toast.makeText(getApplicationContext(), "바뀌어라라아라아", Toast.LENGTH_SHORT).show();
                }
            }

        });

        cpWidget.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (flag) {
                    cpWidget.setImageText(new ImageTextData("Hello", R.drawable.pen));
                } else {
                    cpWidget.setImageText(new ImageTextData("뀨류뀨류", R.drawable.pencil));
                }
                flag = !flag;
            }
        });

        backBtn = (Button)findViewById(R.id.back);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cpWidget.setImageText(new ImageTextData("안녕?", R.drawable.student));
            }
        });





    }
}
