package com.mymusic.mymusicapp.network.mock;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;


public class PeopleMock {
/*
    static List<Person> peopleList = new ArrayList<>();
    static boolean isInitialised = false;

    public static Person testP1 = new Person("Network Test 1");
    public static Person testP2 = new Person("Network Test 2");

    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString;
        int responseCode;
        Headers headers = request.headers();

        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "people") && request.method().equals("GET")) {
            if (!isInitialised) {
                peopleList.add(testP1);
                peopleList.add(testP2);
                isInitialised = true;
            }
            responseString = GsonHelper.getGson().toJson(peopleList);
            responseCode = 200;
        } else if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "people/add") && request.method().equals("GET")) {
            int startOfData = uri.getPath().lastIndexOf('/');
            String name = uri.getPath().substring(startOfData + 1);
            peopleList.add(new Person(name));

            responseString = "";
            responseCode = 200;
        } else {
            responseString = "ERROR";
            responseCode = 503;
        }

        return MockHelper.makeResponse(request, headers, responseCode, responseString);
    }

    public static void resetList() {
        peopleList.clear();
        isInitialised = false;
    }*/
}
