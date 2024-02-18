package test;


import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test {
    public static void main(String[] args) throws JsonProcessingException {
//        getOrder();
        System.out.println(LocalDateTime.parse("2020/1/29 10:11:20", DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")));

    }

    public static void getOrder(){
        HttpResponse execute = HttpUtil.createPost("http://128.0.16.121:8019/OrderManageServices.svc/GetLanXiangPatOrdereInfo")
                .body("{\"patientId\":\"99035591\"}").execute();
        System.out.println(execute);
    }

    private static void extracted() throws JsonProcessingException {
        String url = "http://128.0.16.191:18030/services/RISCheckApply.RISCheckApplyHttpSoap12Endpoint";
        String postData = "<Envelope xmlns=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "    <Body>\n" +
                "        <getPatientInfo xmlns=\"http://tempuri.org/\">\n" +
                "            <callType></callType>\n" +
                "            <xmlMessage>\n" +
                "                <![CDATA[<Params><Item><Fields><Field name=\"AdmitNo\" value=\"96007266\" /><Field name=\"CureNo\" value=\"\" /><Field name=\"SelectFlag\" value=\"1\" />\n" +
                "        </Fields>\n" +
                "    </Item>\n" +
                "</Params>]]>\n" +
                "    \n" +
                "    \n" +
                "    </xmlMessage>\n" +
                "</getPatientInfo>\n" +
                "</Body>\n" +
                "</Envelope>";

        // 发送POST请求
        HttpResponse response = HttpUtil.createPost(url)
                .header("Content-Type","Content-Type: application/soap+xml")
                .header("charset","utf-8")
                .body(postData)
                .execute();

        // 获取响应结果
        String result = response.body();
        XmlMapper xmlMapper = new XmlMapper();
        JsonNode jsonNode = xmlMapper.readTree(result);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(jsonNode.get("Body").get("getPatientInfoResponse").get("getPatientInfoResult"));
        jsonNode = xmlMapper.readTree(getXml());
        System.out.println(objectMapper.writeValueAsString(jsonNode));
//        System.out.println(objectMapper.writeValueAsString(jsonNode));
    }


    public static String getXml(){
        return "<Result>\n" +
                "    <StatusCode>1</StatusCode>\n" +
                "    <ErrorMessage/>\n" +
                "    <Data>\n" +
                "        <Items>\n" +
                "            <Item>\n" +
                "                <Fields>\n" +
                "                    <Field name=\"CardNo\" value=\"135401014456880\"/>\n" +
                "                    <Field name=\"AdmitNo\" value=\"96007266\"/>\n" +
                "                    <Field name=\"Part_NAME\" value=\"测试218病区\"/>\n" +
                "                    <Field name=\"PAT_SEX\" value=\"男\"/>\n" +
                "                    <Field\n" +
                "                            name=\"CureNo\" value=\"21606573\"/>\n" +
                "                    <Field name=\"BirthDay\" value=\"19970512\"/>\n" +
                "                    <Field\n" +
                "                            name=\"Status\" value=\"3\"/>\n" +
                "                    <Field name=\"WardCode\" value=\"1189\"/>\n" +
                "                    <Field name=\n" +
                "                                   \"WardName\" value=\"\"/>\n" +
                "                    <Field name=\"DeptCode\" value=\"12883\"/>\n" +
                "                    <Field name=\"DeptName\"\n" +
                "                           value=\"西院运动医学科\"/>\n" +
                "                    <Field name=\"HomePhone\" value=\"13333333333\"/>\n" +
                "                    <Field name=\n" +
                "                                   \"HomeAddress\" value=\"1\"/>\n" +
                "                    <Field name=\"Age\" value=\"26\"/>\n" +
                "                    <Field name=\"ID_NO\"\n" +
                "                           value=\"310228199705124016\"/>\n" +
                "                    <Field name=\"HospitalCode\" value=\"\"/>\n" +
                "                    <Field name=\"AdmitDate\"\n" +
                "                           value=\"2022/8/2 15:33:22\"/>\n" +
                "                    <Field name=\"AdmitDiag\" value=\"\"/>\n" +
                "                    <Field name=\"BedNo\"\n" +
                "                           value=\"101\"/>\n" +
                "                </Fields>\n" +
                "            </Item>\n" +
                "            <Item>\n" +
                "                <Fields>\n" +
                "                    <Field name=\"CardNo\" value=\"135401014456880\"/>\n" +
                "                    <Field name=\"AdmitNo\" value=\"96007266\"/>\n" +
                "                    <Field name=\"Part_NAME\" value=\"测试218病区\"/>\n" +
                "                    <Field name=\"PAT_SEX\" value=\"男\"/>\n" +
                "                    <Field\n" +
                "                            name=\"CureNo\" value=\"21507901\"/>\n" +
                "                    <Field name=\"BirthDay\" value=\"19970512\"/>\n" +
                "                    <Field\n" +
                "                            name=\"Status\" value=\"3\"/>\n" +
                "                    <Field name=\"WardCode\" value=\"1134\"/>\n" +
                "                    <Field name=\n" +
                "                                   \"WardName\" value=\"测试病区\"/>\n" +
                "                    <Field name=\"DeptCode\" value=\"12728\"/>\n" +
                "                    <Field name=\n" +
                "                                   \"DeptName\" value=\"北院测试\"/>\n" +
                "                    <Field name=\"HomePhone\" value=\"13333333333\"/>\n" +
                "                    <Field name=\n" +
                "                                   \"HomeAddress\" value=\"1\"/>\n" +
                "                    <Field name=\"Age\" value=\"26\"/>\n" +
                "                    <Field name=\"ID_NO\"\n" +
                "                           value=\"310228199705124016\"/>\n" +
                "                    <Field name=\"HospitalCode\" value=\"8\"/>\n" +
                "                    <Field name=\"AdmitDate\"\n" +
                "                           value=\"2022/7/13 15:20:01\"/>\n" +
                "                    <Field name=\"AdmitDiag\" value=\"\"/>\n" +
                "                    <Field name=\"BedNo\"\n" +
                "                           value=\"100\"/>\n" +
                "                </Fields>\n" +
                "            </Item>\n" +
                "            <Item>\n" +
                "                <Fields>\n" +
                "                    <Field name=\"CardNo\" value=\"135401014456880\"/>\n" +
                "                    <Field name=\"AdmitNo\" value=\"96007266\"/>\n" +
                "                    <Field name=\"Part_NAME\" value=\"测试218病区\"/>\n" +
                "                    <Field name=\"PAT_SEX\" value=\"男\"/>\n" +
                "                    <Field\n" +
                "                            name=\"CureNo\" value=\"21502080\"/>\n" +
                "                    <Field name=\"BirthDay\" value=\"19970512\"/>\n" +
                "                    <Field\n" +
                "                            name=\"Status\" value=\"3\"/>\n" +
                "                    <Field name=\"WardCode\" value=\"1162\"/>\n" +
                "                    <Field name=\n" +
                "                                   \"WardName\" value=\"218病区\"/>\n" +
                "                    <Field name=\"DeptCode\" value=\"12619\"/>\n" +
                "                    <Field name=\"DeptName\"\n" +
                "                           value=\"北院耳鼻咽喉科\"/>\n" +
                "                    <Field name=\"HomePhone\" value=\"13333333333\"/>\n" +
                "                    <Field name=\n" +
                "                                   \"HomeAddress\" value=\"1\"/>\n" +
                "                    <Field name=\"Age\" value=\"26\"/>\n" +
                "                    <Field name=\"ID_NO\"\n" +
                "                           value=\"310228199705124016\"/>\n" +
                "                    <Field name=\"HospitalCode\" value=\"8\"/>\n" +
                "                    <Field name=\"AdmitDate\"\n" +
                "                           value=\"2022/7/12 13:44:12\"/>\n" +
                "                    <Field name=\"AdmitDiag\" value=\"\"/>\n" +
                "                    <Field name=\"BedNo\"\n" +
                "                           value=\"1\"/>\n" +
                "                </Fields>\n" +
                "            </Item>\n" +
                "            <Item>\n" +
                "                <Fields>\n" +
                "                    <Field name=\"CardNo\" value=\"135401014456880\"/>\n" +
                "                    <Field name=\"AdmitNo\" value=\"96007266\"/>\n" +
                "                    <Field name=\"Part_NAME\" value=\"测试218病区\"/>\n" +
                "                    <Field name=\"PAT_SEX\" value=\"男\"/>\n" +
                "                    <Field\n" +
                "                            name=\"CureNo\" value=\"21498109\"/>\n" +
                "                    <Field name=\"BirthDay\" value=\"19970512\"/>\n" +
                "                    <Field\n" +
                "                            name=\"Status\" value=\"3\"/>\n" +
                "                    <Field name=\"WardCode\" value=\"1176\"/>\n" +
                "                    <Field name=\n" +
                "                                   \"WardName\" value=\"218病区\"/>\n" +
                "                    <Field name=\"DeptCode\" value=\"12670\"/>\n" +
                "                    <Field name=\"DeptName\"\n" +
                "                           value=\"北院心内科\"/>\n" +
                "                    <Field name=\"HomePhone\" value=\"13333333333\"/>\n" +
                "                    <Field name=\"HomeAddress\"\n" +
                "                           value=\"1\"/>\n" +
                "                    <Field name=\"Age\" value=\"26\"/>\n" +
                "                    <Field name=\"ID_NO\" value=\"310228199705124016\"\n" +
                "                    />\n" +
                "                    <Field name=\"HospitalCode\" value=\"8\"/>\n" +
                "                    <Field name=\"AdmitDate\" value=\"2022/7/11 16:49:28\"\n" +
                "                    />\n" +
                "                    <Field name=\"AdmitDiag\" value=\"\"/>\n" +
                "                    <Field name=\"BedNo\" value=\"5\"/>\n" +
                "                </Fields>\n" +
                "            </Item>\n" +
                "        </Items>\n" +
                "    </Data>\n" +
                "</Result>";
    }



}
