package es.jdamiancabello.customspinner.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import es.jdamiancabello.customspinner.R;
import es.jdamiancabello.customspinner.model.Social;

public class SocialAdapter extends ArrayAdapter<Social> {
    public SocialAdapter(@NonNull Context context, List<Social> list) {
        super(context, R.layout.item_social, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        ViewHolder viewHolder;

        if(v == null){
            viewHolder = new ViewHolder();
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_social,parent,false);
            viewHolder.icon = v.findViewById(R.id.icon);
            viewHolder.tvName = v.findViewById(R.id.tvName);
            v.setTag(viewHolder);
        }
        else
            viewHolder = (ViewHolder)v.getTag();

        //Finalmente cuando se inicia o reutiliza se deben añadir los datos segun la posición
        viewHolder.icon.setImageResource(getItem(position).getIcon());
        viewHolder.tvName.setText(getItem(position).getName());
        return v;
    }

    private static class ViewHolder{
        private ImageView icon;
        private TextView tvName;
    }
}
