package net.rahel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
                new net.rahel.models.kategori.ModelFragment(),
                R.drawable.baseline_category_24,
                "Kategori",
                "kategori",
                "Ini adalah table Kategori"
        ));
        itemList.add(new MainModel(
                new net.rahel.models.petugas.ModelFragment(),
                R.drawable.baseline_category_24,
                "Petugas",
                "petugas",
                "Ini adalah table Petugas"
        ));
        itemList.add(new MainModel(
                new net.rahel.models.metodePembayaran.ModelFragment(),
                R.drawable.baseline_category_24,
                "Metode Pembayaran",
                "metodePembayaran",
                "Ini adalah table Metode Pembayaran"
        ));
        itemList.add(new MainModel(
                new net.rahel.models.lokasi.ModelFragment(),
                R.drawable.baseline_category_24,
                "Lokasi",
                "lokasi",
                "Ini adalah table Lokasi"
        ));
        itemList.add(new MainModel(
                new net.rahel.models.stok.ModelFragment(),
                R.drawable.baseline_category_24,
                "Stok",
                "stok",
                "Ini adalah table Stok"
        ));
        itemList.add(new MainModel(
                new net.rahel.models.pencatatan.ModelFragment(),
                R.drawable.baseline_category_24,
                "Pencatatan",
                "pencatatan",
                "Ini adalah table Pencatatan"
        ));
        itemList.add(new MainModel(
                new net.rahel.models.pengembalian.ModelFragment(),
                R.drawable.baseline_category_24,
                "Pengembalian",
                "pengembalian",
                "Ini adalah table Pengembalian"
        ));
        //

        TextView tableTitle = view.findViewById(R.id.tableTitle);
        tableTitle.setText(String.format("Table List (%d):", itemList.size()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new MainAdapter(itemList, requireActivity()));
        return view;
    }
}
