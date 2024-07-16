package net.raja;

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
                new net.raja.models.pelanggan.ModelFragment(),
                R.drawable.baseline_category_24,
                "Pelanggan",
                "pelanggan",
                "Ini adalah table Pelanggan"
        ));
        itemList.add(new MainModel(
                new net.raja.models.karyawan.ModelFragment(),
                R.drawable.baseline_category_24,
                "Karyawan",
                "karyawan",
                "Ini adalah table Karyawan"
        ));
        itemList.add(new MainModel(
                new net.raja.models.pemasok.ModelFragment(),
                R.drawable.baseline_category_24,
                "Pemasok",
                "pemasok",
                "Ini adalah table Pemasok"
        ));
        itemList.add(new MainModel(
                new net.raja.models.galon.ModelFragment(),
                R.drawable.baseline_category_24,
                "Galon",
                "galon",
                "Ini adalah table Galon"
        ));
        itemList.add(new MainModel(
                new net.raja.models.pemesanan.ModelFragment(),
                R.drawable.baseline_category_24,
                "Pemesanan",
                "pemesanan",
                "Ini adalah table Pemesanan"
        ));
        itemList.add(new MainModel(
                new net.raja.models.pengantaran.ModelFragment(),
                R.drawable.baseline_category_24,
                "Pengantaran",
                "pengantaran",
                "Ini adalah table Pengantaran"
        ));
        //

        TextView tableTitle = view.findViewById(R.id.tableTitle);
        tableTitle.setText(String.format("Table List (%d):", itemList.size()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new MainAdapter(itemList, requireActivity()));
        return view;
    }
}
