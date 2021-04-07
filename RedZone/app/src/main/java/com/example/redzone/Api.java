package com.example.redzone;

import java.util.HashMap;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {


    String BASE_URL = "https://iamtauhid.pythonanywhere.com";

    @GET("user_detail/")
    Call<RedUser> getRedUsers(

            @Query("token") String token

    );

    @GET("get_prediction/")
    Call<HashMap<String, Object>> getpredict(

            @Query("token") String token

    );

@FormUrlEncoded
@POST("create_user/")
Call<RedUser> createUser(

        @Field("serializer_data") String hm,
        @Field("date_string") String date_string
);


@FormUrlEncoded
@POST("post_routine/")
Call<HashMap<String, Object>> routinenew(

        @Field("serializer_data") String hm,
        @Field("token") String token
    );


@GET("location_risk/")
Call<HashMap<String, Object>> gotonew(


            @Query("location") String location
    );


@FormUrlEncoded
@POST("get_auth_token/")
Call<HashMap<String, Object> > login(

        @Field("username") String email,
        @Field("password") String password
);



}
