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

public interface Api {


    String BASE_URL = "https://7531dc2fe167.ngrok.io";

    @GET("user_list")
    Call<List<RedUser>> getRedUsers();

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

@FormUrlEncoded
@POST("/")
Call<HashMap<String, Object>> gotonew(


            @Field("location") String location
    );


@FormUrlEncoded
@POST("get_auth_token/")
Call<HashMap<String, Object> > login(

        @Field("username") String email,
        @Field("password") String password
);



}
