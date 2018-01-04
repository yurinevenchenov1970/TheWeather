package com.github.yurinevenchenov1970.theweather.model;

import com.github.yurinevenchenov1970.theweather.presenter.MainPresenter;

/**
 * @author Yuri Nevenchenov on 12/20/2017.
 */

public class MainModel {
    private final MainPresenter mMainPresenter;

    public MainModel(MainPresenter mainPresenter) {
        mMainPresenter = mainPresenter;
    }
}