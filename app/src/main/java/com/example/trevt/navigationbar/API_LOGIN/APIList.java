package com.example.trevt.navigationbar.API_LOGIN;

import com.example.trevt.navigationbar.ModelWisata.WisataList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIList {
    String URL = "http://192.168.43.84:3000/myapi/";



    //@FormUrlEncoded
    //@POST("api_mebel/detail")
    //Call<com.example.trevt.navigationbar.API_LOGIN.APIList> detail_mebel(@Field("id_mebel") String id_mebel);

    @FormUrlEncoded
    @POST("wisatawan/register")
    Call<WisatawanListt> register(@Field("nama") String nama,
                               @Field("notelp") String notelp,
                               @Field("email") String email,
                               @Field("password") String password,
                                @Field("retypePassword")String retypePassword);

    @FormUrlEncoded
    @POST("wisatawan/login")
    Call<WisatawanListt>login (@Field("email") String email,
                                @Field("password")String password);


    @GET("seeallwisata/{key}/")
    Call<WisataList> getWisata (@Path("key")String key);

    @GET("seeallwisata/")
    Call<WisataList> getallWisata ();
}
