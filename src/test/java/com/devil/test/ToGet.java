package com.devil.test;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.devil.utils.BaseHttpClient;
import com.devil.utils.HttpRequestUtils;
import com.devil.utils.JSONUtils;

public class ToGet {
	public static void main(String[] args) throws Exception {
		String data = "";
		BaseHttpClient client = HttpRequestUtils.getTestInstance();
		String result = client.httpClientGet("http://localhost:8077/report/os", null, data);
		System.out.println(result);
		Map<String, Object> map = JSONUtils.json2map(result);
		Set<Entry<String, Object>> set = map.entrySet();
		for (Entry<String, Object> entry : set) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}
}
