package net.simplifiedcoding.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.simplifiedcoding.data.db.AppDatabase
import net.simplifiedcoding.data.db.UserDao
import net.simplifiedcoding.data.network.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

  @Singleton
  @Provides
  fun provideUsersDao(
    @ApplicationContext context: Context
  ): UserDao {
    return AppDatabase(context).getUserDao()
  }

  @Singleton
  @Provides
  fun provideUserApi(
    remoteDataSource: RemoteDataSource
  ): UsersApi {
    return remoteDataSource.buildApi(UsersApi::class.java)
  }
}