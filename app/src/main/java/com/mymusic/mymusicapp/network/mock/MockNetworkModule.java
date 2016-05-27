package com.mymusic.mymusicapp.network.mock;

import com.mymusic.mymusicapp.network.CreateApi;
import com.mymusic.mymusicapp.network.DeleteApi;
import com.mymusic.mymusicapp.network.ModifyApi;
import com.mymusic.mymusicapp.network.SearchApi;
import com.mymusic.mymusicapp.network.prod.NetworkModule;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;


@Module
public class MockNetworkModule {
    private NetworkModule networkModule = new NetworkModule();

    @Provides
    @Singleton
    public OkHttpClient.Builder provideOkHttpClientBuilder() {
        return networkModule.provideOkHttpClientBuilder();
    }


    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {
        builder.interceptors().add(0, new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                return MockHttpServer.call(request);
            }
        });
        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client) {
        return networkModule.provideRetrofit(client);
    }

    @Provides
    @Singleton
    public SearchApi provideDefaultApi(Retrofit retrofit) {
        return retrofit.create(SearchApi.class);
    }
    @Provides
    @Singleton
    public CreateApi provideCreateApi(Retrofit retrofit) {
        return retrofit.create(CreateApi.class);
    }
    @Provides
    @Singleton
    public DeleteApi provideDeleteApi(Retrofit retrofit) {
        return retrofit.create(DeleteApi.class);
    }
    @Provides
    @Singleton
    public ModifyApi provideModifyApi(Retrofit retrofit) {
        return retrofit.create(ModifyApi.class);
    }

}
