package com.pk.patient.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 患者基本信息表
 *
 * @TableName basic_pat_info
 */
@TableName(value = "basic_pat_info")
@Data
public class BasicPatInfo implements Serializable {
    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
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
    private Date patBirth;

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
    private Date updateTime;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 是否删除。0-删除，1-正常。
     */
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        BasicPatInfo other = (BasicPatInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getPatCode() == null ? other.getPatCode() == null : this.getPatCode().equals(other.getPatCode()))
                && (this.getPatName() == null ? other.getPatName() == null : this.getPatName().equals(other.getPatName()))
                && (this.getHospitalId() == null ? other.getHospitalId() == null : this.getHospitalId().equals(other.getHospitalId()))
                && (this.getCardNum() == null ? other.getCardNum() == null : this.getCardNum().equals(other.getCardNum()))
                && (this.getCardType() == null ? other.getCardType() == null : this.getCardType().equals(other.getCardType()))
                && (this.getPatBirth() == null ? other.getPatBirth() == null : this.getPatBirth().equals(other.getPatBirth()))
                && (this.getIdCard() == null ? other.getIdCard() == null : this.getIdCard().equals(other.getIdCard()))
                && (this.getPatAge() == null ? other.getPatAge() == null : this.getPatAge().equals(other.getPatAge()))
                && (this.getPhoneNumber() == null ? other.getPhoneNumber() == null : this.getPhoneNumber().equals(other.getPhoneNumber()))
                && (this.getOccupation() == null ? other.getOccupation() == null : this.getOccupation().equals(other.getOccupation()))
                && (this.getPatGender() == null ? other.getPatGender() == null : this.getPatGender().equals(other.getPatGender()))
                && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
                && (this.getPatContactName() == null ? other.getPatContactName() == null : this.getPatContactName().equals(other.getPatContactName()))
                && (this.getPatContactPhone() == null ? other.getPatContactPhone() == null : this.getPatContactPhone().equals(other.getPatContactPhone()))
                && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
                && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
                && (this.getEditor() == null ? other.getEditor() == null : this.getEditor().equals(other.getEditor()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPatCode() == null) ? 0 : getPatCode().hashCode());
        result = prime * result + ((getPatName() == null) ? 0 : getPatName().hashCode());
        result = prime * result + ((getHospitalId() == null) ? 0 : getHospitalId().hashCode());
        result = prime * result + ((getCardNum() == null) ? 0 : getCardNum().hashCode());
        result = prime * result + ((getCardType() == null) ? 0 : getCardType().hashCode());
        result = prime * result + ((getPatBirth() == null) ? 0 : getPatBirth().hashCode());
        result = prime * result + ((getIdCard() == null) ? 0 : getIdCard().hashCode());
        result = prime * result + ((getPatAge() == null) ? 0 : getPatAge().hashCode());
        result = prime * result + ((getPhoneNumber() == null) ? 0 : getPhoneNumber().hashCode());
        result = prime * result + ((getOccupation() == null) ? 0 : getOccupation().hashCode());
        result = prime * result + ((getPatGender() == null) ? 0 : getPatGender().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getPatContactName() == null) ? 0 : getPatContactName().hashCode());
        result = prime * result + ((getPatContactPhone() == null) ? 0 : getPatContactPhone().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getEditor() == null) ? 0 : getEditor().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", patCode=").append(patCode);
        sb.append(", patName=").append(patName);
        sb.append(", hospitalId=").append(hospitalId);
        sb.append(", cardNum=").append(cardNum);
        sb.append(", cardType=").append(cardType);
        sb.append(", patBirth=").append(patBirth);
        sb.append(", idCard=").append(idCard);
        sb.append(", patAge=").append(patAge);
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", occupation=").append(occupation);
        sb.append(", patGender=").append(patGender);
        sb.append(", address=").append(address);
        sb.append(", patContactName=").append(patContactName);
        sb.append(", patContactPhone=").append(patContactPhone);
        sb.append(", state=").append(state);
        sb.append(", creator=").append(creator);
        sb.append(", editor=").append(editor);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}