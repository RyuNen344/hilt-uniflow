package com.ryunen344.hilt.uniflow

import io.uniflow.core.flow.data.UIEvent
import io.uniflow.core.flow.data.UIState
import io.uniflow.core.logger.Logger
import io.uniflow.core.logger.UniFlowLogger
import timber.log.Timber

class TimberLogger(private val tag: String = UniFlowLogger.TAG) : Logger {

    override fun log(message: String) {
        Timber.log(Timber.DEBUG, tag, null, message)
    }

    override fun logState(state: UIState) {
        Timber.log(Timber.DEBUG, tag, null, "[STATE] - $state")
    }

    override fun logEvent(event: UIEvent) {
        Timber.log(Timber.DEBUG, tag, null, "<EVENT> - $event")
    }

    override fun logError(errorMessage: String, error: Exception?) {
        Timber.log(Timber.WARNING, tag, error, "!ERROR! :: $error")
    }
}
