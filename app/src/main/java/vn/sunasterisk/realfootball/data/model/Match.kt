package vn.sunasterisk.realfootball.data.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.text.SimpleDateFormat
import java.util.*

@Entity(tableName = "matches", primaryKeys = ["idEvent"])
@Parcelize
data class Match(
    @SerializedName("idEvent")
    val idEvent: String,
    @SerializedName("dateEvent")
    val dateEvent: String?,
    @SerializedName("idAwayTeam")
    val idAwayTeam: String,
    @SerializedName("idHomeTeam")
    val idHomeTeam: String,
    @SerializedName("idLeague")
    val idLeague: String,
    @SerializedName("idSoccerXML")
    val idSoccerXML: String?,
    @SerializedName("intAwayScore")
    val intAwayScore: String?,
    @SerializedName("intAwayShots")
    val intAwayShots: String?,
    @SerializedName("intHomeScore")
    val intHomeScore: String?,
    @SerializedName("intHomeShots")
    val intHomeShots: String?,
    @SerializedName("intRound")
    val intRound: String?,
    @SerializedName("intSpectators")
    val intSpectators: String?,
    @SerializedName("strAwayFormation")
    val strAwayFormation: String?,
    @SerializedName("strAwayGoalDetails")
    val strAwayGoalDetails: String?,
    @SerializedName("strAwayLineupDefense")
    val strAwayLineupDefense: String?,
    @SerializedName("strAwayLineupForward")
    val strAwayLineupForward: String?,
    @SerializedName("strAwayLineupGoalkeeper")
    val strAwayLineupGoalkeeper: String?,
    @SerializedName("strAwayLineupMidfield")
    val strAwayLineupMidfield: String?,
    @SerializedName("strAwayLineupSubstitutes")
    val strAwayLineupSubstitutes: String?,
    @SerializedName("strAwayRedCards")
    val strAwayRedCards: String?,
    @SerializedName("strAwayTeam")
    val strAwayTeam: String?,
    @SerializedName("strAwayYellowCards")
    val strAwayYellowCards: String?,
    @SerializedName("strBanner")
    val strBanner: String?,
    @SerializedName("strCircuit")
    val strCircuit: String?,
    @SerializedName("strCity")
    val strCity: String?,
    @SerializedName("strCountry")
    val strCountry: String?,
    @SerializedName("strDate")
    val strDate: String,
    @SerializedName("strDescriptionEN")
    val strDescriptionEN: String?,
    @SerializedName("strEvent")
    val strEvent: String?,
    @SerializedName("strFanart")
    val strFanart: String?,
    @SerializedName("strFilename")
    val strFilename: String?,
    @SerializedName("strHomeFormation")
    val strHomeFormation: String?,
    @SerializedName("strHomeGoalDetails")
    val strHomeGoalDetails: String?,
    @SerializedName("strHomeLineupDefense")
    val strHomeLineupDefense: String?,
    @SerializedName("strHomeLineupForward")
    val strHomeLineupForward: String?,
    @SerializedName("strHomeLineupGoalkeeper")
    val strHomeLineupGoalkeeper: String?,
    @SerializedName("strHomeLineupMidfield")
    val strHomeLineupMidfield: String?,
    @SerializedName("strHomeLineupSubstitutes")
    val strHomeLineupSubstitutes: String?,
    @SerializedName("strHomeRedCards")
    val strHomeRedCards: String?,
    @SerializedName("strHomeTeam")
    val strHomeTeam: String?,
    @SerializedName("strHomeYellowCards")
    val strHomeYellowCards: String?,
    @SerializedName("strLeague")
    val strLeague: String,
    @SerializedName("strLocked")
    val strLocked: String?,
    @SerializedName("strMap")
    val strMap: String?,
    @SerializedName("strPoster")
    val strPoster: String?,
    @SerializedName("strResult")
    val strResult: String?,
    @SerializedName("strSeason")
    val strSeason: String?,
    @SerializedName("strSport")
    val strSport: String?,
    @SerializedName("strThumb")
    val strThumb: String?,
    @SerializedName("strTime")
    val strTime: String?
) : Parcelable {
    var matchType: String? = null

    fun isNextMatch(): Boolean {
        dateEvent?.let {
            val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val date: Date = dateFormat.parse(it)
            return date.after(Date())
        }
        return false
    }

    fun getStartTime(): Long? {
        if (dateEvent == null || strTime == null) return null
        val time = "$dateEvent $strTime"
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
        val date: Date = dateFormat.parse(time)
        return date.time
    }

    fun format(strHomeGoalDetails: String?) =
        strHomeGoalDetails?.replace(";\\s?".toRegex(), "\n") ?: "-"
}
