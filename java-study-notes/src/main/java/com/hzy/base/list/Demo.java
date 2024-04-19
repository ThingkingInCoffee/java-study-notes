package com.hzy.base.list;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo {

    public static void main(String[] args) {
        String jsonFilePath = "C:\\Users\\hzyao\\Desktop\\response.json";
        try {
            // 读取文件所有字节到内存中
            byte[] jsonData = Files.readAllBytes(Paths.get(jsonFilePath));

            // 将字节转换为字符串
            String jsonString = new String(jsonData, StandardCharsets.UTF_8);

            System.out.println("JSON content as a string: " + jsonString);

            JSONObject object = JSON.parseObject(jsonString);
            jsonString = object.getString("data");
            List<Test> tests = JSONArray.parseArray(jsonString, Test.class);
            String pidsString = tests.stream().map(e -> String.valueOf(e.getPid())).collect(Collectors.joining(","));


            // 获取不开启总站 pid(需要过滤 pid)
            Map<Long, List<Test>> resultMap = tests.stream()
                    .collect(Collectors.groupingBy(e -> e.getPid()));
            tests = tests.stream().filter(e -> !(ObjectUtil.equal(e.getPart(), 0) &&
                    (e.getEnabled_adjust_device() == null || ObjectUtil.equal(e.getEnabled_adjust_device(), false))
                    && resultMap.get(e.getPid()).size() > 2)
            ).collect(Collectors.toList());
            // 如果需要进一步解析为JSON对象，请根据你使用的JSON库添加相应代码
            // 例如，使用org.json.JSONObject:
            // JSONObject jsonObject = new JSONObject(jsonString);

            // 或者，如果你使用的是Jackson库：
            // ObjectMapper mapper = new ObjectMapper();
            // JsonNode jsonNode = mapper.readTree(jsonString);

            // 使用Gson库：
            // Gson gson = new Gson();
            // YourClass obj = gson.fromJson(jsonString, YourClass.class);
            System.out.println(tests.size());
            if (tests == null || tests.size() < 1) {
                return;
            }
            List<Long> allPid = tests.stream().map(Test::getPid).distinct().collect(Collectors.toList());
            // 参与调控过滤
            List<Long> controlPidList = tests.stream().filter(e -> true/*e.getControl_mode() != null*/ &&
                    (e.getExist_adjust_device() != null && !"0".equals(String.valueOf(e.getExist_adjust_device()))) && (e.getEnabled_adjust_device() != null &&
                    e.getEnabled_adjust_device())).map(Test::getPid).distinct().collect(Collectors.toList());
            List<Long> noControlPidList = null;
            if (controlPidList == null || controlPidList.size() < 1) {
                noControlPidList = allPid;
            } else {
                if (controlPidList.size() != allPid.size()) {
                    noControlPidList = allPid.stream().filter(x -> !controlPidList.contains(x)).collect(Collectors.toList());
                }
            }
            System.out.println(controlPidList.size());
            System.out.println(pidsString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
