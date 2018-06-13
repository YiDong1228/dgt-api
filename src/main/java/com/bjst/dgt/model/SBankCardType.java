package com.bjst.dgt.model;

import javax.persistence.*;

@Table(name = "s_bank_card_type")
public class SBankCardType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "bankName")
    private String bankname;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return bankName
     */
    public String getBankname() {
        return bankname;
    }

    /**
     * @param bankname
     */
    public void setBankname(String bankname) {
        this.bankname = bankname;
    }
}