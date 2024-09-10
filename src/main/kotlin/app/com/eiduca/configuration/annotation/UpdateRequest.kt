package app.com.eiduca.configuration.annotation

import app.com.eiduca.module.core.constant.MessageDoc
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import jakarta.transaction.Transactional
import java.lang.annotation.Inherited

@Inherited
@Transactional
@ApiResponses(value = [
    ApiResponse(responseCode = MessageDoc.STATUS_UPDATE, description = MessageDoc.UPDATE),
    ApiResponse(responseCode = MessageDoc.STATUS_FAILED, description = MessageDoc.FAILED),
    ApiResponse(responseCode = MessageDoc.STATUS_NOT_FOUND, description = MessageDoc.NOT_FOUND),
    ApiResponse(responseCode = MessageDoc.STATUS_PERMISSION_DENIED, description = MessageDoc.PERMISSION_DENIED)
])
annotation class UpdateRequest
