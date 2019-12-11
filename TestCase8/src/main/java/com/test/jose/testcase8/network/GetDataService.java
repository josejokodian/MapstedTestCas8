package com.test.jose.testcase8.network;

import com.test.jose.testcase8.model.AnalyticsDataList;
import com.test.jose.testcase8.model.DatasetsList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by praka on 12/24/2017.
 */

public interface GetDataService {

    @GET("/api/Values/GetBuildingData")
    Call<List<DatasetsList>> getbuildings();
    @GET("/api/Values/GetAnalyticData")
    Call<List<AnalyticsDataList>> getAnalytics();
}
