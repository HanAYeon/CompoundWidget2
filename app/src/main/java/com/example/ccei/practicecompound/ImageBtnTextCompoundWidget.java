package com.example.ccei.practicecompound;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by ccei on 2016-07-07.
 */
public class ImageBtnTextCompoundWidget extends LinearLayout {

    Context context;
    ImageButton imageBtn;
    TextView imageView;
    ImageTextData data;

    OnCompoundNewListener newListener;

    public interface OnCompoundNewListener {
        public void onImageBtnClick(ImageBtnTextCompoundWidget compoundWidget, ImageTextData data);
    }

    public void setOnImageBtnClickListener(OnCompoundNewListener listener) {
        newListener = listener;
    }

    public ImageBtnTextCompoundWidget(Context context) {
        super(context);
        this.context = context;
        init(null);
    }

    public ImageBtnTextCompoundWidget(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(attrs);
    }

    public ImageBtnTextCompoundWidget(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        this.setOrientation(HORIZONTAL);
        View root = inflate(context, R.layout.text_btn_layout, this);

        imageBtn = (ImageButton) root.findViewById(R.id.image_btn);
        imageView = (TextView) root.findViewById(R.id.image_text);

        imageBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(newListener != null) {
                    newListener.onImageBtnClick(ImageBtnTextCompoundWidget.this, data);
                }
            }
        });

        if(attrs != null) {
            TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.ImageTextCompoundWidget);
            String memberName = ta.getString(R.styleable.ImageTextCompoundWidget_membername);
            int imageResID = ta.getResourceId(R.styleable.ImageTextCompoundWidget_myimage, R.drawable.student);
            imageBtn.setImageResource(imageResID);
            imageView.setText(memberName);
        }

    }

    public void setImageText(ImageTextData data) {
        this.data = data;
        imageBtn.setImageResource(data.iconID);
        imageView.setText(data.title);
    }


}
