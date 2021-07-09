/**
 * 
 */
package com.boot.study.config.auth;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author ksh123
 * SessionUser에 대한 반복되는 코드를 개선하기 위해 LoginUser annotaiton을 등록한다.
 */

@Target(ElementType.PARAMETER) // 이 어노테이션이 생성될 수 있는 위치를 지정, 파라미터로 지정된 객체에게만 선언이 가능하다.
@Retention(RetentionPolicy.RUNTIME) // 컴파일 이후에도 JVM에 의해 참조가 가능(Runtime에서 참조가 가능하도록 선언
public @interface LoginUser { // @LoginUser라는 어노테이션이 생성된것.
}
