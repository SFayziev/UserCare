package com.sh.usercare.db.map.bill;

import com.sh.usercare.db.map.IntEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;

/**
 * Created by Admin on 15.03.2016.
 */

@Entity
@Table(name = "payment",  catalog = "usercare")
public class PaymentDTO extends IntEntity {

    private BigDecimal amount;
    private Date date1;
    private  String method;
    private  Integer balanceid;
    private Long  projid;


    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Integer getBalanceid() {
        return balanceid;
    }

    public void setBalanceid(Integer balanceid) {
        this.balanceid = balanceid;
    }

    public Long getProjid() {
        return projid;
    }

    public void setProjid(Long projid) {
        this.projid = projid;
    }

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "amount=" + amount +
                ", date1=" + date1 +
                ", method='" + method + '\'' +
                ", balanceid=" + balanceid +
                ", projid=" + projid +
                '}';
    }
}
