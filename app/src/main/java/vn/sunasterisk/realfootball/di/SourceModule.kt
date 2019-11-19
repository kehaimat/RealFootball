package vn.sunasterisk.realfootball.di

import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import vn.sunasterisk.realfootball.FootballApplication
import vn.sunasterisk.realfootball.base.ContextProviders
import vn.sunasterisk.realfootball.data.local.FootBallDb
import vn.sunasterisk.realfootball.data.repository.MatchRepository
import vn.sunasterisk.realfootball.ui.match.MatchViewModel

val sourceModule = module {
    single { ContextProviders() }
    single { FootBallDb.getDatabase().matchDao() }
    single { FootBallDb.getDatabase().playerDao() }
    single { FootBallDb.getDatabase().teamDao() }
    single { MatchRepository(get(), get(named(RemoteProperties::class.java.name)), get()) }
}
val viewModelModule = module {
    single(named(FootballApplication::class.java.name)) { androidApplication() }
    viewModel { MatchViewModel(get(named(FootballApplication::class.java.name)), get()) }
}
