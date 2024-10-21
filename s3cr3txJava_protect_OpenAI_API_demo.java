import io.github.pixee.security.BoundedLineReader;
import java.io.*;
import java.net.*;
import javax.net.ssl.HttpsURLConnection;
public class s3cr3txJava_protect_OpenAI_API_demo {
    /**
     * @param strInput
     * @return
     */
    public static String getS3cr3tx(String strInput){
        URL s3cr3tx_url;
        try {
            s3cr3tx_url = new URL(System.getenv("s3cr3tx_API_URL"));
        HttpsURLConnection conn = (HttpsURLConnection)s3cr3tx_url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "text/plain");
        conn.setRequestProperty("Email", System.getenv("s3cr3tx_Email"));
        conn.setRequestProperty("APIToken", System.getenv("s3cr3tx_APIToken"));
        conn.setRequestProperty("AuthCode", System.getenv("s3cr3tx_AuthCode"));
        conn.setRequestProperty("Input", strInput);
        conn.setRequestProperty("EorD", "d");

        int responseCode = conn.getResponseCode();
        System.out.println("\nResponse code: " + responseCode);
        String strResult = new String();
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line = "";
        while ((line = BoundedLineReader.readLine(br, 5_000_000))!= null) {
            strResult += line;
        }
        return strResult;
    } catch (MalformedURLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        return "";
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        return "";
    }
    }
    public static String setS3cr3tx(String strInput){
        try {
        URL s3cr3tx_url = new URL(System.getenv("s3cr3tx_API_URL"));
        HttpsURLConnection conn = (HttpsURLConnection) s3cr3tx_url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "text/plain");
        conn.setRequestProperty("Email", System.getenv("s3cr3tx_Email"));
        conn.setRequestProperty("APIToken", System.getenv("s3cr3tx_APIToken"));
        conn.setRequestProperty("AuthCode", System.getenv("s3cr3tx_AuthCode"));
        conn.setRequestProperty("Input", strInput);
        conn.setRequestProperty("EorD", "e");

        int responseCode = conn.getResponseCode();
        System.out.println("\nResponse code: " + responseCode);
        String strResult = new String();
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line = "";
        while ((line = BoundedLineReader.readLine(br, 5_000_000))!= null) {
            strResult += line;
        }
        return strResult;
    } catch (MalformedURLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        return "";
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        return "";
    }
    }
     public static void main(String[] args) throws Exception {
        try {
        URL openai_url = new URL("https://api.openai.com/v1/models");
        HttpsURLConnection conn = (HttpsURLConnection) openai_url.openConnection();
        conn.setRequestMethod("GET");
        String strHeader = "Bearer " + System.getenv("OPENAI_API_KEY");
        conn.setRequestProperty("Authorization",strHeader);
        int responseCode = conn.getResponseCode();
        System.out.println("\nSending 'GET' request to OpenAI: ");
        System.out.println("\nResponse code: " + responseCode);
        String strResult = new String();
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line = "";
        while ((line = BoundedLineReader.readLine(br, 5_000_000))!= null) {
            strResult += line;
        }
        System.out.println("\n" + strResult);
        System.setProperty("s3cr3tx_OPENAI_API_KEY", setS3cr3tx(System.getenv("OPENAI_API_KEY")));
         URL openai_url_s3cr3tx = new URL("https://api.openai.com/v1/models");
       
        HttpsURLConnection conn2 = (HttpsURLConnection) openai_url_s3cr3tx.openConnection();
        conn2.setRequestMethod("GET");
        conn2.setRequestProperty("Authorization", "Bearer " + getS3cr3tx(System.getProperty("s3cr3tx_OPENAI_API_KEY")));
        int responseCode2 = conn.getResponseCode();
        System.out.println("\nResponse code: " + responseCode2);
        String strResult2 = new String();
        BufferedReader br2 = new BufferedReader(new InputStreamReader(conn2.getInputStream()));
        String lines = "";
        while ((lines = BoundedLineReader.readLine(br2, 5_000_000))!= null) {
            strResult2 += lines;
        }
        System.out.println("\n" + strResult2);
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    }
}
