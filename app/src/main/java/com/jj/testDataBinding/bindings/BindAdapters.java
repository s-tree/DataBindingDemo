package com.jj.testDataBinding.bindings;

import android.databinding.BindingAdapter;
import android.graphics.Color;
import android.view.View;

public class BindAdapters {

    /**
     * 实现注解 BindingAdapter
     * 注解的 value 是xml 要引用的属性
     * 被注解的方法必须是 public static
     * 方法的第一个参数必须是 View
     * 此注解实现的是 age >= 18 的显示绿色背景，其余的显示白色背景
     *
     * @param view
     * @param isShowBg
     */
    @BindingAdapter("Adult")
    public static void showBackground(View view,boolean isShowBg){
        view.setBackgroundColor(isShowBg ? Color.GREEN : Color.WHITE);
    }
}
