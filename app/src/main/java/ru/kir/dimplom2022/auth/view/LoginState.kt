package ru.kir.dimplom2022.auth.view

data class LoginState(
    val login: String? = null,
    val phone: String? = null,
    val bankName: String? = null,
    val integrationId: String? = null,
    val isLoading: Boolean = false,
    val isMultiplyForm: Boolean = false
)