package com.mydo.demo.ui.view;

import android.view.View;

import com.youth.banner.transformer.ABaseTransformer;

/**
 * @author: LiBing.
 * @date: 2017/11/3.
 * @version: V1.0.0.
 */

public class AccordionTransformer extends ABaseTransformer {

    @Override
    protected void onTransform(View view, float position) {
        view.setPivotX(position < 0 ? 0 : view.getWidth());
        view.setScaleX(position < 0 ? 1f + position : 1f - position);
    }

}