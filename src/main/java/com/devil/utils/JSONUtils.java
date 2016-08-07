package com.devil.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;

import com.devil.utils.ConParams.TimeType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.google.gson.JsonParser;

public class JSONUtils {

	private final static ObjectMapper objectMapper = new ObjectMapper();
	static {
		// 忽略属性
		objectMapper
				.setDateFormat(new SimpleDateFormat(TimeType.FORMAT_DATE_TIME));
		objectMapper.configure(
				DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		// 该特性决定是否接受强制非数组（JSON）值到Java集合类型。如果允许，集合反序列化将尝试处理非数组值。
		objectMapper.configure(
				DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		// 该特性可以允许JSON空字符串转换为POJO对象为null。如果禁用，则标准POJO只会从JSON null或者JSON对象转换过来；
		// 如果允许，则空JSON字符串可以等价于JSON null
		objectMapper
				.configure(
						DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT,
						true);

	}

	private JSONUtils() {

	}

	public static ObjectMapper getInstance() {
		return objectMapper;
	}

	/**
	 * javaBean,list,array convert to json string
	 * 
	 * @throws JsonProcessingException
	 */
	public static String obj2json(Object obj) throws JsonProcessingException {
		return objectMapper.writeValueAsString(obj);
	}

	/**
	 * json string convert to javaBean
	 */
	public static <T> T json2pojo(String jsonStr, Class<T> clazz)
			throws Exception {
		return objectMapper.readValue(jsonStr, clazz);
	}

	/**
	 * json string convert to map
	 */
	@SuppressWarnings("unchecked")
	public static <T> Map<String, Object> json2map(String jsonStr)
			throws Exception {
		return objectMapper.readValue(jsonStr, Map.class);
	}

	/**
	 * json string convert to map with javaBean
	 */
	public static <T> Map<String, T> json2map(String jsonStr, Class<T> clazz)
			throws Exception {
		Map<String, Map<String, Object>> map = objectMapper.readValue(jsonStr,
				new TypeReference<Map<String, T>>() {
				});
		Map<String, T> result = new HashMap<String, T>();
		for (Entry<String, Map<String, Object>> entry : map.entrySet()) {
			result.put(entry.getKey(), map2pojo(entry.getValue(), clazz));
		}
		return result;
	}

	public static TreeMap<String, String> json2mapOne(String jsonStr)
			throws Exception {
		@SuppressWarnings("unchecked")
		Map<String, Object> map = objectMapper.readValue(jsonStr, Map.class);
		TreeMap<String, String> result = new TreeMap<String, String>();
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			result.put(entry.getKey(), entry.getValue().toString());
		}
		return result;
	}

	/**
	 * json array string convert to list with javaBean
	 */
	public static <T> List<T> json2list(String jsonArrayStr, Class<T> clazz)
			throws Exception {
		List<Map<String, Object>> list = objectMapper.readValue(jsonArrayStr,
				new TypeReference<List<T>>() {
				});
		List<T> result = new ArrayList<T>();
		for (Map<String, Object> map : list) {
			result.add(map2pojo(map, clazz));
		}
		return result;
	}

	/**
	 * map convert to javaBean
	 */
	public static <T> T map2pojo(Map<?, ?> map, Class<T> clazz) {
		return objectMapper.convertValue(map, clazz);
	}

	/**
	 * 判断字符串是否是JSON字符串
	 * 
	 * @param str
	 * @return
	 * @created
	 * @author
	 */
	// public static boolean isJsonString(String str) {
	// return isJsonObjectString(str) || isJsonArrayString(str);
	// }

	/**
	 * 判断字符串是否是JSON对象字符串
	 * 
	 * @param str
	 * @return
	 * @created
	 * @author
	 */
	// public static boolean isJsonObjectString(String str) {
	// return str != null && str.matches("^\\{.*\\}$");
	// }

	/**
	 * 判断字符串是否是JSON数组字符串
	 * 
	 * @param st
	 * @return
	 * @created
	 * @author
	 */
	// public static boolean isJsonArrayString(String str) {
	// return str != null && str.matches("^\\[.*\\]$");
	// }

	public static <T> T jsonToPojoWithDate(String jsonStr, Class<T> clazz,
			String format) throws Exception {
		if (StringUtils.isBlank(format))
			format = TimeType.FORMAT_DATE_TIME;
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat(format));
		return mapper.readValue(jsonStr, clazz);

	}

	public static ObjectMapper setMinObjectMapper(ObjectMapper mapper,
			Class<?> target, Class<?> min) {
		mapper.addMixIn(target, min);
		return mapper;

	}

	public static ObjectMapper getObjectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
				false);
		// 该特性决定是否接受强制非数组（JSON）值到Java集合类型。如果允许，集合反序列化将尝试处理非数组值。
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY,
				true);
		// 该特性可以允许JSON空字符串转换为POJO对象为null。如果禁用，则标准POJO只会从JSON null或者JSON对象转换过来；
		// 如果允许，则空JSON字符串可以等价于JSON null
		mapper.configure(
				DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
		mapper.setDateFormat(new SimpleDateFormat(TimeType.FORMAT_DATE_TIME));
		return mapper;

	}

	public static SimpleFilterProvider WithFilter(SimpleFilterProvider filter,
			ObjectMapper mapper, String type, Class<?> target, Class<?> min,
			String filterName, String... properties) {
		if (filter == null) {
			return new SimpleFilterProvider().setFailOnUnknownId(false);
		}

		if (type.equalsIgnoreCase("include"))
			// 获取想要属性
			filter.addFilter(filterName,
					SimpleBeanPropertyFilter.filterOutAllExcept(properties));

		// 排除属性
		else if (type.equalsIgnoreCase("exclude"))
			filter.addFilter(filterName,
					SimpleBeanPropertyFilter.serializeAllExcept(properties));
		else {
		}
		if (target != null)
			setMinObjectMapper(mapper, target, min);
		return filter;
	}

	/**
	 * 从json树形中获取某个节点 内容
	 * 
	 * @param data
	 * @param nodename
	 * @return
	 * @throws Exception
	 */
	public static String jsonToTree(String data, String nodename)
			throws Exception {
		JsonNode rootNode = objectMapper.readTree(data);
		return rootNode.path(nodename).toString();
	}

	/**
	 * 验证是否是json
	 * 
	 * @param data
	 * @return
	 */
	public static boolean valideJson(String data) {
		return valideJsonObject(data) || valideJsonArray(data);
	}

	public static boolean valideJsonObject(String data) {
		try {
			new JsonParser().parse(data).getAsJsonObject();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static boolean valideJsonArray(String data) {
		try {
			new JsonParser().parse(data).getAsJsonArray();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}