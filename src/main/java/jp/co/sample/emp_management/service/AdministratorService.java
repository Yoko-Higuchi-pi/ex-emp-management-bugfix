package jp.co.sample.emp_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.sample.emp_management.domain.Administrator;
import jp.co.sample.emp_management.repository.AdministratorRepository;

/**
 * 管理者情報を操作するサービス.
 * 
 * @author igamasayuki
 *
 */
@Service
@Transactional
public class AdministratorService {
	
	@Autowired
	private AdministratorRepository administratorRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
	
    /**
     * Bcrypt　アルゴリズムに変換します.
     * 
     * @return
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	/**
	 * 管理者情報を登録します.
	 * 
	 * @param administrator　管理者情報
	 */
	public void insert(Administrator administrator) {
		administrator.setPassword(passwordToHash(administrator.getPassword()));
		
		administratorRepository.insert(administrator);
	}
	
	/**
	 * メールアドレスが登録されているかを確認します.
	 * 
	 * @param mailAddress 登録するメールアドレス
	 * @return 登録情報
	 */
	public Administrator findByMailAddress(String mailAddress) {
		return administratorRepository.findByMailAddress(mailAddress);
	}
	
	/**
	 * ログインをします.
	 * @param mailAddress メールアドレス
	 * @param password パスワード
	 * @return 管理者情報　存在しない場合はnullが返ります
	 */
	public Administrator login(String mailAddress, String password) {
		String hashPassword = passwordToHash(password);
		Administrator administrator = administratorRepository.findByMailAddressAndPassward(mailAddress);
		// パスワードがハッシュ化したものと一致する場合はその値を返す
		if (passwordEncoder.matches(password, administrator.getPassword())) {
			return administrator;
		}
		return null;
	}
	
	private String passwordToHash(String password) {
		// パスワードのハッシュ化
		return passwordEncoder.encode(password);
	}
}
