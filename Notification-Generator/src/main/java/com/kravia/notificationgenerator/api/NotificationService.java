package com.kravia.notificationgenerator.api;

import com.kravia.notificationgenerator.creditor.Creditor;
import com.kravia.notificationgenerator.creditor.CreditorRepository;
import com.kravia.notificationgenerator.debtor.Debtor;
import com.kravia.notificationgenerator.debtor.DebtorRepository;
import com.kravia.notificationgenerator.notification.NotificationRepository;
import com.kravia.notificationgenerator.posten.Posten;
import com.kravia.notificationgenerator.posten.PostenRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    Logger logger = LoggerFactory.getLogger(NotificationService.class);

    @Autowired
    PostenRepository postenRepository;

    @Autowired
    DebtorRepository debtorRepository;

    @Autowired
    CreditorRepository creditorRepository;

    @Autowired
    NotificationRepository notificationRepository;

    Debtor createDefaulter(Posten posten) {
        Debtor debtor= debtorRepository.findDebtorByAddress(posten.getAddress());
        debtor.setDefaulterStatus(true);
        debtorRepository.save(debtor);
        return debtor;
    }

    Debtor createDebtor(Debtor debtor) {
        return debtorRepository.save(debtor);
    }

    Creditor createCreditor(Creditor creditor) {
        return creditorRepository.save(creditor);
    }
}
