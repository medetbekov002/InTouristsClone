package com.dev.intourist.domain.usecase

import android.content.Context
import com.dev.intourist.presentation.model.validation.ValidationResult
import com.dev.intourist.presentation.model.validation.Validator
import com.dev.intourist.R
import javax.inject.Inject

class ValidatePhone constructor(
    private val context: Context,
) : Validator {

    override operator fun invoke(text: String): ValidationResult = when {
        text.isEmpty() -> {
            ValidationResult(
                isSuccessful = false,
                context.getString(R.string.field_must_be_filled)
            )
        }

        text.length < 18 -> {
            ValidationResult(
                isSuccessful = false,
                context.getString(R.string.complete_your_phone_number)
            )
        }

        else -> {
            ValidationResult(
                isSuccessful = true,
            )
        }
    }
}