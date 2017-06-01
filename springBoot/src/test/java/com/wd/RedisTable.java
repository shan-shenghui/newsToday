package com.wd;

import java.util.Date;

/**
 * Created by aaa on 2017/5/5.
 */
public class RedisTable {
    private Long redisId; //保存redis的主键ID
    private String redisType;//redis的类型如：set/list/hash/sortedset/string
    private String redisKey;//保存redis时使用的key
    private String objectName;//此属性主要用于hash数据结构时，保存member的
    private String redisValue;//存储的redis的值
    private String keyToken;//保存Token时，为区分拼接的字符串
    private String score;//此属性为sortedset数据结构时，保存的score值
    private Date createTime;//创建时间
    private Date updateTime;//更新时间
    private String macIp;//redis的IP地址  当然此处也可以存储mac地址
    private String port;//redis使用的端口号
    private String remark;//备注
    private String isModify;//是否修改。此属性可以用于增量备份时，即在每个redis存储时可以更具key多存储一个属性isModify。 如果有修改，则置为 Y,否则为N.

    public Long getRedisId() {
        return redisId;
    }

    public void setRedisId(Long redisId) {
        this.redisId = redisId;
    }

    public String getRedisType() {
        return redisType;
    }

    public void setRedisType(String redisType) {
        this.redisType = redisType;
    }

    public String getRedisKey() {
        return redisKey;
    }

    public void setRedisKey(String redisKey) {
        this.redisKey = redisKey;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getRedisValue() {
        return redisValue;
    }

    public void setRedisValue(String redisValue) {
        this.redisValue = redisValue;
    }

    public String getKeyToken() {
        return keyToken;
    }

    public void setKeyToken(String keyToken) {
        this.keyToken = keyToken;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getMacIp() {
        return macIp;
    }

    public void setMacIp(String macIp) {
        this.macIp = macIp;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getIsModify() {
        return isModify;
    }

    public void setIsModify(String isModify) {
        this.isModify = isModify;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RedisTable)) return false;

        RedisTable that = (RedisTable) o;

        if (redisId != null ? !redisId.equals(that.redisId) : that.redisId != null) return false;
        if (redisType != null ? !redisType.equals(that.redisType) : that.redisType != null) return false;
        if (redisKey != null ? !redisKey.equals(that.redisKey) : that.redisKey != null) return false;
        if (objectName != null ? !objectName.equals(that.objectName) : that.objectName != null) return false;
        if (redisValue != null ? !redisValue.equals(that.redisValue) : that.redisValue != null) return false;
        if (keyToken != null ? !keyToken.equals(that.keyToken) : that.keyToken != null) return false;
        if (score != null ? !score.equals(that.score) : that.score != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (macIp != null ? !macIp.equals(that.macIp) : that.macIp != null) return false;
        if (port != null ? !port.equals(that.port) : that.port != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        return isModify != null ? isModify.equals(that.isModify) : that.isModify == null;
    }

    @Override
    public int hashCode() {
        int result = redisId != null ? redisId.hashCode() : 0;
        result = 31 * result + (redisType != null ? redisType.hashCode() : 0);
        result = 31 * result + (redisKey != null ? redisKey.hashCode() : 0);
        result = 31 * result + (objectName != null ? objectName.hashCode() : 0);
        result = 31 * result + (redisValue != null ? redisValue.hashCode() : 0);
        result = 31 * result + (keyToken != null ? keyToken.hashCode() : 0);
        result = 31 * result + (score != null ? score.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (macIp != null ? macIp.hashCode() : 0);
        result = 31 * result + (port != null ? port.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (isModify != null ? isModify.hashCode() : 0);
        return result;
    }
}
