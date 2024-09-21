package com.kjh.musepicks.repository;

import com.kjh.musepicks.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
