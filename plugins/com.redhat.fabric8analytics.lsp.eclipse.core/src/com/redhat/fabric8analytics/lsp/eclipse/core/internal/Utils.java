package com.redhat.fabric8analytics.lsp.eclipse.core.internal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.eclipse.ui.PartInitException;
import org.json.JSONException;
import org.json.JSONObject;

public class Utils {


	public static JSONObject jsonObj(HttpResponse response) throws JSONException, UnsupportedOperationException, IOException {
		InputStream responseContent = response.getEntity().getContent();

		StringBuilder sb = new StringBuilder();
		BufferedReader rd = new BufferedReader(new InputStreamReader(
				responseContent));
		String line = "";
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		JSONObject json = new JSONObject(sb.toString());
		return json;
	}
}