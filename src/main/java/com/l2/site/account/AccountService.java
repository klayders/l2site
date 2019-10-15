package com.l2.site.account;

import com.l2.site.model.account.AccountSnapshot;
import com.l2.site.model.account.Accounts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AccountService {

  private final AccountsRepository accountsRepository;

  public AccountSnapshot getAccountById(String id) {
    return accountsRepository.findById(id)
      .map(AccountSnapshot::withCharacters)
      .orElse(null);
  }

  @Transactional
  public AccountSnapshot save(Accounts accounts) {
    return AccountSnapshot.of(accountsRepository.save(accounts));
  }

  public List<AccountSnapshot> findAll() {
    return accountsRepository
      .findAll()
      .stream()
      .map(AccountSnapshot::withCharacters)
      .collect(toList());
  }
}
