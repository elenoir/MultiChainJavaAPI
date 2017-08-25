/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object.formatters;

import java.lang.reflect.Type;
import java.util.AbstractMap.SimpleEntry;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * @author Ub - H. MARTEAU
 * @version 2.1
 */
public class GsonFormatters {
	protected static String formatJson(String[] values) {
		final GsonBuilder builder = new GsonBuilder();
		final Gson gson = builder.create();

		return gson.toJson(values);
	}

	protected static String formatJson(List<Object> values) {
		final GsonBuilder builder = new GsonBuilder();
		final Gson gson = builder.create();

		return gson.toJson(values);
	}

	protected static String formatJson(Object value) {
		final GsonBuilder builder = new GsonBuilder();
		builder.registerTypeAdapter(SimpleEntry.class, new SimpleEntryAdapter());
		final Gson gson = builder.create();

		return gson.toJson(value);
	}
	
	public static class SimpleEntryAdapter implements JsonSerializer<SimpleEntry> {

		 @Override
		 public JsonElement serialize(SimpleEntry src, Type typeOfSrc,
		            JsonSerializationContext context) {

		        JsonObject obj = new JsonObject();
		        obj.addProperty(src.getKey().toString(), (Integer) src.getValue());

		        return obj;
		    }
		}
}
