package com.okhttpplus;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.Proxy;
import java.security.KeyManagementException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import com.squareup.okhttp.Authenticator;
import com.squareup.okhttp.Credentials;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.RequestLine;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.DependsOn;
import anywheresoftware.b4a.BA.Events;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.Permissions;
import anywheresoftware.b4a.BA.Version;
import anywheresoftware.b4a.objects.streams.File;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

@BA.ShortName("OkHttpClient")
@Version(1.00f)
@Events(values={"ResponseSuccess (Response As OkHttpResponse, TaskId As Int)","ResponseError (Response As OkHttpResponse, Reason As String, StatusCode As Int, TaskId As Int)"})
@DependsOn(values={"okhttp-2.4.0","okio-1.4.0"})
@Permissions(values={"android.permission.INTERNET"})

public class OkHttpClientPlus {
	@BA.Hide
	public OkHttpClient client;
	@Hide
	public static BA mba;
	@Hide
	public static String EN;
	public void Initialize(BA ba,String EventName) {
		mba=ba;
		sharedInit(EventName);
	}
	 public boolean IsInitialized()
	  {
	    return this.client != null;
	  }
	public void InitializeAcceptAll(String EventName)
		    throws KeyManagementException, NoSuchAlgorithmException
		  {
		    sharedInit(EventName);
		    this.client.setHostnameVerifier(new HostnameVerifier()
		    {
		      public boolean verify(String arg0, SSLSession arg1)
		      {
		        return true;
		      }
		    });
		    SSLContext sslContext = SSLContext.getInstance("SSL");
		    sslContext.init(null, new TrustManager[] { new NaiveTrustManager() }, new SecureRandom());
		    SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
		    this.client.setSslSocketFactory(sslSocketFactory);
		  }
	private static class NaiveTrustManager
    implements X509TrustManager
  {
    public void checkClientTrusted(X509Certificate[] cert, String authType)
      throws CertificateException
    {}
    
    public void checkServerTrusted(X509Certificate[] cert, String authType)
      throws CertificateException
    {}
    
    public X509Certificate[] getAcceptedIssuers()
    {
      return null;
    }
  }
	private void sharedInit(String EventName)
	  {
	    this.client = new OkHttpClient();
	    EN=EventName.toLowerCase();
		client=new OkHttpClient();
		setTimeout(this.client, 30000);
	    CookieManager cm = new CookieManager();
	    cm.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
	    client.setCookieHandler(cm);
	  }
	 static void setTimeout(OkHttpClient client, int TimeoutMs)
	  {
	    client.setConnectTimeout(TimeoutMs, TimeUnit.MILLISECONDS);
	    client.setWriteTimeout(TimeoutMs, TimeUnit.MILLISECONDS);
	    client.setReadTimeout(TimeoutMs, TimeUnit.MILLISECONDS);
	  }
	 public boolean Execute(BA ba, OkHttpRequestPlus HttpRequest, int TaskId)
		    throws IOException
		  {
		    return ExecuteCredentials(ba, HttpRequest, TaskId, null, null);
		  }
			  
	 public boolean ExecuteCredentials(BA ba, OkHttpRequestPlus Request, int TaskId, String UserName, String Password)
	  {
	    if (BA.isTaskRunning(this, TaskId)) {
	      return false;
	    }
	    Runnable runnable = new ExecuteHelper(ba, Request, TaskId, UserName, Password);
	    BA.submitRunnable(runnable, this, TaskId);
	    return true;
	  }
	  
	  private Response executeWithTimeout(Runnable handler, OkHttpClient myClient, Request req, BA ba, int TaskId)
	    throws IOException
	  {
	    return myClient.newCall(req).execute();
	  }
	  
