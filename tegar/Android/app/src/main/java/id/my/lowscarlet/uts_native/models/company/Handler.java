package id.my.lowscarlet.uts_native.models.company;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Handler {
    @POST("/{api}/")
    Call<Model> createData(@Path("api") String api, @Body Model model);
    @GET("/{api}/")
    Call<List<Model>> getAllData(@Path("api") String api);
    @PUT("/{api}/{id}")
    Call<Model> updateData(@Path("api") String api, @Path("id") Integer id, @Body Map<String, Object> data);
    @DELETE("/{api}/{id}")
    Call<Model> deleteData(@Path("api") String api, @Path("id") Integer id);
}
