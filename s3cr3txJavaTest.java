import io.github.pixee.security.HostValidator;
import io.github.pixee.security.Urls;
import java.io.*;
import java.net.*;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.HttpsURLConnection.*;
public class s3cr3txJavaTest {
    public static void getHTML(String website) throws Exception {
        URL url = Urls.create(website, Urls.HTTP_PROTOCOLS, HostValidator.DENY_COMMON_INFRASTRUCTURE_TARGETS);
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "text/plain");
        conn.setRequestProperty("Email", System.getenv("s3cr3tx_Email"));
        conn.setRequestProperty("APIToken", System.getenv("s3cr3tx_APIToken"));
        conn.setRequestProperty("AuthCode", System.getenv("s3cr3tx_AuthCode"));
        conn.setRequestProperty("Input", "This is some s3cr3t Text.");
        conn.setRequestProperty("EorD", "e");

        int responseCode = conn.getResponseCode();
        System.out.println("\nSending 'GET' request to URL: " + website);
        System.out.println("\nResponse code: " + responseCode);
        String strResult = new String();
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line = "";
        while ((line = br.readLine())!= null) {
            strResult += line;
        }
        System.out.println("\nS3cr3tx encrypted text is friom: " + website);
        System.out.println("\nResponse : " + strResult);
       

        
        //result3 = requests.get(URL_ROOT,headers={"Accept": DOC_FORMAT ,"Email": Email_Header,
        //"APIToken":API_Token_Header,"AuthCode":Auth_Code_Header,"EorD":EorD_Header,"Input":Input_Header })
        //
        HttpsURLConnection conn2 = (HttpsURLConnection) url.openConnection();
        conn2.setRequestMethod("GET");
        conn2.setRequestProperty("Accept", "text/plain");
        conn2.setRequestProperty("Email", System.getenv("s3cr3tx_Email"));
        conn2.setRequestProperty("APIToken", System.getenv("s3cr3tx_APIToken"));
        conn2.setRequestProperty("AuthCode", System.getenv("s3cr3tx_AuthCode"));
        conn2.setRequestProperty("Input", strResult);
        conn2.setRequestProperty("EorD", "d");
        System.out.println("\nSending 'GET' request to URL: " + website);
        System.out.println("\nResponse code: " + responseCode);
        String strResult2 = new String();
        BufferedReader br2 = new BufferedReader(new InputStreamReader(conn2.getInputStream()));
        String line2 = "";
        while ((line2 = br2.readLine())!= null) {
            strResult2 += line2;
        }
        System.out.println("\nS3cr3tx decrypted text from: " + website);
        System.out.println("\nResponse : " + strResult2);
       
        
    }
    public static void main(String[] args) throws Exception {
        getHTML("https://s3cr3tx.com/Values");
    }
}
