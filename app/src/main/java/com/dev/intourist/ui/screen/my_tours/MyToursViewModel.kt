package com.dev.intourist.ui.screen.my_toursimport androidx.lifecycle.LiveDataimport com.dev.intourist.common.UIStateimport com.dev.intourist.data.remote.dtos.tours.ToursModelimport com.dev.intourist.domain.usecase.TourUseCaseimport com.dev.intourist.presentation.base.viewmodel.BaseViewModelclass MyToursViewModel(private val useCase: TourUseCase) : BaseViewModel() {    suspend fun getAllTours(pageSize: Int): LiveData<UIState<ToursModel>> = useCase.getAllTours(pageSize = pageSize)}