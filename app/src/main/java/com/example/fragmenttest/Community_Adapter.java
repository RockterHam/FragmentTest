package com.example.fragmenttest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import java.util.Map;

public class Community_Adapter extends BaseAdapter {



    private List<Map<String , Object>> list;
    private LayoutInflater inflater;
    private Context context;

    public Community_Adapter(Context context, List<Map<String, Object>> list) {
        this.inflater = LayoutInflater.from(context);
        setList(list);
    }


    public void setList(List<Map<String , Object>> list){
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }//行数

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }//数据的对象

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = inflater.inflate(R.layout.community_item,null);

        ImageView userIcon = (ImageView) view.findViewById(R.id.community_usericon);
        ImageView userPicture = (ImageView) view.findViewById(R.id.community_userpicture);
        TextView userId = (TextView) view.findViewById(R.id.community_userid);
        TextView time = (TextView) view.findViewById(R.id.community_time);

        Map map = list.get(position);

        userIcon.setImageResource((Integer) map.get("userIcon"));
        userPicture.setImageResource((Integer) map.get("userPicture"));
        userId.setText((String) map.get("userId"));
        time.setText((String) map.get("time"));

        return view;
    }
}
