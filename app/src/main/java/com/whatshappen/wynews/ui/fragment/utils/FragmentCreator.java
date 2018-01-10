package com.whatshappen.wynews.ui.fragment.utils;

import com.whatshappen.wynews.base.BaseFragment;

/**
 * @author created by Wangw ;
 * @version 1.0
 * @data created time at 2018/1/10 ;
 * @Description fragment创建接口
 */
public interface FragmentCreator {

    <T extends BaseFragment>T creatFragment(Class<T> clazz);
}
