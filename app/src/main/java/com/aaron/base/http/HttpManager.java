package com.aaron.base.http;

import androidx.annotation.NonNull;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

import java.util.HashMap;
import java.util.Map;

/**
 * Retrofit Service 接口管理器
 *
 * @author Aaron
 * @email aaronzheng9603@gmail.com
 * @date 2019/8/12
 */
public class HttpManager {

    private Retrofit mRetrofit;

    private IService mEmptyService;

    private Map<Object, IService> mServiceMap = new HashMap<>();

    public static HttpManager getInstance() {
        return Holder.INSTANCE;
    }

    public void setBaseUrl(String baseUrl) {
        setBaseUrl(baseUrl, null);
    }

    public void setBaseUrl(String baseUrl, OkHttpClient client) {
        mRetrofit = HttpUtil.getRetrofit(baseUrl, client);
    }

    @NonNull
    public IService getService(Object tag) {
        IService service = mServiceMap.get(tag);
        if (service == null) {
            return mEmptyService;
        }
        return service;
    }

    public void putService(Object tag, IService service) {
        mServiceMap.put(tag, service);
    }

    public void clear() {
        mServiceMap.clear();
    }

    private HttpManager() {
        mEmptyService = new ServiceImpl();
    }

    private static class Holder {
        private static final HttpManager INSTANCE = new HttpManager();
    }
}
