package com.ardy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ardy.models.penulis.ModelFragment;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        List<MainModel> itemList = new ArrayList<>();

        // TODO EDIT
        itemList.add(new MainModel(
                new com.ardy.models.penulis.ModelFragment(),
                R.drawable.baseline_edit_24,
                "Penulis",
                "penulis",
                "Ini adalah table Penulis"
        ));
        itemList.add(new MainModel(
                new com.ardy.models.kategori.ModelFragment(),
                R.drawable.baseline_category_24,
                "Kategori",
                "kategori",
                "Ini adalah table Kategori"
        ));
        itemList.add(new MainModel(
                new com.ardy.models.penerbit.ModelFragment(),
                R.drawable.baseline_people_24,
                "Penerbit",
                "penerbit",
                "Ini adalah table Penerbit"
        ));
        itemList.add(new MainModel(
                new com.ardy.models.buku.ModelFragment(),
                R.drawable.baseline_library_books_24,
                "Buku",
                "buku",
                "Ini adalah table Buku"
        ));
        itemList.add(new MainModel(
                new com.ardy.models.peminjaman.ModelFragment(),
                R.drawable.baseline_download_done_24,
                "Peminjaman",
                "peminjaman",
                "Ini adalah table Peminjaman"
        ));
        //

        TextView tableTitle = view.findViewById(R.id.tableTitle);
        tableTitle.setText(String.format("Table List (%d):", itemList.size()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new MainAdapter(itemList, requireActivity()));
        return view;
    }
}
