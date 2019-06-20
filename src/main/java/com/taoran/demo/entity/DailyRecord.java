package com.taoran.demo.entity;

import com.alibaba.fastjson.JSONObject;
import com.taoran.demo.utils.ListUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DailyRecord {

    private List<ListUtils> dailyList;

    private String uuid;

    public DailyRecord(String jsonString){

        JSONObject jsonObject = JSONObject.parseObject(jsonString);

        this.uuid = jsonObject.getString("uuid");
        this.dailyList = jsonObject.getJSONArray("dailyList").toJavaList(ListUtils.class);

    }

}
