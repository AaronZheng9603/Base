package com.aaron.baselib.impl;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * TextWatcher 空实现
 *
 * @author Aaron
 * @email aaronzheng9603@gmail.com
 * @date 2019/8/12
 */
public abstract class TextWatcherImpl implements TextWatcher {

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
