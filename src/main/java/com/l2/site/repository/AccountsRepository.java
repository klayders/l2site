package com.l2.site.repository;

import com.l2.site.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsRepository extends JpaRepository<Accounts, String> {
}
