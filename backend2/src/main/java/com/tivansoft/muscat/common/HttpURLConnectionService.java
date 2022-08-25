package com.tivansoft.muscat.common;


import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class HttpURLConnectionService {

    private static final Logger logger = LoggerFactory.getLogger(HttpURLConnectionService.class);

    public JSONObject testServiceApi() throws Exception {

        String body_contents1 = "body_text";
        String result_txt = "";
        StringBuilder sb = new StringBuilder();

        JSONObject obj = null;

        try {

            JSONObject reqParams = new JSONObject();
            reqParams.put("body_contents1", body_contents1); // body에 들어갈 내용을 담는다.

            URL url = new URL("http://localhost:9000/vue/receipt"); // 호출할 외부 API 를 입력한다.

            HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // header에 데이터 통신 방법을 지정한다.
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");

            // Post인 경우 데이터를 OutputStream으로 넘겨 주겠다는 설정
            conn.setDoOutput(true);

            // Request body message에 전송
            OutputStreamWriter os = new OutputStreamWriter(conn.getOutputStream());
            os.write(reqParams.toString());
            os.flush();

            // 응답
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

            String line = null;
            while((line = br.readLine()) != null) { // 읽을 수 있을 때 까지 반복
                sb.append(line);
            }

            br.close();
            conn.disconnect();

            obj = new JSONObject(sb.toString()); // json으로 변경 (역직렬화)

        } catch (Exception e) {
            e.printStackTrace();
        }

        return obj;
    }

}
