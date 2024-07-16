package id.my.lowscarlet.uts_native.models.portfolioProject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import id.my.lowscarlet.uts_native.Config;
import id.my.lowscarlet.uts_native.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SpinnerAdapter extends ArrayAdapter<Model> {
    private Context context;
    private List<Model> items;

    public SpinnerAdapter(@NonNull Context context, List<Model> items) {
        super(context, R.layout.spinner_item, items);
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.spinner_item, parent, false);
        }
        TextView textView = (TextView) convertView.findViewById(R.id.displayName);
        // TODO EDIT
        textView.setText(items.get(position).title+" ("+items.get(position).id+")");
        //
        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.spinner_item, parent, false);
        }
        TextView textView = convertView.findViewById(R.id.displayName);
        // TODO EDIT
        textView.setText(" - "+items.get(position).title+" ("+items.get(position).id+")");
        //
        return convertView;
    }

    static public Model getModelItem(Object value) {
        return (Model) value;
    }

    public static Handler getHandler() {
        return Config.retrofit.create(Handler.class);
    }

    public static Integer getSelectedId(Object selected) {
        Model model = (Model) selected;
        return model.id;
    }

    static public void createCallBack(Spinner spinner, Context context, @Nullable Integer defaultId) {
        // TODO EDIT
        Call<List<Model>> call = getHandler().getAllData("portfolioProject");
        //
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                if (response.isSuccessful()) {
                    List<Model> items = response.body();
                    SpinnerAdapter adapter = new SpinnerAdapter(context, items);
                    spinner.setAdapter(adapter);

                    if (defaultId != null) {
                        for (int i = 0; i < items.size(); i++) {
                            if (items.get(i).id == defaultId) {
                                spinner.setSelection(i);
                                break;
                            }
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {}
        });
    }
}
