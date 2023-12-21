package dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 患者基本信息表
 */

@Data
public class BasicPatInfoDto implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 患者编码/急诊编号。系统自动生成
     */
    private String patCode;

    /**
     * 患者姓名
     */
    private String patName;

    /**
     * 医院标识
     */
    private Integer hospitalId;

    /**
     * 卡号(就诊卡/医保卡)
     */
    private String cardNum;

    /**
     * 证件类型。
     */
    private Integer cardType;

    /**
     * 出生日期
     */

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime patBirth;

    /**
     * 证件号码
     */
    private String idCard;

    /**
     * 年龄
     */
    private Integer patAge;

    /**
     * 联系方式
     */
    private String phoneNumber;

    /**
     * 职业
     */
    private String occupation;

    /**
     * 性别。0-未知，1-男，2-女
     */
    private Integer patGender;

    /**
     * 居住地址
     */
    private String address;

    /**
     * 紧急联系人姓名
     */
    private String patContactName;

    /**
     * 紧急联系人电话
     */
    private Integer patContactPhone;

    /**
     * 显示状态。0-不显示，1-显示
     */
    private Integer state;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 修改人
     */
    private String editor;

    /**
     * 更新时间
     */

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    /**
     * 是否删除。0-删除，1-正常。
     */
    private Integer isDelete;

    private static final long serialVersionUID = 1L;

}