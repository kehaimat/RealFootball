package vn.sunasterisk.realfootball.utils

import android.content.Context
import vn.sunasterisk.realfootball.R

fun Context.getLeaguesId(position: Int) = resources.getStringArray(R.array.leagues_id)[position]
