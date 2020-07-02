package jp.co.sample.emp_management.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 500エラー発生時にエラー出力後、 error/500.html を表示します.
 * 
 * @author yoko.higuchi
 *
 */
public class GlobalExcepionHandler implements HandlerExceptionResolver {
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(GlobalExcepionHandler.class);
	
	/**
	 * エラー出力後、 500.html を表示します.
	 *
	 */
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		LOGGER.error("error!", ex);
		return null;
	}

}
