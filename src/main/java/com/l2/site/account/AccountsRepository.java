package com.l2.site.account;

import com.l2.site.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsRepository extends JpaRepository<Account, String> {
  Account findByL2email(String email);
}
