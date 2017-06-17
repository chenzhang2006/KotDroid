package com.chenzhang.kotdroid.injection

import java.lang.annotation.Documented
import javax.inject.Scope
import kotlin.annotation.AnnotationRetention.RUNTIME

/**
 * Created by czhang000 on 6/17/17.
 */

@Scope
@MustBeDocumented
@Retention(RUNTIME)
annotation class PerActivity