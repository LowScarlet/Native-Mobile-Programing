package id.my.lowscarlet.uts_native;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private List<MainModel> items;
    private FragmentActivity activity;

    public MainAdapter(List<MainModel> items, FragmentActivity activity) {
        this.items = items;
        this.activity = activity;
    }

    public static class MainViewHolder extends RecyclerView.ViewHolder {
        public int icon;
        public TextView title;
        public TextView subTitle;

        public MainViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.tableTitle);
            subTitle = view.findViewById(R.id.tableSubTitle);
        }
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.table_item, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        MainModel mainModel = items.get(position);
        int AdapterIcon = mainModel.icon;
        ImageView itemIcon = holder.itemView.findViewById(R.id.itemIcon);
        itemIcon.setImageResource(AdapterIcon);
        holder.title.setText(mainModel.title);
        holder.subTitle.setText(mainModel.api);
        holder.itemView.setOnClickListener(v -> {
            Bundle args = new Bundle();
            args.putInt("icon", mainModel.icon);
            args.putString("title", mainModel.title);
            args.putString("api", mainModel.api);
            args.putString("description", mainModel.description);

            FragmentManager fragmentManager = activity.getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.setCustomAnimations(
                    R.anim.slide_in_right,
                    R.anim.slide_out_left,
                    R.anim.slide_in_left,
                    R.anim.slide_out_right
            );

            mainModel.fragment.setArguments(args);

            fragmentTransaction.replace(R.id.fragmentContainer, mainModel.fragment);
            fragmentTransaction.addToBackStack("MAIN_FRAGMENT");
            fragmentTransaction.commit();
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