	  class ExecuteHelper
	    implements Runnable
	  {
	    private BA ba;
	    private OkHttpRequestPlus HttpRequest;
	    private int TaskId;
	    private String UserName;
	    private String Password;
	    
	    public ExecuteHelper(BA ba, OkHttpRequestPlus HttpRequest, int TaskId, String UserName, String Password)
	    {
	      this.ba = ba;
	      this.HttpRequest = HttpRequest;
	      this.TaskId = TaskId;
	      this.UserName = UserName;
	      this.Password = Password;
	    }
	    
	    public void run()
	    {
	      Response response = null;
	      OkHttpResponse res = new OkHttpResponse();
	      //OkHttpClientWrapper.OkHttpResponse.access$0(res, OkHttpClientWrapper.this);
	      try
	      {
	    	  OkHttpClient myClient = client.clone();
	        setTimeout(myClient, this.HttpRequest.timeout);
	        Request req = this.HttpRequest.builder.build();
	        boolean recoverable = (!(req.body() instanceof PostPayloadPlus)) || (((PostPayloadPlus)req.body()).data != null);
	        if ((this.UserName != null) && (this.UserName.length() > 0))
	        {
	          myClient.setAuthenticator(new B4AAuthenticator(this.UserName, this.Password));
	          if (((req.body() instanceof PostPayloadPlus)) && 
	            (!recoverable))
	          {
	            String credential = Credentials.basic(this.UserName, this.Password);
	            req = req.newBuilder().header("Authorization", credential).build();
	          }
	        }
	        myClient.setRetryOnConnectionFailure(recoverable);
	        response = executeWithTimeout(this, myClient, req, this.ba, this.TaskId);
	        if (response == null) {
	          return;
	        }
	        if (!response.isSuccessful()) {
	          throw new Exception();
	        }
	        res.response = response;
	        this.ba.raiseEventFromDifferentThread(client, this, this.TaskId, 
	          EN + "_responsesuccess", true, new Object[] { res, Integer.valueOf(this.TaskId) });
	      }
	      catch (Exception e)
	      {
	        String reason;
	        int statusCode;
	        if (response != null)
	        {
	          statusCode = response.code();
	          reason = response.message();
	          if (reason == null) {
	            reason = "";
	          }
	        }
	        else
	        {
	          e.printStackTrace();
	          reason = e.toString();
	          statusCode = -1;
	        }
//	        if (response != null) {
//	          try
//	          {
//	            res.response.message() = response.body().string();
//	          }
//	          catch (Exception ee)
//	          {
//	            ee.printStackTrace();
//	          }
//	        }
	        this.ba.raiseEventFromDifferentThread(client, this, this.TaskId, 
	          EN + "_responseerror", 
	          false, new Object[] { res, reason, Integer.valueOf(statusCode), Integer.valueOf(this.TaskId) });
	      }
	    }
	  }
	  @BA.ShortName("OkHttpRequest")
	  public static class OkHttpRequestPlus
	  {
	    public int timeout = 30000;
	    @BA.Hide
	    public Request.Builder builder;
	    @BA.Hide
	    public PostPayloadPlus pp;
	    
	    public void InitializeGet(String URL)
	    {
	      this.builder = new Request.Builder().url(URL).get();
	    }
	    
	    public void InitializeHead(String URL)
	    {
	      this.builder = new Request.Builder().url(URL).head();
	    }
	    
	    public void InitializeDelete(String URL)
	    {
	      this.builder = new Request.Builder().url(URL).delete();
	    }
	    
	    public void InitializeDelete2(String URL, byte[] Data)
	    {
	      this.pp = PostPayloadPlus.createFromArray(Data);
	      this.builder = new Request.Builder().url(URL).delete(pp);
	    }
	    
	    public void InitializePost(String URL, InputStream InputStream, int Length)
	    {
	      this.pp = PostPayloadPlus.createFromStream(InputStream, Length);
	      this.builder = new Request.Builder().url(URL).post(this.pp);
	    }
	    
	    public void InitializePost2(String URL, byte[] Data)
	    {
	      this.pp = PostPayloadPlus.createFromArray(Data);
	      this.builder = new Request.Builder().url(URL).post(this.pp);
	    }
	    
