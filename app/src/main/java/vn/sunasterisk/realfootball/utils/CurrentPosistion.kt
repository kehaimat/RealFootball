package vn.sunasterisk.realfootball.utils

import androidx.annotation.IntDef

@IntDef(
    CurrentPosistion.OVERVIEW,
    CurrentPosistion.STADIUM,
    CurrentPosistion.INFORMATION
)
annotation class CurrentPosistion {
    companion object {
        const val OVERVIEW = 0
        const val STADIUM = 1
        const val INFORMATION = 2
    }
}
