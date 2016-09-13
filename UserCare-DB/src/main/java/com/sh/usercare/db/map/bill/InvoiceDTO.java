package com.sh.usercare.db.map.bill;

import com.sh.usercare.db.map.IntEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Admin on 15.03.2016.
 */

@Entity
@Table(name = "invoice",  catalog = "usercare")
public class InvoiceDTO extends IntEntity {


//    `balanceid` int(11) NOT NULL,
    private Date date1 = new Date();
    private Date date2;
    private Date  total;
    private OrderStatus status;
//            `projid` int(11) NOT NULL,
    private BigDecimal subtotal = BigDecimal.ZERO;
    private BigDecimal tax = BigDecimal.ZERO;
    private BigDecimal credit = BigDecimal.ZERO;

    public InvoiceDTO() {

    }

    public InvoiceDTO( BalanceDTO balanceDTO, Date date2 ) {
        this.date2 = date2;
        this.date1 = new Date();
        this.balanceDTO = balanceDTO;
        this.setStatus( OrderStatus.Wait );
    }

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.DETACH )
    @JoinColumn(name = "balanceid")
    private BalanceDTO balanceDTO;

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

    public Date getTotal() {
        return total;
    }

    public void setTotal(Date total) {
        this.total = total;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    public BalanceDTO getBalanceDTO() {
        return balanceDTO;
    }

    public void setBalanceDTO(BalanceDTO balanceDTO) {
        this.balanceDTO = balanceDTO;
    }

    @Override
    public String toString() {
        return "InvoiceDTO{" +
                "date1=" + date1 +
                ", date2=" + date2 +
                ", total=" + total +
                ", status=" + status +
                ", subtotal=" + subtotal +
                ", tax=" + tax +
                ", credit=" + credit +
                ", balanceDTO=" + balanceDTO +
                "} " + super.toString();
    }
}
