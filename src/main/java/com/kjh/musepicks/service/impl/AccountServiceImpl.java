package com.kjh.musepicks.service.impl;

import com.kjh.musepicks.domain.Account;
import com.kjh.musepicks.dto.account.AccountRequestDto;
import com.kjh.musepicks.dto.account.AccountResponseDto;
import com.kjh.musepicks.repository.AccountRepository;
import com.kjh.musepicks.service.AccountService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    @Transactional
    public void create(AccountRequestDto accountRequestDto) {
        Account account = new Account();

        account.setNickname(accountRequestDto.getNickname());
        account.setName(accountRequestDto.getName());
        account.setPhone_number(accountRequestDto.getPhone_number());
        account.setEmail(accountRequestDto.getEmail());
        account.setGender(accountRequestDto.getGender());
        account.setBirthdate(accountRequestDto.getBirth_date());
        account.setPassword(accountRequestDto.getPassword());

        accountRepository.save(account);
    }


    @Override
    public AccountResponseDto getById(Long id) {
        Account foundAccount = accountRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("no entity"));

        return AccountResponseDto.of(foundAccount);
    }

    @Override
    public List<AccountResponseDto> getAll() {
        return accountRepository.findAll()
                .stream()
                .map(AccountResponseDto::of)
                .toList();
    }

    @Override
    @Transactional
    public void delete(Long id) {
      accountRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("no entity"));
      accountRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateUser(Long id, String name) {
        Account foundAccount = accountRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("no entity"));
        foundAccount.setName(name);
    }

}