	    public void InitializePut(String URL, InputStream InputStream, int Length)
	    {
	      this.pp = PostPayloadPlus.createFromStream(InputStream, Length);
	      this.builder = new Request.Builder().url(URL).put(this.pp);
	    }
	    
	    public void InitializePut2(String URL, byte[] Data)
	    {
	      this.pp = PostPayloadPlus.createFromArray(Data);
	      this.builder = new Request.Builder().url(URL).put(this.pp);
	    }
	    
	    public void InitializePatch(String URL, InputStream InputStream, int Length)
	    {
	      this.pp = PostPayloadPlus.createFromStream(InputStream, Length);
	      this.builder = new Request.Builder().url(URL).patch(this.pp);
	    }
	    
	    public void InitializePatch2(String URL, byte[] Data)
	    {
	      this.pp = PostPayloadPlus.createFromArray(Data);
	      this.builder = new Request.Builder().url(URL).patch(this.pp);
	    }
	    
	    public void SetHeader(String Name, String Value)
	    {
	      this.builder.addHeader(Name, Value);
	    }
	    
	    public void RemoveHeaders(String Name)
	    {
	      this.builder.removeHeader(Name);
	    }
	    
	    public void SetContentType(String ContentType)
	    {
	      if (this.pp == null) {
	        throw new RuntimeException("Request does not support this method.");
	      }
	      this.pp.contentType = ContentType;
	    }
	    
	    public void SetContentEncoding(String Encoding)
	    {
	      this.builder.header("Content-Encoding", Encoding);
	    }
	  }
    
	  
	@Hide
	public static class PostPayloadPlus extends RequestBody{
		public String contentType = "application/x-www-form-urlencoded";
	    private long contentLength = -1L;
	    private static final int SEGMENT_SIZE = 2048; // okio.Segment.SIZE
	    private Source source;
	    public byte[] data;
		public static PostPayloadPlus createFromStream(InputStream input, int Length)
	    {
		  PostPayloadPlus pp = new PostPayloadPlus();
	      pp.source = Okio.source(input);
	      pp.contentLength = Length;
	      return pp;
	    }
		public static PostPayloadPlus createFromArray(byte[] data)
	    {
		  PostPayloadPlus pp = new PostPayloadPlus();
	      pp.data = data;
	      return pp;
	    }
	    
	    public MediaType contentType()
	    {
	      return MediaType.parse(this.contentType);
	    }
	    
	    public long contentLength()
	      throws IOException
	    {
	      if (this.data != null) {
	        return this.data.length;
	      }
	      return this.contentLength;
	    }
	    
	    public void writeTo(BufferedSink sink)
	      throws IOException
	    {
	      if (this.data != null) {
	        sink.write(this.data);
	      } else {
	    	  long read;
	    	  long total = 0;
	    	  while ((read = source.read(sink.buffer(), SEGMENT_SIZE)) != -1) {
	                total += read;
	                sink.flush();
	                mba.raiseEventFromDifferentThread(this, this, 0, EN+"_writeprogress", false, new Object[]{total,contentLength});
	                //this.listener.transferred(total);
//	                if (mba.subExists(EN+"_writeprogress")) {
//						mba.raiseEvent(this, EN+"_writeprogress", new Object[]{total,contentLength});
//						
//					}

	            }
	    	  //Util.closeQuietly(source);
	      }
	    }
		
	}
	@BA.ShortName("OkHttpResponse")
	@Events(values={"StreamFinish (Success As Boolean, TaskId As Int)","writeProgress(current as Long,Total as Long)"})
	  public static class OkHttpResponse
	  {
	    private OkHttpRequestPlus parent;
	    String errorMessage = "";
	    @BA.Hide
	    public Response response;
	    
	    private void innerInitialize(OkHttpRequestPlus parent)
	    {
	      this.parent = parent;
	    }
	    
	    public anywheresoftware.b4a.objects.collections.Map GetHeaders()
	    {
	      return convertHeaders(this.response.headers().toMultimap());
	    }
	    
	    public String getContentType()
	    {
	      return this.response.header("Content-Type", "");
	    }
	    
