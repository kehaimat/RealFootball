package vn.sunasterisk.realfootball.data.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import vn.sunasterisk.realfootball.extension.formatNumber

@Entity(tableName = "players", primaryKeys = ["idPlayer", "idTeam"])
data class Player(
    @SerializedName("idPlayer")
    val idPlayer: String,
    @SerializedName("idTeam")
    val idTeam: String,
    @SerializedName("dateBorn")
    val dateBorn: String,
    @SerializedName("dateSigned")
    val dateSigned: String,
    @SerializedName("idPlayerManager")
    val idPlayerManager: String?,
    @SerializedName("idSoccerXML")
    val idSoccerXML: String?,
    @SerializedName("intLoved")
    val intLoved: String?,
    @SerializedName("intSoccerXMLTeamID")
    val intSoccerXMLTeamID: String?,
    @SerializedName("strBanner")
    val strBanner: String?,
    @SerializedName("strBirthLocation")
    val strBirthLocation: String?,
    @SerializedName("strCollege")
    val strCollege: String?,
    @SerializedName("strCutout")
    val strCutout: String?,
    @SerializedName("strDescriptionEN")
    val strDescriptionEN: String,
    @SerializedName("strFacebook")
    val strFacebook: String?,
    @SerializedName("strFanart1")
    val strFanart1: String?,
    @SerializedName("strFanart2")
    val strFanart2: String?,
    @SerializedName("strFanart3")
    val strFanart3: String?,
    @SerializedName("strFanart4")
    val strFanart4: String?,
    @SerializedName("strGender")
    val strGender: String?,
    @SerializedName("strHeight")
    val strHeight: String?,
    @SerializedName("strInstagram")
    val strInstagram: String?,
    @SerializedName("strLocked")
    val strLocked: String?,
    @SerializedName("strNationality")
    val strNationality: String?,
    @SerializedName("strPlayer")
    val strPlayer: String?,
    @SerializedName("strPosition")
    val strPosition: String,
    @SerializedName("strSigning")
    val strSigning: String?,
    @SerializedName("strSport")
    val strSport: String?,
    @SerializedName("strTeam")
    val strTeam: String?,
    @SerializedName("strThumb")
    val strThumb: String?,
    @SerializedName("strTwitter")
    val strTwitter: String?,
    @SerializedName("strWage")
    val strWage: String?,
    @SerializedName("strWebsite")
    val strWebsite: String?,
    @SerializedName("strWeight")
    val strWeight: String?,
    @SerializedName("strYoutube")
    val strYoutube: String?
) {
    fun getWeight() = strWeight?.formatNumber()
    fun getHeight() = strHeight?.formatNumber()
}
