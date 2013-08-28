package com.eoe.myviewdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MySettingView extends RelativeLayout {

    private TextView tv_title;// 标题
    private TextView tv_content;// 内容
    private RelativeLayout rl_poritrait;// 肖像背景
    private ImageView iv_poritrait;// 人物肖像

    public MySettingView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public MySettingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupView(context);
        // 初始化一下里面显示的内容
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.setting_view);
        String title = a.getString(R.styleable.setting_view_title);
        String content = a.getString(R.styleable.setting_view_content);
        boolean isContent = a.getBoolean(R.styleable.setting_view_isContent,
                false);
        boolean isPoritrait = a.getBoolean(
                R.styleable.setting_view_isPoritrait, false);
        tv_title.setText(title);
        if (isContent) {
            tv_content.setVisibility(View.VISIBLE);
            tv_content.setText(content);
        } else {
            tv_content.setVisibility(View.GONE);
        }
        if (isPoritrait) {
            rl_poritrait.setVisibility(View.VISIBLE);

        } else {
            rl_poritrait.setVisibility(View.GONE);
        }

        a.recycle();// 防止多个自定义控件使用相同的参数

    }

    public MySettingView(Context context) {
        super(context);
    }

    public void setText(String text) {
        tv_content.setText(text);
    }

    @Override
    public void setBackgroundResource(int resid) {
        super.setBackgroundResource(resid);
    }

    /**
     * 初始化view对象
     * 
     * @param context
     */
    private void setupView(Context context) {
        View view = View.inflate(context, R.layout.view_setting, this);
        tv_title = (TextView) view.findViewById(R.id.textview_title);
        tv_content = (TextView) view.findViewById(R.id.textview_context);

        rl_poritrait = (RelativeLayout) view
                .findViewById(R.id.relativelayout_portrait);
        iv_poritrait = (ImageView) view.findViewById(R.id.imageview_image_bg);

        // iv_poritrait.setBackgroundResource(resid);

    }

}
