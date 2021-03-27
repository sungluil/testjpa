package com.example.testjpa.account;

import com.querydsl.core.QueryFactory;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class AccountQueryRepository {

    QAccount account = QAccount.account;
    private final JPAQueryFactory queryFactory;

    public List<Account> findByNickname(String nickname) {
        return queryFactory.selectFrom(account)
                .where(eqNickname(nickname))
                .fetch();
    }

    private BooleanExpression eqNickname(String nickname) {
        if(StringUtils.isEmpty(nickname)) {
            return null;
        }
        return account.nickname.eq(nickname);
    }


    @Transactional(readOnly = true)
    public Boolean exists(Long id) {
        Integer fetchOne = queryFactory
                .selectOne()
                .from(account)
                .where(account.id.eq(id))
                .fetchOne();
        return fetchOne != null;
    }


}
