package com.kravia.notificationgenerator.creditor;

import com.kravia.notificationgenerator.debtor.Debtor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Creditor")
public class Creditor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "creditor_id", referencedColumnName = "id")
    List<Debtor> debtors = new ArrayList<Debtor>();

    public Creditor() {
    }

    public Creditor(List<Debtor> debtors) {
        this.debtors = debtors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Debtor> getDefaulters() {
        return debtors;
    }

    public void setDefaulters(List<Debtor> debtors) {
        this.debtors = debtors;
    }
}
