package com.test.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@Slf4j
public class HttpClientUtil {

	private static CloseableHttpClient buildSSLCloseableHttpClient() throws Exception {
		SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
			// 信任所有
			public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
				return true;
			}
		}).build();
		// ALLOW_ALL_HOSTNAME_VERIFIER:这个主机名验证器基本上是关闭主机名验证的,实现的是一个空操作，并且不会抛出javax.net.ssl.SSLException异常。
		SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, new String[] { "TLSv1" }, null,
				SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
		return HttpClients.custom().setSSLSocketFactory(sslsf).build();
	}
	
	public static String send(String url, Map<String, String> map) {
		return doPost(url, map, "UTF-8");
	}
	
	
	public static String doPost(String url, Map<String, String> map, String charset) {
		CloseableHttpClient buildSSLCloseableHttpClient = null;
		try {
			//创建httpclient对象  
			buildSSLCloseableHttpClient = buildSSLCloseableHttpClient();
//			System.setProperty("jsse.enableSNIExtension", "false");
			//创建post方式请求对象  
			HttpPost httpPost = new HttpPost(url);
			//装填参数  
	        List<NameValuePair> nvps = new ArrayList<NameValuePair>();  
	        if(map!=null){  
	            for (Entry<String, String> entry : map.entrySet()) {  
	                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));  
	            }  
	        }  
	        //设置参数到请求对象中  
	        if (nvps.size() > 0) {
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(nvps, charset);
				httpPost.setEntity(entity);
			}
	        
			HttpResponse response = buildSSLCloseableHttpClient.execute(httpPost);
			
			if (response != null) {
				HttpEntity resEntity = response.getEntity();
				String result = null;
				if (resEntity != null) {
					result = EntityUtils.toString(resEntity, charset);
				}
				log.info("response status code: " + response.getStatusLine().getStatusCode());
				if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					return result;
				}else {
					log.info("response:" + result);
				}
			}
		} catch (Exception e) {
			log.error("Exception in doPost: ", e);
			return null;
		} finally {
			if(buildSSLCloseableHttpClient != null) {
				try {
					buildSSLCloseableHttpClient.close();
				} catch (IOException e) {
					log.error("IOException in doPost: ", e);
				}
			}
		}
		return null;
	}
	
	public static String doPost(String url, String request, String charset) {
		CloseableHttpClient buildSSLCloseableHttpClient = null;
		try {
			//创建httpclient对象  
			buildSSLCloseableHttpClient = buildSSLCloseableHttpClient();
//			System.setProperty("jsse.enableSNIExtension", "false");
			//创建post方式请求对象  
			HttpPost httpPost = new HttpPost(url);
	        StringEntity se = new StringEntity(request);
	        httpPost.setEntity(se);
	        
			HttpResponse response = buildSSLCloseableHttpClient.execute(httpPost);
			
			if (response != null) {
				HttpEntity resEntity = response.getEntity();
				String result = null;
				if (resEntity != null) {
					result = EntityUtils.toString(resEntity, charset);
				}
				log.info("response status code: " + response.getStatusLine().getStatusCode());
				if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					return result;
				}else {
					log.info("response:" + result);
				}
			}
		} catch (Exception e) {
			log.error("Exception in doPost: ", e);
			return null;
		} finally {
			if(buildSSLCloseableHttpClient != null) {
				try {
					buildSSLCloseableHttpClient.close();
				} catch (IOException e) {
					log.error("IOException in doPost: ", e);
				}
			}
		}
		return null;
	}
	
	public static String doGet(String url, String charset) {
		CloseableHttpClient buildSSLCloseableHttpClient = null;
		try {
			buildSSLCloseableHttpClient = buildSSLCloseableHttpClient();
//			System.setProperty("jsse.enableSNIExtension", "false");
			HttpGet httpGet = new HttpGet(url);
			HttpResponse response = buildSSLCloseableHttpClient.execute(httpGet);
			if (response != null) {
				HttpEntity resEntity = response.getEntity();
				String result = null;
				if (resEntity != null) {
					result = EntityUtils.toString(resEntity, charset);
				}
				log.info("response status code: " + response.getStatusLine().getStatusCode());
				if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					return result;
				}else {
					log.info("response:" + result);
				}
			}
		} catch (Exception e) {
			log.error("Exception in doGet: ", e);
			return null;
		} finally {
			if(buildSSLCloseableHttpClient != null) {
				try {
					buildSSLCloseableHttpClient.close();
				} catch (IOException e) {
					log.error("IOException in doGet: ", e);
				}
			}
		}
		return null;
	}
}