	    public String getContentEncoding()
	    {
	      return this.response.header("Content-Encoding", "");
	    }
	    
	    public String getErrorResponse()
	    {
	      return this.errorMessage;
	    }
	    
	    public long getContentLength()
	      throws IOException
	    {
	      return this.response.body().contentLength();
	    }
	    
	    static anywheresoftware.b4a.objects.collections.Map convertHeaders(java.util.Map<String, List<String>> headers)
	    {
	      anywheresoftware.b4a.objects.collections.Map m = new anywheresoftware.b4a.objects.collections.Map();
	      m.Initialize();
	      for (Map.Entry<String, List<String>> e : headers.entrySet()) {
	        m.Put(e.getKey(), e.getValue());
	      }
	      return m;
	    }
	    
	    public int getStatusCode()
	    {
	      return this.response.code();
	    }
	    
	    public void Release()
	      throws IOException
	    {
	      if ((this.response != null) && (this.response.body() != null)) {
	        Util.closeQuietly(this.response.body().source());
	      }
	    }
	    
	    public boolean GetAsynchronously(final BA ba, final String EventName, final OutputStream Output, final boolean CloseOutput, final int TaskId)
	      throws IOException
	    {
	      if (BA.isTaskRunning(this.parent, TaskId))
	      {
	        Release();
	        return false;
	      }
	      Runnable runnable = new Runnable()
	      {
	        public void run()
	        {
	          try
	          {
	            File.Copy2(OkHttpResponse.this.response.body().byteStream(), Output);
	            if (CloseOutput) {
	              Output.close();
	            }
	            ba.raiseEventFromDifferentThread(OkHttpResponse.this.response, this, TaskId, 
	              EventName.toLowerCase(BA.cul) + 
	              "_streamfinish", true, new Object[] { Boolean.valueOf(true), Integer.valueOf(TaskId) });
	          }
	          catch (IOException e)
	          {
	            ba.setLastException(e);
	            if (CloseOutput) {
	              try
	              {
	                Output.close();
	              }
	              catch (IOException localIOException1) {}
	            }
	            ba.raiseEventFromDifferentThread(OkHttpResponse.this.response, this, TaskId, 
	              EventName.toLowerCase(BA.cul) + 
	              "_streamfinish", true, new Object[] { Boolean.valueOf(false), Integer.valueOf(TaskId) });
	          }
	          try
	          {
	            OkHttpResponse.this.response.body().close();
	          }
	          catch (IOException e)
	          {
	            e.printStackTrace();
	          }
	        }
	      };
	      BA.submitRunnable(runnable, this.parent, TaskId);
	      return true;
	    }
	  }
	@BA.Hide
	  public static class B4AAuthenticator
	    implements Authenticator
	  {
	    public final String username;
	    public final String password;
	    private static Pattern ptDigest;
	    
	    public B4AAuthenticator(String username, String password)
	    {
	      this.username = username;
	      this.password = password;
	    }
	    
	    public Request authenticate(Proxy proxy, Response response)
	      throws IOException
	    {
	      if (responseCount(response) >= 3) {
	        return null;
	      }
	      String raw = response.header("WWW-Authenticate");
	      if (raw == null) {
	        raw = "";
	      }
	      String v = raw.toLowerCase(BA.cul);
	      String credential;
	      if (v.contains("digest"))
	      {
	        credential = handleDigest(response, raw);
	      }
	      else
	      {
	        credential = Credentials.basic(this.username, this.password);
	        if (credential.equals(response.request().header("Authorization"))) {
	          return null;
	        }
	      }
	      return 
	      
	        response.request().newBuilder().header("Authorization", credential).build();
	    }
	    
	    private String handleDigest(Response response, String raw)
	      throws IOException
	    {
	      Request request = response.request();
	      String methodName = request.method();
	      String uri = RequestLine.requestPath(request.uri().toURL());
	      if (ptDigest == null) {
	        ptDigest = Pattern.compile("(\\w+)=\\\"([^\"]+)\\\"");
	      }
	      Matcher m = ptDigest.matcher(raw);
	      HashMap<String, String> params = new HashMap();
	      while (m.find()) {
	        params.put(m.group(1), m.group(2));
	      }
	      MessageDigest md;
	      String nonce = (String)params.get("nonce");
	      String realm = (String)params.get("realm");
	      try
	      {
	        md = MessageDigest.getInstance("MD5");
	      }
	      catch (NoSuchAlgorithmException e)
	      {
	        throw new RuntimeException();
	      }
	      StringBuilder temp = new StringBuilder();
	      temp.append(this.username).append(":").append(realm).append(":").append(this.password);
	      byte[] binary = md.digest(temp.toString().getBytes("ISO-8859-1"));
	      String md5a1 = encode(binary);
	      String a2 = methodName + ":" + uri;
	      boolean qopMissing = !raw.contains("qop");
	      String md5a2 = encode(md.digest(a2.getBytes("ASCII")));
	      
	      String NC = "00000001";
	      String cnonce = null;
	      String serverDigestValue;
	      if (qopMissing)
	      {
	        StringBuilder tmp2 = new StringBuilder();
	        tmp2.append(md5a1);
	        tmp2.append(':');
	        tmp2.append(nonce);
	        tmp2.append(':');
	        tmp2.append(md5a2);
	        serverDigestValue = tmp2.toString();
	      }
	      else
	      {
	        String qopOption = "auth";
	        cnonce = encode(md.digest(Long.toString(System.currentTimeMillis()).getBytes("ASCII")));
	        
	        StringBuilder tmp2 = new StringBuilder();
	        tmp2.append(md5a1);
	        tmp2.append(':');
	        tmp2.append(nonce);
	        tmp2.append(':');
	        tmp2.append(NC);
	        tmp2.append(':');
	        tmp2.append(cnonce);
	        tmp2.append(':');
	        tmp2.append(qopOption);
	        tmp2.append(':');
	        tmp2.append(md5a2);
	        serverDigestValue = tmp2.toString();
	      }
	      String serverDigest = 
	        encode(md.digest(serverDigestValue.getBytes("ASCII")));
	      StringBuilder sb = new StringBuilder();
	      sb.append("Digest ").append(param("username", this.username, true)).append(",")
	        .append(param("realm", realm, true)).append(",")
	        .append(param("nonce", nonce, true)).append(",")
	        .append(param("uri", uri, true)).append(",");
	      if (!qopMissing) {
	        sb.append(param("qop", "auth", false)).append(",").append(param("nc", NC, false)).append(",").append(param("cnonce", cnonce, true)).append(",");
	      }
	      sb.append(param("response", serverDigest, true));
	      String opaque = (String)params.get("opaque");
	      if (opaque != null) {
	        sb.append(",").append(param("opaque", opaque, true));
	      }
	      return sb.toString();
	    }
	    
	    private String param(String key, String value, boolean quote)
	    {
	      return key + "=" + (quote ? "\"" : "") + value + (quote ? "\"" : "");
	    }
	    
	    private static final char[] HEXADECIMAL = {
	      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 
	      'e', 'f' };
	    
	    private static String encode(byte[] binaryData)
	    {
	      if (binaryData.length != 16) {
	        return null;
	      }
	      char[] buffer = new char[32];
	      for (int i = 0; i < 16; i++)
	      {
	        int low = binaryData[i] & 0xF;
	        int high = (binaryData[i] & 0xF0) >> 4;
	        buffer[(i * 2)] = HEXADECIMAL[high];
	        buffer[(i * 2 + 1)] = HEXADECIMAL[low];
	      }
	      return new String(buffer);
	    }
	    
	    private int responseCount(Response response)
	    {
	      int result = 1;
	      while ((response = response.priorResponse()) != null) {
	        result++;
	      }
	      return result;
	    }
	    
	    public Request authenticateProxy(Proxy proxy, Response response)
	      throws IOException
	    {
	      return null;
	    }
	  }
}
