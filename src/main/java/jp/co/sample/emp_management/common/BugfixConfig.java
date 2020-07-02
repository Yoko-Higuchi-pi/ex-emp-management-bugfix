package jp.co.sample.emp_management.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * パスワードのハッシュ化を行います.
 * 
 * @author yoko.higuchi
 *
 */
@Configuration
class BugfixConfig extends WebSecurityConfigurerAdapter {
    /**
     * セキュリティ設定を無視します.
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/img/**", "/js/**");
    }
	
	
    /**
     * 既に用意されているログイン画面に遷移するメソッドであるため、overrideしてその設定を消します.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    }
}
