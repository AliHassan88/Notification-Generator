package com.kravia.notificationgenerator.debtor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DebtorRepository extends JpaRepository<Debtor,Long> {
    Debtor findDebtorByAddress(String address);
}
