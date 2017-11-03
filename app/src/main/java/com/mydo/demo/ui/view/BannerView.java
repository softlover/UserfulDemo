package com.mydo.demo.ui.view;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.mydo.demo.R;
import com.mydo.demo.adapter.BannerViewPageAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: LiBing.
 * @date: 2017/11/3.
 * @version: V1.0.0.
 */

public class BannerView extends FrameLayout {

    private ConvenientBanner convenientBanner;
    private LinearLayout mGroupPoint;
    private BannerViewPageAdapter mBannerAdapter;
    private List<String> mBanners;
    private List<String> mBannerImc;


    public BannerView(@NonNull Context context) {
        super(context);
        initView();
    }

    public BannerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }


    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.item_home_banner_at, this, true);
        convenientBanner = (ConvenientBanner) findViewById(R.id.convenientBanner);
        ArrayList<String> transformerList = new ArrayList<String>();
        transformerList.add(AccordionTransformer.class.getSimpleName());
        String transforemerName =transformerList.get(0);
        try {
//            Class cls = Class.forName("com.toxicbakery.viewpager.transforms." + transforemerName);
//            ABaseTransformer transforemer = (ABaseTransformer) cls.newInstance();
            AccordionTransformer l = new AccordionTransformer();
            convenientBanner.getViewPager().setPageTransformer(true, l);

            //部分3D特效需要调整滑动速度
            if (transforemerName.equals("StackTransformer")) {
                convenientBanner.setScrollDuration(1200);
            }


            convenientBanner.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    if (mBanners == null){
                        return;
                    }


                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void obtainBannerInfo(List<String> banners) {
        if (banners != null && banners.size() > 0) {
            mBanners = banners;
            if (mBannerImc == null)
                mBannerImc = new ArrayList<String>();

            mBannerImc.clear();
            for (int i = 0; i < banners.size(); i++) {
                mBannerImc.add(banners.get(i));
            }

            //自定义你的Holder，实现更多复杂的界面，不一定是图片翻页，其他任何控件翻页亦可。
            convenientBanner.setPages(
                    new CBViewHolderCreator<NetworkImageHolderView>() {
                        @Override
                        public NetworkImageHolderView createHolder() {
                            return new NetworkImageHolderView();
                        }
                    }, mBannerImc)
                    //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                    .setPageIndicator(new int[]{R.mipmap.ic_page_indicator, R.mipmap.ic_page_indicator_focused})
                    //设置指示器的方向
                    .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);
            //设置翻页的效果，不需要翻页效果可用不设
            //.setPageTransformer(Transformer.DefaultTransformer);    集成特效之后会有白屏现象，新版已经分离，如果要集成特效的例子可以看Demo的点击响应。
//        convenientBanner.setManualPageable(false);//设置不能手动影响
        }
    }

    // 开始自动翻页
    public void onResume() {
        //开始自动翻页
        if (convenientBanner != null)
            convenientBanner.startTurning(5000);
    }

    // 停止自动翻页
    public void onPause() {
        //停止翻页
        if (convenientBanner != null)
            convenientBanner.stopTurning();
    }
}
