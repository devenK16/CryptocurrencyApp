package com.example.cryptocurrencyapp.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocurrencyapp.common.Constants
import com.example.cryptocurrencyapp.common.Resource
import com.example.cryptocurrencyapp.domain.use_case.get_coin.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CoinDetailtState())
    val state: State<CoinDetailtState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let{coinId->
            getCoin(coinId)
        }
    }

    private fun getCoin(coinId: String) {
        getCoinUseCase(coinId).onEach { result ->
            when (result) {
                is Resource.Error -> {
                    _state.value = CoinDetailtState(
                        error = result.message ?: "An Unexpected Error Occurred"
                    )
                }

                is Resource.Loading -> {
                    _state.value = CoinDetailtState(isLoading = true)
                }

                is Resource.Success -> {
                    _state.value = CoinDetailtState(coin = result.data)
                }
            }

        }.launchIn(viewModelScope)
    }
}