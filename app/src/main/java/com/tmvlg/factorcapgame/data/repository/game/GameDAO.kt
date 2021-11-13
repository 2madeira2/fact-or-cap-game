package com.tmvlg.factorcapgame.data.repository.game

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDAO {
    @Query("SELECT * FROM game_table ORDER BY date ASC")
    fun getAllGames(): LiveData<List<Game>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(game: Game)

    @Query(
//      "DELETE FROM game_table WHERE date NOT IN" +
//           "(SELECT date from game_table ORDER BY date DESC LIMIT $gamesInTable);"
            "DELETE FROM game_table;"

    )
    suspend fun deleteUnnecessary()

    companion object {
        const val gamesInTable = 10
    }
}



