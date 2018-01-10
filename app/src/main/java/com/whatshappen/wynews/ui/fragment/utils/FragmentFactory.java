package com.whatshappen.wynews.ui.fragment.utils;

import com.whatshappen.wynews.base.BaseFragment;

/**
 * @author created by Wangw ;
 * @version 1.0
 * @data created time at 2018/1/10 ;
 * @Description fragment工厂
 */
public class FragmentFactory{

    public static <T extends BaseFragment>BaseFragment creat(Class<T> clazz){
        return Creator.getInstance().creatFragment(clazz);
    }

    private static class Creator implements FragmentCreator{

        private static final Creator creator = new Creator();

        public static Creator getInstance(){
            return creator;
        }

        @Override
        public <T extends BaseFragment> T creatFragment(Class<T> clazz) {
            BaseFragment baseFragment = null ;

            try {
                baseFragment = (BaseFragment) Class.forName(clazz.getName()).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            return (T) baseFragment;
        }
    }
}
