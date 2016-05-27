package com.mymusic.mymusicapp.network.mock;

import android.net.Uri;
import android.util.Log;


import com.mymusic.mymusicapp.network.NetworkConfig;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import static com.mymusic.mymusicapp.network.mock.MockHelper.makeResponse;

public class MockInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        return process(chain.request());
    }

    public Response process(Request request) {

        Uri uri = Uri.parse(request.url().toString());

        Log.d("Test Http Client", "URL call: " + uri.toString());
        Headers headers = request.headers();

        if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "search")) {
            return SongListMock.process(request);
        } else if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "add")) {
            return SongListMock.process(request);
        } else if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "modify")) {
            return SongListMock.process(request);
        } else if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "delete")) {
            return SongListMock.process(request);
        } else {
            return makeResponse(request, headers, 404, "Unknown");
        }
    }
}
