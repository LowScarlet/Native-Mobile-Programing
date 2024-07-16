package net.taufik;

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
                new net.taufik.models.konsumen.ModelFragment(),
                R.drawable.baseline_category_24,
                "Konsumen",
                "konsumen",
                "Ini adalah table Konsumen"
        ));
        itemList.add(new MainModel(
                new net.taufik.models.meja.ModelFragment(),
                R.drawable.baseline_category_24,
                "Meja",
                "meja",
                "Ini adalah table Meja"
        ));
        itemList.add(new MainModel(
                new net.taufik.models.menu.ModelFragment(),
                R.drawable.baseline_category_24,
                "Menu",
                "menu",
                "Ini adalah table Menu"
        ));
        itemList.add(new MainModel(
                new net.taufik.models.pesanan.ModelFragment(),
                R.drawable.baseline_category_24,
                "Pesanan",
                "pesanan",
                "Ini adalah table Pesanan"
        ));
        itemList.add(new MainModel(
                new net.taufik.models.reservasi.ModelFragment(),
                R.drawable.baseline_category_24,
                "Reservasi",
                "reservasi",
                "Ini adalah table Reservasi"
        ));
        itemList.add(new MainModel(
                new net.taufik.models.itemPesanan.ModelFragment(),
                R.drawable.baseline_category_24,
                "Item Pesanan",
                "itemPesanan",
                "Ini adalah table Item Pesanan"
        ));
        //

        TextView tableTitle = view.findViewById(R.id.tableTitle);
        tableTitle.setText(String.format("Table List (%d):", itemList.size()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new MainAdapter(itemList, requireActivity()));
        return view;
    }
}
