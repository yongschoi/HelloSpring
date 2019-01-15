package yongs.temp.mapper;

import org.apache.ibatis.annotations.Param;

import yongs.temp.vo.Account;

public interface AccountMapper {
	/* 계좌 조회 */
	public Account selectAccount(@Param("no") String no);

	/* balance 업데이트 */
	public void updateAccount(@Param("account") Account account);
}
