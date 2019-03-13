package cn.zlx.ssm.entity;

public class Orders {
    private Integer ordersid;

    private String userphone;

    private Integer houseid;

    private Boolean ispayment;

    public Integer getOrdersid() {
        return ordersid;
    }

    public void setOrdersid(Integer ordersid) {
        this.ordersid = ordersid;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone == null ? null : userphone.trim();
    }

    public Integer getHouseid() {
        return houseid;
    }

    public void setHouseid(Integer houseid) {
        this.houseid = houseid;
    }

    public Boolean getIspayment() {
        return ispayment;
    }

    public void setIspayment(Boolean ispayment) {
        this.ispayment = ispayment;
    }
}