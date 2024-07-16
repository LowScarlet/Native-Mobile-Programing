package net.hafis;

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
                new net.hafis.models.pelapor.ModelFragment(),
                R.drawable.baseline_category_24,
                "Pelapor",
                "pelapor",
                "Ini adalah table Pelapor"
        ));
        itemList.add(new MainModel(
                new net.hafis.models.kategoriBarang.ModelFragment(),
                R.drawable.baseline_category_24,
                "Kategori Barang",
                "kategoriBarang",
                "Ini adalah table Kategori Barang"
        ));
        itemList.add(new MainModel(
                new net.hafis.models.lokasi.ModelFragment(),
                R.drawable.baseline_category_24,
                "Lokasi",
                "lokasi",
                "Ini adalah table Lokasi"
        ));
        itemList.add(new MainModel(
                new net.hafis.models.barang.ModelFragment(),
                R.drawable.baseline_category_24,
                "Barang",
                "barang",
                "Ini adalah table Barang"
        ));
        itemList.add(new MainModel(
                new net.hafis.models.laporanKehilangan.ModelFragment(),
                R.drawable.baseline_category_24,
                "Laporan Kehilangan",
                "laporanKehilangan",
                "Ini adalah table Laporan Kehilangan"
        ));
        itemList.add(new MainModel(
                new net.hafis.models.laporanPenemuan.ModelFragment(),
                R.drawable.baseline_category_24,
                "Laporan Penemuan",
                "laporanPenemuan",
                "Ini adalah table Laporan Penemuan"
        ));
        //

        TextView tableTitle = view.findViewById(R.id.tableTitle);
        tableTitle.setText(String.format("Table List (%d):", itemList.size()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new MainAdapter(itemList, requireActivity()));
        return view;
    }
}
