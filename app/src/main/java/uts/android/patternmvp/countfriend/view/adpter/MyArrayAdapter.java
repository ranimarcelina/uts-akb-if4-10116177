package uts.android.patternmvp.countfriend.view.adpter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import uts.android.patternmvp.countfriend.R;
import uts.android.patternmvp.countfriend.bean.UserBean;

/*
Tanggal Pengerjaan : 18 Mei 2019
NIM : 10116177
Nama : Rani Marcelina
Kelas : AKB-4
*/

public class MyArrayAdapter extends ArrayAdapter {
    private LayoutInflater inflater;
    private Toast toast;

    public MyArrayAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        inflater = LayoutInflater.from(context);
        toast.makeText(context, "", Toast.LENGTH_SHORT);
    }

    @Override
    public UserBean getItem(int position) {
        UserBean info = (UserBean) super.getItem(position);
        return info;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        UserBean user = getItem(position);
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.lv_item, null);
            holder.nimTv = (TextView) convertView.findViewById(R.id.tv_nim);
            holder.namaTv = (TextView) convertView.findViewById(R.id.tv_name);
            holder.kelasTv = (TextView) convertView.findViewById(R.id.tv_kelas);
            holder.teleponTv = (TextView) convertView.findViewById(R.id.tv_phone);
            holder.emailTv = (TextView) convertView.findViewById(R.id.tv_email);
            holder.sosmedTv = (TextView) convertView.findViewById(R.id.tv_sosmed);
            convertView.setTag(holder);
            Log.e("TAG", "convertView null");
        } else {
            holder = (ViewHolder) convertView.getTag();
            Log.e("TAG", "convertView not null");
        }

        holder.nimTv.setText(user.getNim());
        holder.namaTv.setText(user.getNama());
        holder.kelasTv.setText(user.getKelas());
        holder.teleponTv.setText(user.getTelepon());
        holder.emailTv.setText(user.getEmail());
        holder.sosmedTv.setText(user.getSosmed());
        return convertView;
    }

    static class ViewHolder {
        TextView nimTv;
        TextView namaTv;
        TextView kelasTv;
        TextView teleponTv;
        TextView emailTv;
        TextView sosmedTv;
    }
}

