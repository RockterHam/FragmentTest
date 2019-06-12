package com.example.fragmenttest;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommunityFragment extends android.support.v4.app.Fragment {
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<Map<String, Object>> list;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.community_fragment, container, false);
        listView = (ListView) view.findViewById(R.id.lv);
        List<Map<String, Object>> list = getData();
        Community_Adapter adapter = new Community_Adapter(getActivity(), list);
        //通过setAdapter而把数据绑定到ListView中
        listView.setAdapter(adapter);
        return view;
    }

    public List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userIcon", R.drawable.ic_community_on);
        map.put("userPicture", R.drawable.e);
        map.put("userId", "这是一个标题");
        map.put("time", "这是一个详细信息");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("userIcon", R.drawable.ic_community_on);
        map.put("userPicture", R.drawable.e);
        map.put("userId", "这是二个标题");
        map.put("time", "这是二个详细信息");
        list.add(map);
        return list;
    }
}