package com.example.android.codelabs.paging.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface RemoteKeysDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteKeys: List<RemoteKeys>)

    @Query("SELECT * FROM remote_keys WHERE repoId = :repoId")
    suspend fun remoteKeysRepoId(repoId: Long): RemoteKeys?

    @Query("DELETE FROM remote_keys")
    suspend fun clearRemoteKeys()
}