package com.mydo.demo.ui.widget;

/**
 * @author: LiBing.
 * @date: 2017/11/1.
 * @version: V1.0.0.
 */

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.Resources;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;


import com.mydo.demo.R;

import java.lang.ref.WeakReference;

/**
 * Created by cyandev on 2016/12/14.
 */
public class HeaderFloatBehavior extends CoordinatorLayout.Behavior<View> {

    private WeakReference<View> dependentView;
    private ArgbEvaluator argbEvaluator;

    public HeaderFloatBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);

        argbEvaluator = new ArgbEvaluator();
    }

    /**
     * 这个方法在对界面进行布局时至少会调用一次，用来确定本次交互行为中的dependent view，
     * 在上面的代码中，当dependency是Button类的实例时返回true，
     * 就可以让系统知道布局文件中的Button就是本次交互行为中的dependent view
     * @param parent
     * @param child
     * @param dependency
     * @return
     */
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        if (dependency != null && dependency.getId() == R.id.heade_img) {
            dependentView = new WeakReference<>(dependency);
            return true;
        }
        return false;
    }

    /**
     * 当dependent view发生变化时，这个方法会被调用，参数中的child相当于本次交互行为中的观察者，
     * 观察者可以在这个方法中对被观察者的变化做出响应，从而完成一次交互行为。
     * @param parent
     * @param child
     * @param dependency
     * @return
     */
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        Resources resources = getDependentView().getResources();
        final float progress = 1.f -
                Math.abs(dependency.getTranslationY() / (dependency.getHeight() - resources.getDimension(R.dimen.collapsed_header_height)));

        // Translation
        final float collapsedOffset = resources.getDimension(R.dimen.collapsed_float_offset_y);
        final float initOffset = resources.getDimension(R.dimen.init_float_offset_y);
        final float translateY = collapsedOffset + (initOffset - collapsedOffset) * progress;
        child.setTranslationY(translateY);

        // Background
        child.setBackgroundColor((int) argbEvaluator.evaluate(
                progress,
                resources.getColor(R.color.colorCollapsedFloatBackground),
                resources.getColor(R.color.colorInitFloatBackground)));

        // Margins
        final float collapsedMargin = resources.getDimension(R.dimen.collapsed_float_margin);
        final float initMargin = resources.getDimension(R.dimen.init_float_margin);
        final int margin = (int) (collapsedMargin + (initMargin - collapsedMargin) * progress);
        CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) child.getLayoutParams();
        lp.setMargins(margin, 0, margin, 0);
        child.setLayoutParams(lp);

        return true;
    }

    private View getDependentView() {
        return dependentView.get();
    }

}
