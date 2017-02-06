package com.devil.effective.annotation.retention;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyRetention {
	// 在运行时有效（即运行时保留）
}
