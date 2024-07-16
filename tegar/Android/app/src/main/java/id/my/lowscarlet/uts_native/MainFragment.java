package id.my.lowscarlet.uts_native;

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
                new id.my.lowscarlet.uts_native.models.portfolio.ModelFragment(),
                R.drawable.baseline_book_24,
                "Portfolio",
                "portfolio",
                "Ini adalah table portfolio"
        ));
        itemList.add(new MainModel(
                new id.my.lowscarlet.uts_native.models.department.ModelFragment(),
                R.drawable.baseline_account_tree_24,
                "Department",
                "department",
                "Ini adalah table department"
        ));
        itemList.add(new MainModel(
                new id.my.lowscarlet.uts_native.models.company.ModelFragment(),
                R.drawable.baseline_work_24,
                "Company",
                "company",
                "Ini adalah table company"
        ));
        itemList.add(new MainModel(
                new id.my.lowscarlet.uts_native.models.institution.ModelFragment(),
                R.drawable.baseline_location_city_24,
                "Institution",
                "institution",
                "Ini adalah table institution"
        ));
        itemList.add(new MainModel(
                new id.my.lowscarlet.uts_native.models.portfolioDetail.ModelFragment(),
                R.drawable.baseline_details_24,
                "Portfolio Detail",
                "portfolioDetail",
                "Ini adalah table portfolio detail"
        ));
        itemList.add(new MainModel(
                new id.my.lowscarlet.uts_native.models.portfolioProject.ModelFragment(),
                R.drawable.baseline_task_24,
                "Portfolio Project",
                "portfolioProject",
                "Ini adalah table portfolio project"
        ));
        itemList.add(new MainModel(
                new id.my.lowscarlet.uts_native.models.portfolioWork.ModelFragment(),
                R.drawable.baseline_work_history_24,
                "Portfolio Work",
                "portfolioWork",
                "Ini adalah table portfolio work"
        ));
        itemList.add(new MainModel(
                new id.my.lowscarlet.uts_native.models.portfolioEducation.ModelFragment(),
                R.drawable.baseline_school_24,
                "Portfolio Education",
                "portfolioEducation",
                "Ini adalah table portfolio education"
        ));
        //

        TextView tableTitle = view.findViewById(R.id.tableTitle);
        tableTitle.setText(String.format("Table List (%d):", itemList.size()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new MainAdapter(itemList, requireActivity()));
        return view;
    }
}
