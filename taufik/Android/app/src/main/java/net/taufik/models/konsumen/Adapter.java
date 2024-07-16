package net.taufik.models.konsumen;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import net.taufik.R;
import net.taufik.Utils;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private Fragment fragment;
    private List<Model> items;
    private Context context;
    private Bundle args;

    public Adapter(List<Model> items, Fragment fragment, Bundle args) {
        this.items = items;
        this.fragment = fragment;
        this.context = fragment.getContext();
        this.args = args;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout itemCountainer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemCountainer = itemView.findViewById(R.id.itemContainer);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.crud_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        int AdapterIcon = args.getInt("icon");
        ImageView itemIcon = view.findViewById(R.id.itemIcon);
        itemIcon.setImageResource(AdapterIcon);
        viewHolder.itemCountainer.addView(Utils.createTextView(context));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Model data = items.get(position);

        StringBuilder combinedString = new StringBuilder();

        // TODO EDIT
        String[] arrayOfStrings = {
                String.format("Id: %s", data.id),
                String.format("Nama: %s", data.nama),
                String.format("Alamat: %s", data.alamat),
                String.format("Email: %s", data.email),
                String.format("Nomor Hp: %s", data.nomorHp),
        };
        //

        for (String str : arrayOfStrings) combinedString.append(str).append("\n");
        if (combinedString.length() > 0) combinedString.setLength(combinedString.length() - 1);
        String finalString = combinedString.toString();
        ((TextView) holder.itemCountainer.getChildAt(0)).setText(finalString);
        holder.itemView.setOnClickListener(v -> ((ModelFragment) fragment).showUpdateModal(data.id, data));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Model model) {
        items.add(model);
        notifyItemInserted(items.size() - 1);
    }

    public void updateItem(Model updatedItem) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).id.equals(updatedItem.id)) {
                items.set(i, updatedItem);
                notifyItemChanged(i);
                break;
            }
        }
    }

    public void deleteItem(Model updatedItem) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).id.equals(updatedItem.id)) {
                items.remove(i);
                notifyItemRemoved(i);
                break;
            }
        }
    }
}
