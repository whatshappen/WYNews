package com.whatshappen.wynews.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.whatshappen.wynews.R;
import com.whatshappen.wynews.utils.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author created by Wangw ;
 * @version 1.0
 * @data created time at 2018/1/10 ;
 * @Description 有toolbar的Activity基类
 */
public abstract class APPActivity extends BaseActivity {

    @BindView(R.id.tool_bar)
    public Toolbar toolBar;
    @BindView(R.id.ib_back)
    public ImageButton imgBtnBack;//返回键
    @BindView(R.id.tv_follow_up)
    public TextView tvFollowUp;//跟帖数
    @BindView(R.id.ib_more)
    public ImageButton imgBtnMore;//更多操作
    @BindView(R.id.fl_content)
    public FrameLayout flContent;//具体内容

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        setSupportActionBar(toolBar);//设置actionbar

        flContent.removeAllViews();//移除子Veiw
        //添加content布局
        flContent.addView(setContentViewId());
        //初始化
        initListener();
        initData();
    }

    @OnClick({R.id.ib_back, R.id.tv_follow_up, R.id.ib_more})
    void click(View v) {
        switch (v.getId()) {
            case R.id.ib_back://返回
                this.finish();
                break;
            case R.id.tv_follow_up://跟帖
                ToastUtils.showToast(getBaseContext(),"跟帖",0);
                break;
            case R.id.ib_more://更多
                ToastUtils.showToast(getBaseContext(),"更多",0);
                break;
            default:
                break;

        }
    }

    /**
     * 用于子类设置具体内容布局，子类必须实现
     *
     * @return
     */
    protected abstract View setContentViewId();

    /**
     * 初始化数据
     */
    protected void initData() {

    }

    /**
     * 初始化监听
     */
    protected void initListener() {

    }

}
