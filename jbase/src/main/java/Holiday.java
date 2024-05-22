import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.apache.commons.lang3.StringUtils;

public class Holiday {

    public static void main(String[] args) {
        System.out.println(isHoliday("2024-05-11"));
        System.out.println(isHoliday("2024-05-17"));
        System.out.println(isHoliday("2024-05-18"));
        System.out.println(isHoliday("2024-05-1"));
    }
    public static boolean isHoliday(String date) {
        try (HttpResponse execute = HttpRequest.get("https://timor.tech/api/holiday/info/" + date)
                .timeout(20000)
                .execute()) {
            JSONObject jsonObject = JSONUtil.parseObj(execute.body());
            String str = jsonObject.getByPath("type.type", String.class);
            if (StringUtils.equalsAny(str, "1", "2")) {
                return true;
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
        return false;
    }
}
