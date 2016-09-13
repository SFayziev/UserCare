package com.sh.usercare.db.map.bill;

import com.sh.usercare.db.map.IntEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Admin on 15.03.2016.
 */

@Entity
@Table(name = "order",  catalog = "usercare")
public class OrderDTO extends IntEntity {

    private  Long projid;

//    private  Integer  tariffid;
    private  Date date1;
    private  Date date2;
    private  OrderStatus status;

    public OrderDTO() {

    }


    public OrderDTO(Long projid, TariffDTO tariffDTO) {
        this.projid = projid;
        this.tariffDTO = tariffDTO;
        this.date1 = new Date();
        this.status = OrderStatus.Wait;
    }

    public Long getProjid() {
        return projid;
    }

    public void setProjid(Long projid) {
        this.projid = projid;
    }

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.DETACH )
    @JoinColumn(name = "tariffid")
    TariffDTO tariffDTO;

    public TariffDTO getTariffDTO() {
        return tariffDTO;
    }

    public void setTariffDTO(TariffDTO tariffDTO) {
        this.tariffDTO = tariffDTO;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "projid=" + projid +
                ", tariffDTO =" + tariffDTO +
                ", date1=" + date1 +
                ", date2=" + date2 +
                ", status=" + status +
                '}';
    }
}
