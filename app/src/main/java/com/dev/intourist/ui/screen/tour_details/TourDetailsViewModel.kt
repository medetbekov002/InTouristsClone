package com.dev.intourist.ui.screen.tour_detailsimport androidx.lifecycle.LiveDataimport com.dev.intourist.common.UIStateimport com.dev.intourist.data.remote.dtos.contacts.ContactModelimport com.dev.intourist.data.remote.dtos.tours.ToursModelimport com.dev.intourist.domain.usecase.ContactsUseCaseimport com.dev.intourist.domain.usecase.TourUseCaseimport com.dev.intourist.presentation.base.viewmodel.BaseViewModelimport kotlinx.coroutines.flow.StateFlowclass TourDetailsViewModel(private val useCase: TourUseCase, private val contactUseCase: ContactsUseCase) : BaseViewModel() {    suspend fun getTourById(id:Int) = useCase.getTourById(id)    suspend fun getAllTours(pageSize: Int): StateFlow<UIState<ToursModel>> = useCase.getAllTours(pageSize = pageSize)    suspend fun getContacts(): LiveData<UIState<ContactModel>> = contactUseCase.getContacts()}