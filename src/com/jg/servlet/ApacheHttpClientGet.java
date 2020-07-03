package com.jg.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

@SuppressWarnings("deprecation")
public class ApacheHttpClientGet {
	private Integer runVersion = 0;
	private String HTML_NEWLINE = "<br><br>";
	@SuppressWarnings({ "resource", "deprecation" })
	public static void main(String[] args) {

	}
	/**
	 * @return the runVersion
	 */
	protected Integer getRunVersion() {
		return runVersion;
	}
	/**
	 * @param runVersion the runVersion to set
	 */
	protected void setRunVersion(Integer runVersion) {
		this.runVersion = runVersion;
	}
	
	@SuppressWarnings("resource")
	protected String runTheProcess () {
		StringBuilder sb = new StringBuilder();
		HttpGet getRequest = null;
		DefaultHttpClient httpClient = new DefaultHttpClient();
		try {
			Integer request = getRunVersion();
			switch (request) {
			case 1:
				 getRequest = new HttpGet(
						"http://localhost:8080/CrunchifyRESTJerseyExample/crunchify/ctofservice/" + request);
				getRequest.addHeader("accept", "application/json");
				sb.append("Sending:" + getRequest.getRequestLine() + HTML_NEWLINE);
				break;
			case 2:
				getRequest = new HttpGet(
						"http://localhost:8080/CrunchifyRESTJerseyExample/crunchify/ftocservice/" + request);
				getRequest.addHeader("accept", "application/json");
				sb.append("Sending:" + getRequest.getRequestLine()+ HTML_NEWLINE );
				break;
			case 3:
				getRequest = new HttpGet(
						"http://localhost:8080/CrunchifyRESTJerseyExample/crunchify/agebydate/12-13-1957");
				getRequest.addHeader("accept", "application/json");
				sb.append("Sending:" + getRequest.getRequestLine()+ HTML_NEWLINE );
				break;
			}
			
			HttpResponse response = httpClient.execute(getRequest);
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
			sb.append("Output from Server ...." + HTML_NEWLINE);
			String output;
			//need to redirect SB to output of page.
			while ((output = br.readLine()) != null) {
				sb.append(output + HTML_NEWLINE);
			}
			httpClient.getConnectionManager().shutdown();
			httpClient.close();

		} catch (ClientProtocolException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}
		return sb.toString();
	}

}
