package net.hafis;

import android.content.Context;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.SwitchCompat;

import com.google.android.material.textview.MaterialTextView;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Utils {
    public static class Field {
        public String name;
        public Object value;

        public Field(String name, Object value) {
            this.name = name;
            this.value = value;
        }
    }

    public static EditText createEditText(Context context, String hint) {
        EditText et = new EditText(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        et.setLayoutParams(params);
        et.setHint(hint);
        return et;
    }
    public static SwitchCompat createSwitch(Context context, String hint) {
        SwitchCompat sc = new SwitchCompat(context);
        sc.setText(hint);
        return sc;
    }
    public static TextView createTextView(Context context) {
        TextView tv = new TextView(context);
        return tv;
    }

    public static List<String> errorText(String jsonResponse) {
        List<String> errorList = new ArrayList<>();
        try {
            // Parse JSON string to JsonObject
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(jsonResponse, JsonObject.class);

            JsonObject validationErrors = jsonObject.getAsJsonObject("validationErrors");

            for (Map.Entry<String, JsonElement> entry : validationErrors.entrySet()) {
                String fieldName = entry.getKey();
                String errorMessage = entry.getValue().getAsString();
                errorList.add(toTitleCase(fieldName) + " " + errorMessage);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return errorList;
    }

    public static LinearLayout createLinearLayoutWithIcon(Context context, int iconResId, String text) {
        // Create a LinearLayout to hold the ImageView and TextView
        LinearLayout linearLayout = new LinearLayout(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        linearLayout.setLayoutParams(params);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setPadding(dpToPx(context, 6), dpToPx(context, 6), dpToPx(context, 6), dpToPx(context, 6));

        // Create the ImageView
        ImageView imageView = new ImageView(context);
        LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(
                dpToPx(context, 22), dpToPx(context, 22));
        imageView.setLayoutParams(imageParams);
        imageView.setImageResource(iconResId);
        imageView.setPadding(dpToPx(context, 2), dpToPx(context, 2), dpToPx(context, 2), dpToPx(context, 2));
        imageParams.setMarginEnd(dpToPx(context, 8));
        imageView.setLayoutParams(imageParams);

        // Create the TextView
        MaterialTextView textView = new MaterialTextView(context);
        LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        textView.setLayoutParams(textParams);
        textView.setText(text);
        textView.setTextSize(14);

        // Add ImageView and TextView to the LinearLayout
        linearLayout.addView(imageView);
        linearLayout.addView(textView);

        return linearLayout;
    }

    // Helper method to convert dp to pixels
    private static int dpToPx(Context context, int dp) {
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dp * density);
    }

    public static String toTitleCase(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        StringBuilder titleCase = new StringBuilder();
        boolean nextTitleCase = true;

        for (char c : input.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                nextTitleCase = true;
            } else if (nextTitleCase) {
                c = Character.toTitleCase(c);
                nextTitleCase = false;
            } else {
                c = Character.toLowerCase(c);
            }
            titleCase.append(c);
        }

        return titleCase.toString();
    }
    public static int tryParseInt(String text, int defaultValue) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
    public static float tryParseFloat(String text, float defaultValue) {
        try {
            return Float.parseFloat(text);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}
