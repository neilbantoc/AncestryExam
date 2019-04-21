package neilbantoc.ancestry.base

import neilbantoc.ancestry.App
import neilbantoc.framework.base.BaseActivityContainer

open class BaseActivity() : BaseActivityContainer() {
    fun getApp(): App {
        return application as App
    }
}