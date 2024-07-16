package com.ardy.models.penulis;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ardy.Config;
import com.ardy.R;
import com.ardy.Utils;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ModelFragment extends Fragment {
    private Retrofit retrofit = Config.retrofit;
    private RecyclerView recyclerView;
    private Adapter adapter;
    private Handler handler;
    private Context context;
    private Bundle args;
    private AppCompatImageView btnBack;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_crud, container, false);
        context = getContext();
        args = getArguments();

        btnBack = view.findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> getActivity().onBackPressed());

        TextView fragmentTitle = view.findViewById(R.id.toolBarTitle);
        fragmentTitle.setText(args.getString("title"));

        if (args != null) {
            TextView aboutTableActivity = view.findViewById(R.id.aboutTable);
            aboutTableActivity.setText(args.getString("description"));
        }

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        handler = retrofit.create(Handler.class);

        getAll();

        FloatingActionButton createButton = view.findViewById(R.id.createButton);
        createButton.setOnClickListener(v -> showCreateModal());

        return view;
    }

    private void getAll() {
        Call<List<Model>> call = handler.getAllData(args.getString("api"));

        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                if (response.isSuccessful()) {
                    List<Model> datas = response.body();
                    adapter = new Adapter(datas, ModelFragment.this, args);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                Toast.makeText(context, "Error Failure: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void showCreateModal() {
        LayoutInflater inflater = LayoutInflater.from(context);
        MaterialAlertDialogBuilder dialogBuilder = new MaterialAlertDialogBuilder(context);
        View dialogView = inflater.inflate(R.layout.crud_create, null);
        dialogBuilder.setView(dialogView);
        AlertDialog dialog = dialogBuilder.create();

        LinearLayout inputContainer = dialogView.findViewById(R.id.createContainer);

        // TODO EDIT
        EditText a = Utils.createEditText(context, "kode");
        inputContainer.addView(a);
        EditText b = Utils.createEditText(context, "nama");
        inputContainer.addView(b);
        EditText c = Utils.createEditText(context, "tanggalLahir");
        inputContainer.addView(c);
        EditText d = Utils.createEditText(context, "biografi");
        inputContainer.addView(d);
        EditText e = Utils.createEditText(context, "kewarganegaraan");
        inputContainer.addView(e);
        EditText f = Utils.createEditText(context, "penghargaan");
        inputContainer.addView(f);
        //

        dialogView.findViewById(R.id.cancelButton).setOnClickListener(v -> dialog.dismiss());
        dialogView.findViewById(R.id.createButton).setOnClickListener(v -> {
            Model createdModel = new Model(
                    a.getText().toString(),
                    b.getText().toString(),
                    c.getText().toString(),
                    d.getText().toString(),
                    e.getText().toString(),
                    f.getText().toString()
            );
            create(createdModel, dialog);
        });

        dialog.show();
    }

    public void showUpdateModal(Integer id, Model model) {
        LayoutInflater inflater = LayoutInflater.from(context);
        MaterialAlertDialogBuilder dialogBuilder = new MaterialAlertDialogBuilder(context);
        View dialogView = inflater.inflate(R.layout.crud_update, null);
        dialogBuilder.setView(dialogView);
        AlertDialog dialog = dialogBuilder.create();
        Button updateButton = dialogView.findViewById(R.id.updateButton);
        Button deleteButton = dialogView.findViewById(R.id.deleteButton);
        LinearLayout inputContainer = dialogView.findViewById(R.id.updateContainer);

        // TODO EDIT
        EditText kode = Utils.createEditText(context, "kode");
        kode.setText(model.kode);
        inputContainer.addView(kode);

        EditText nama = Utils.createEditText(context, "nama");
        nama.setText(model.nama);
        inputContainer.addView(nama);

        EditText tanggalLahir = Utils.createEditText(context, "tanggalLahir");
        tanggalLahir.setText(model.tanggalLahir);
        inputContainer.addView(tanggalLahir);

        EditText biografi = Utils.createEditText(context, "biografi");
        biografi.setText(model.biografi);
        inputContainer.addView(biografi);

        EditText kewarganegaraan = Utils.createEditText(context, "kewarganegaraan");
        kewarganegaraan.setText(model.kewarganegaraan);
        inputContainer.addView(kewarganegaraan);

        EditText penghargaan = Utils.createEditText(context, "penghargaan");
        penghargaan.setText(model.penghargaan);
        inputContainer.addView(penghargaan);

        updateButton.setOnClickListener(v -> {
            Map<String, Object> updatedModel = new HashMap<>();

            if (!Objects.equals(model.kode, kode.getText().toString())) {
                updatedModel.put("kode", kode.getText().toString());
            }

            if (!Objects.equals(model.nama, nama.getText().toString())) {
                updatedModel.put("nama", nama.getText().toString());
            }

            if (!Objects.equals(model.tanggalLahir, tanggalLahir.getText().toString())) {
                updatedModel.put("tanggalLahir", tanggalLahir.getText().toString());
            }

            if (!Objects.equals(model.biografi, biografi.getText().toString())) {
                updatedModel.put("biografi", biografi.getText().toString());
            }

            if (!Objects.equals(model.kewarganegaraan, kewarganegaraan.getText().toString())) {
                updatedModel.put("kewarganegaraan", kewarganegaraan.getText().toString());
            }

            if (!Objects.equals(model.penghargaan, penghargaan.getText().toString())) {
                updatedModel.put("penghargaan", penghargaan.getText().toString());
            }

            update(id, dialog, updatedModel);
        });
        //

        deleteButton.setOnClickListener(v -> delete(id, dialog));
        dialog.show();
    }

    public void create(Model model, AlertDialog dialog) {
        Call<Model> call = handler.createData(args.getString("api"), model);

        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                if (response.isSuccessful()) {
                    Model createdData = response.body();
                    adapter.addItem(createdData);
                    dialog.dismiss();
                    Toast.makeText(context, "Data created successfully", Toast.LENGTH_SHORT).show();
                } else {
                    if (response.code() == 400) {
                        Gson gson = new Gson();
                        String responseBodyJson = null;
                        LinearLayout errorLog = dialog.findViewById(R.id.createErrorLog);
                        errorLog.removeAllViews();
                        errorLog.setVisibility(View.GONE);
                        try {
                            responseBodyJson = response.errorBody().string();
                            errorLog.setVisibility(View.VISIBLE);

                            List<String> lists = Utils.errorText(responseBodyJson);
                            for (int i = 0; i < lists.size(); i++) {
                                LinearLayout x = Utils.createLinearLayoutWithIcon(context, R.drawable.baseline_info_24, lists.get(i));
                                errorLog.addView(x);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        Toast.makeText(context, "Failed to create Data", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "Failed to create Data. Error code: " + response.code(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Toast.makeText(context, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void update(Integer id, AlertDialog dialog, Map<String, Object> updatedModel) {
        Call<Model> call = handler.updateData(args.getString("api"), id, updatedModel);

        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                if (response.isSuccessful()) {
                    Model updatedData = response.body();
                    adapter.updateItem(updatedData);
                    dialog.dismiss();
                    Toast.makeText(context, "Data updated successfully", Toast.LENGTH_SHORT).show();
                } else {
                    if (response.code() == 400) {
                        Gson gson = new Gson();
                        String responseBodyJson = null;
                        LinearLayout errorLog = dialog.findViewById(R.id.updateErrorLog);
                        errorLog.removeAllViews();
                        errorLog.setVisibility(View.GONE);
                        try {
                            responseBodyJson = response.errorBody().string();
                            errorLog.setVisibility(View.VISIBLE);

                            List<String> lists = Utils.errorText(responseBodyJson);
                            for (int i = 0; i < lists.size(); i++) {
                                LinearLayout x = Utils.createLinearLayoutWithIcon(context, R.drawable.baseline_info_24, lists.get(i));
                                errorLog.addView(x);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        Toast.makeText(context, "Failed to create Data", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "Failed to create Data. Error code: " + response.code(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Toast.makeText(context, "Network error, please try again", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void delete(Integer id, AlertDialog dialog) {
        Call<Model> call = handler.deleteData(args.getString("api"), id);

        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                if (response.isSuccessful()) {
                    Model updatedData = response.body();
                    adapter.deleteItem(updatedData);
                    dialog.dismiss();
                    Toast.makeText(context, "Data deleted successfully", Toast.LENGTH_SHORT).show();
                } else {
                    if (response.code() == 400) {
                        Gson gson = new Gson();
                        String responseBodyJson = null;
                        LinearLayout errorLog = dialog.findViewById(R.id.updateErrorLog);
                        errorLog.removeAllViews();
                        errorLog.setVisibility(View.GONE);
                        try {
                            responseBodyJson = response.errorBody().string();
                            errorLog.setVisibility(View.VISIBLE);

                            List<String> lists = Utils.errorText(responseBodyJson);
                            for (int i = 0; i < lists.size(); i++) {
                                LinearLayout x = Utils.createLinearLayoutWithIcon(context, R.drawable.baseline_info_24, lists.get(i));
                                errorLog.addView(x);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        Toast.makeText(context, "Failed to delete Data", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "Failed to delete Data. Error code: " + response.code(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Toast.makeText(context, "Network error, please try again", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
