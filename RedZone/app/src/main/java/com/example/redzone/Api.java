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


    String BASE_URL = "https://47456dd1628f.ngrok.io/";

    /**
     * The return type is important here
     * The class structure that you've defined in Call<T>
     * should exactly match with your json response
     * If you are not using another api, and using the same as mine
     * then no need to worry, but if you have your own API, make sure
     * you change the return type appropriately
     **/
    @GET("user_list")
    Call<List<RedUser>> getRedUsers();

@FormUrlEncoded
@POST("create_user/")
Call<RedUser> createUser(
        //@Field("serializer_data") HashMap<String, Object> hm,
        @Field("serializer_data") String hm,
              //  String restaurantJson = "{ 'name':'Future Studio Steak House', 'owner':{ 'name':'Christian', 'address':{ 'city':'Magdeburg', 'country':'Germany', 'houseNumber':'42', 'street':'Main Street'}},'cook':{ 'age':18, 'name': 'Marcus', 'salary': 1500 }, 'waiter':{ 'age':18, 'name': 'Norman', 'salary': 1000}}";

       // @Field("first_name") String first_name,
        //@Field("last_name") String last_name,
       // @Field("gender") int gender,
      //  @Field("email") String email,
     //   @Field("username") String username,
     //   @Field("profession") String profession,
      //  @Field("password") String password,
        @Field("date_string") String date_string
);

    @FormUrlEncoded
@POST("get_auth_token/")
Call<HashMap<String, Object> > login(

        @Field("username") String email,
        @Field("password") String password
);



}
