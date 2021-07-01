package com.dm.thanks.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.dm.thanks.R;

public class Solicitation extends ArrayAdapter<com.dm.thanks.Model.Solicitation> {
    public Solicitation(Context context) {
        super(context, R.layout.activity_solicitation_cardview);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Solicitation.ViewHolder holder;

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.activity_solicitation_cardview, parent, false);
            holder = new ViewHolder(convertView);

            convertView.setTag(holder);
        }else{
            holder = (Solicitation.ViewHolder) convertView.getTag();
        }

        com.dm.thanks.Model.Solicitation solicitation = getItem(position);
        holder.title.setText((String) solicitation.getTitle());
        holder.sub_title.setText((String) solicitation.getSub_title());
        holder.objective.setText((String) solicitation.getObjective());
        holder.reached.setText((String) solicitation.getReached());

        return convertView;
    }

    public static class ViewHolder{
        TextView title;
        TextView sub_title;
        TextView objective;
        TextView reached;

        public ViewHolder(View view){
            title = (TextView) view.findViewById(R.id.title);
            sub_title = (TextView) view.findViewById(R.id.sub_title);
            objective = (TextView) view.findViewById(R.id.objective);
            reached = (TextView) view.findViewById(R.id.reached);
        }
    }
}
