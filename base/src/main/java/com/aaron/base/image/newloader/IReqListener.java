package com.aaron.base.image.newloader;

/**
 * @author Aaron aaronzheng9603@gmail.com
 */
public interface IReqListener<T> {

    boolean onSuccess(T resource);

    boolean onFailure(Throwable e);
}
