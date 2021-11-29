package com.tmvlg.factorcapgame.data.repository.firebase

import android.os.Parcelable
import android.util.Log
import kotlinx.parcelize.Parcelize

@Parcelize
data class Player(
    var id: String = "0",
    var loaded: Boolean = false,
    var playerName: String = "",
    var score: Int = 0,
    var timeElapsed: Long = 0,
    var waiting: Boolean = false,
    var isWinner: Boolean = false
) : Parcelable {
    fun toMutableMap(): MutableMap<String, Any?> {
        return mutableMapOf(
            "loaded" to loaded,
            "playerName" to playerName,
            "score" to score,
            "timeElapsed" to timeElapsed,
            "waiting" to waiting
        )
    }

    companion object {
        fun newInstance(key: String, map: Map<String, Any?>): Player {
            return Player().apply {
                Log.d("Player.newInstance", "$map")
                id = key
                loaded = map["loaded"] as Boolean?
                    ?: throw IllegalFieldException("loaded")
                playerName = map["playerName"] as String?
                    ?: throw IllegalFieldException("playerName")
                val longScore = map["score"] as Long?
                    ?: throw IllegalFieldException("score")
                score = longScore.toInt()
                timeElapsed = map["timeElapsed"] as Long?
                    ?: throw IllegalFieldException("score")
                waiting = map["waiting"] as Boolean?
                    ?: throw IllegalArgumentException("map does not contain field <roomName>")
            }
        }

        private fun IllegalFieldException(field: String): IllegalArgumentException {
            return IllegalArgumentException("map does not contain field<$field>")
        }
    }
}