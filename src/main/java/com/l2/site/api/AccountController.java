package com.l2.site.api;

import com.l2.site.account.AccountService;
import com.l2.site.model.account.AccountSnapshot;
import com.l2.site.model.jwt.CurrentUser;
import com.l2.site.model.jwt.JwtUser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.l2.site.utils.SiteUtils.API;

@RestController
@RequestMapping(AccountController.ACCOUNT_MAPPING)
@RequiredArgsConstructor
public class AccountController {

  private static final String VERSION = "/v1";
  static final String ACCOUNT_MAPPING = API + VERSION + "/account";

  private final AccountService accountService;

  @GetMapping
  public List<AccountSnapshot> findAll() {
    return accountService.findAll();
  }

  @GetMapping("/{login}")
  public AccountSnapshot getByLogin(@PathVariable String login) {
    return accountService.getAccountById(login);
  }


  @GetMapping("/profile")
  public JwtUser profile(@CurrentUser JwtUser jwtUser) {
    return jwtUser;
  }
}
