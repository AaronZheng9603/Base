package com.aaron.baselib.impl;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * RxJava Observer 的空实现
 *
 * @author Aaron
 * @email aaronzheng9603@gmail.com
 * @date 2019/8/12
 */
public abstract class ObserverImpl<T> implements Observer<T> {

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
